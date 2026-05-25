package co.nstant.in.cbor;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.TreeMap;
import co.nstant.in.cbor.model.AdditionalInformation;
import co.nstant.in.cbor.model.Array;
import co.nstant.in.cbor.model.ByteString;
import co.nstant.in.cbor.model.DataItem;
import co.nstant.in.cbor.model.DoublePrecisionFloat;
import co.nstant.in.cbor.model.HalfPrecisionFloat;
import co.nstant.in.cbor.model.MajorType;
import co.nstant.in.cbor.model.Map;
import co.nstant.in.cbor.model.NegativeInteger;
import co.nstant.in.cbor.model.SimpleValue;
import co.nstant.in.cbor.model.SimpleValueType;
import co.nstant.in.cbor.model.SinglePrecisionFloat;
import co.nstant.in.cbor.model.Special;
import co.nstant.in.cbor.model.Tag;
import co.nstant.in.cbor.model.UnicodeString;
import co.nstant.in.cbor.model.UnsignedInteger;

class CborOutputStream extends OutputStream {

    private static final BigInteger MINUS_ONE = BigInteger.valueOf(-1);

    private static final BigInteger UINT64_MAX_PLUS_ONE = new BigInteger("18446744073709551616");

    private final OutputStream outputStream;

    private boolean canonical = true;

    public CborOutputStream(OutputStream outputStream) {
        this.outputStream = outputStream;
    }

    public boolean isCanonical() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public void setCanonical(boolean canonical) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public void writeDataItem(DataItem dataItem) throws IOException {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    private void writeUnsignedInteger(UnsignedInteger dataItem) throws IOException {
        writeType(MajorType.UNSIGNED_INTEGER, dataItem.getValue());
    }

    private void writeNegativeInteger(NegativeInteger dataItem) throws IOException {
        writeType(MajorType.NEGATIVE_INTEGER, MINUS_ONE.subtract(dataItem.getValue()).abs());
    }

    private void writeByteString(ByteString byteString) throws IOException {
        byte[] bytes = byteString.getBytes();
        if (byteString.isChunked()) {
            writeIndefiniteLengthType(MajorType.BYTE_STRING);
            if (bytes == null) {
                return;
            }
        } else if (bytes == null) {
            writeSpecial(SimpleValue.NULL);
            return;
        }
        writeType(MajorType.BYTE_STRING, bytes.length);
        write(bytes);
    }

    private void writeUnicodeString(UnicodeString dataItem) throws IOException {
        String string = dataItem.getString();
        if (dataItem.isChunked()) {
            writeIndefiniteLengthType(MajorType.UNICODE_STRING);
            if (string == null) {
                return;
            }
        } else if (string == null) {
            writeSpecial(SimpleValue.NULL);
            return;
        }
        byte[] bytes = string.getBytes(StandardCharsets.UTF_8);
        writeType(MajorType.UNICODE_STRING, bytes.length);
        write(bytes);
    }

    private void writeArray(Array array) throws IOException {
        List<DataItem> dataItems = array.getDataItems();
        if (array.isChunked()) {
            writeIndefiniteLengthType(MajorType.ARRAY);
        } else {
            writeType(MajorType.ARRAY, dataItems.size());
        }
        for (DataItem dataItem : dataItems) {
            writeDataItem(dataItem);
        }
    }

    private void writeMap(Map map) throws IOException {
        Collection<DataItem> keys = map.getKeys();
        if (map.isChunked()) {
            writeIndefiniteLengthType(MajorType.MAP);
        } else {
            writeType(MajorType.MAP, keys.size());
        }
        if (keys.isEmpty()) {
            return;
        }
        if (map.isChunked()) {
            writeNonCanonicalMap(map);
            writeSpecial(SimpleValue.BREAK);
        } else {
            if (canonical) {
                writeCanonicalMap(map);
            } else {
                writeNonCanonicalMap(map);
            }
        }
    }

    private void writeNonCanonicalMap(Map map) throws IOException {
        for (DataItem key : map.getKeys()) {
            writeDataItem(key);
            writeDataItem(map.get(key));
        }
    }

    /**
     * Writes the map in the canonical CBOR format.
     *
     * <p>From <a href="https://tools.ietf.org/html/rfc7049#section-3.9">RFC 7049</a>:
     *
     * <p>The keys in every map must be sorted lowest value to highest. Sorting is performed on the
     * bytes of the representation of the key data items without paying attention to the 3/5 bit
     * splitting for major types. (Note that this rule allows maps that have keys of different
     * types, even though that is probably a bad practice that could lead to errors in some
     * canonicalization implementations.) The sorting rules are:
     *
     * <p>If two keys have different lengths, the shorter one sorts earlier;
     *
     * <p>If two keys have the same length, the one with the lower value in (byte-wise) lexical order
     * sorts earlier.
     */
    private void writeCanonicalMap(Map map) throws IOException {
        TreeMap<byte[], byte[]> sortedMap = new TreeMap<>(new Comparator<byte[]>() {

            @Override
            public int compare(byte[] o1, byte[] o2) {
                throw new UnsupportedOperationException("STUB: not implemented");
            }
        });
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        CborOutputStream cborOutputStream = new CborOutputStream(byteArrayOutputStream);
        for (DataItem key : map.getKeys()) {
            // Key
            cborOutputStream.writeDataItem(key);
            byte[] keyBytes = byteArrayOutputStream.toByteArray();
            byteArrayOutputStream.reset();
            // Value
            cborOutputStream.writeDataItem(map.get(key));
            byte[] valueBytes = byteArrayOutputStream.toByteArray();
            byteArrayOutputStream.reset();
            sortedMap.put(keyBytes, valueBytes);
        }
        for (java.util.Map.Entry<byte[], byte[]> entry : sortedMap.entrySet()) {
            write(entry.getKey());
            write(entry.getValue());
        }
    }

    void writeSpecial(Special dataItem) throws IOException {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    private void writeHalfPrecisionFloat(HalfPrecisionFloat dataItem) throws IOException {
        int bits = fromFloat(dataItem.getValue());
        writeBytes((byte) ((7 << 5) | 25), (byte) ((bits >> 8) & 0xFF), (byte) ((bits >> 0) & 0xFF));
    }

    /**
     * @param fval the float value
     * @return all higher 16 bits as 0 for all results
     * @see <a href="http://stackoverflow.com/a/6162687">Stack Overflow</a>
     */
    private static int fromFloat(float fval) {
        int fbits = Float.floatToIntBits(fval);
        // sign only
        int sign = fbits >>> 16 & 0x8000;
        // rounded value
        int val = 0x1000 + fbits & 0x7fffffff;
        if (// might be or become NaN/Inf
        val >= 0x47800000) {
            // avoid Inf due to rounding
            if ((fbits & 0x7fffffff) >= 0x47800000) {
                // is or must become
                // NaN/Inf
                if (val < 0x7f800000) {
                    // was value but too large
                    // make it +/-Inf
                    return sign | 0x7c00;
                }
                return // remains +/-Inf or NaN
                sign | 0x7c00 | // keep NaN (and
                (fbits & 0x007fffff) >>> 13;
                // Inf) bits
            }
            // unrounded not quite Inf
            return sign | 0x7bff;
        }
        if (val >= 0x38800000) {
            // remains normalized value
            // exp - 127 + 15
            return sign | val - 0x38000000 >>> 13;
        }
        if (val < 0x33000000) {
            // too small for subnormal
            // becomes +/-0
            return sign;
        }
        // tmp exp for subnormal calc
        val = (fbits & 0x7fffffff) >>> 23;
        return sign | (// add subnormal bit
        (fbits & 0x7fffff | 0x800000) + // round depending on cut off
        (0x800000 >>> val - 102) >>> // div by 2^(1-(exp-127+15)) and >> 13 | exp=0
        126 - val);
    }

    public void writeSinglePrecisionFloat(SinglePrecisionFloat dataItem) throws IOException {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public void writeDoublePrecisionFloat(DoublePrecisionFloat dataItem) throws IOException {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    private void writeTag(Tag tag) throws IOException {
        writeType(MajorType.TAG, tag.getValue());
    }

    private void writeIndefiniteLengthType(MajorType majorType) throws IOException {
        int symbol = majorType.getValue() << 5;
        symbol |= AdditionalInformation.INDEFINITE.getValue();
        outputStream.write(symbol);
    }

    private void writeType(MajorType majorType, long length) throws IOException {
        int symbol = majorType.getValue() << 5;
        if (length <= 23L) {
            write((byte) (symbol | length));
        } else if (length <= 255L) {
            symbol |= AdditionalInformation.ONE_BYTE.getValue();
            writeBytes((byte) symbol, (byte) length);
        } else if (length <= 65535L) {
            symbol |= AdditionalInformation.TWO_BYTES.getValue();
            writeBytes((byte) symbol, (byte) (length >> 8), (byte) (length & 0xFF));
        } else if (length <= 4294967295L) {
            symbol |= AdditionalInformation.FOUR_BYTES.getValue();
            writeBytes((byte) symbol, (byte) ((length >> 24) & 0xFF), (byte) ((length >> 16) & 0xFF), (byte) ((length >> 8) & 0xFF), (byte) (length & 0xFF));
        } else {
            symbol |= AdditionalInformation.EIGHT_BYTES.getValue();
            writeBytes((byte) symbol, (byte) ((length >> 56) & 0xFF), (byte) ((length >> 48) & 0xFF), (byte) ((length >> 40) & 0xFF), (byte) ((length >> 32) & 0xFF), (byte) ((length >> 24) & 0xFF), (byte) ((length >> 16) & 0xFF), (byte) ((length >> 8) & 0xFF), (byte) (length & 0xFF));
        }
    }

    private void writeType(MajorType majorType, BigInteger length) throws IOException {
        boolean negative = majorType == MajorType.NEGATIVE_INTEGER;
        int symbol = majorType.getValue() << 5;
        if (length.compareTo(BigInteger.valueOf(24)) < 0) {
            write(symbol | length.intValue());
        } else if (length.compareTo(BigInteger.valueOf(256)) < 0) {
            symbol |= AdditionalInformation.ONE_BYTE.getValue();
            writeBytes((byte) symbol, (byte) length.intValue());
        } else if (length.compareTo(BigInteger.valueOf(65536L)) < 0) {
            symbol |= AdditionalInformation.TWO_BYTES.getValue();
            long twoByteValue = length.longValue();
            writeBytes((byte) symbol, (byte) (twoByteValue >> 8), (byte) (twoByteValue & 0xFF));
        } else if (length.compareTo(BigInteger.valueOf(4294967296L)) < 0) {
            symbol |= AdditionalInformation.FOUR_BYTES.getValue();
            long fourByteValue = length.longValue();
            writeBytes((byte) symbol, (byte) ((fourByteValue >> 24) & 0xFF), (byte) ((fourByteValue >> 16) & 0xFF), (byte) ((fourByteValue >> 8) & 0xFF), (byte) (fourByteValue & 0xFF));
        } else if (length.compareTo(UINT64_MAX_PLUS_ONE) < 0) {
            symbol |= AdditionalInformation.EIGHT_BYTES.getValue();
            BigInteger mask = BigInteger.valueOf(0xFF);
            writeBytes((byte) symbol, length.shiftRight(56).and(mask).byteValue(), length.shiftRight(48).and(mask).byteValue(), length.shiftRight(40).and(mask).byteValue(), length.shiftRight(32).and(mask).byteValue(), length.shiftRight(24).and(mask).byteValue(), length.shiftRight(16).and(mask).byteValue(), length.shiftRight(8).and(mask).byteValue(), length.and(mask).byteValue());
        } else {
            if (negative) {
                writeType(MajorType.TAG, 3);
            } else {
                writeType(MajorType.TAG, 2);
            }
            byte[] bytes = length.toByteArray();
            writeType(MajorType.BYTE_STRING, bytes.length);
            write(bytes);
        }
    }

    private void writeBytes(byte... bytes) throws IOException {
        outputStream.write(bytes);
    }

    @Override
    public void write(int b) throws IOException {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public void write(byte[] b) throws IOException {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public void write(byte[] b, int off, int len) throws IOException {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public void flush() throws IOException {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public void close() throws IOException {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
