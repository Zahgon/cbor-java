package co.nstant.in.cbor;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import co.nstant.in.cbor.decoder.ArrayDecoder;
import co.nstant.in.cbor.decoder.ByteStringDecoder;
import co.nstant.in.cbor.decoder.MapDecoder;
import co.nstant.in.cbor.decoder.NegativeIntegerDecoder;
import co.nstant.in.cbor.decoder.SpecialDecoder;
import co.nstant.in.cbor.decoder.TagDecoder;
import co.nstant.in.cbor.decoder.UnicodeStringDecoder;
import co.nstant.in.cbor.decoder.UnsignedIntegerDecoder;
import co.nstant.in.cbor.model.Array;
import co.nstant.in.cbor.model.DataItem;
import co.nstant.in.cbor.model.LanguageTaggedString;
import co.nstant.in.cbor.model.MajorType;
import co.nstant.in.cbor.model.Number;
import co.nstant.in.cbor.model.RationalNumber;
import co.nstant.in.cbor.model.Tag;
import co.nstant.in.cbor.model.UnicodeString;

/**
 * Decoder for the CBOR format based.
 */
public class CborDecoder {

    private final InputStream inputStream;

    private final UnsignedIntegerDecoder unsignedIntegerDecoder;

    private final NegativeIntegerDecoder negativeIntegerDecoder;

    private final ByteStringDecoder byteStringDecoder;

    private final UnicodeStringDecoder unicodeStringDecoder;

    private final ArrayDecoder arrayDecoder;

    private final MapDecoder mapDecoder;

    private final TagDecoder tagDecoder;

    private final SpecialDecoder specialDecoder;

    private boolean autoDecodeInfinitiveArrays = true;

    private boolean autoDecodeInfinitiveMaps = true;

    private boolean autoDecodeInfinitiveByteStrings = true;

    private boolean autoDecodeInfinitiveUnicodeStrings = true;

    private boolean autoDecodeRationalNumbers = true;

    private boolean autoDecodeLanguageTaggedStrings = true;

    private boolean rejectDuplicateKeys = false;

    /**
     * Initialize a new decoder which reads the binary encoded data from an
     * {@link OutputStream}.
     *
     * @param inputStream the {@link OutputStream} to read the data from
     */
    public CborDecoder(InputStream inputStream) {
        Objects.requireNonNull(inputStream);
        this.inputStream = inputStream;
        unsignedIntegerDecoder = new UnsignedIntegerDecoder(this, inputStream);
        negativeIntegerDecoder = new NegativeIntegerDecoder(this, inputStream);
        byteStringDecoder = new ByteStringDecoder(this, inputStream);
        unicodeStringDecoder = new UnicodeStringDecoder(this, inputStream);
        arrayDecoder = new ArrayDecoder(this, inputStream);
        mapDecoder = new MapDecoder(this, inputStream);
        tagDecoder = new TagDecoder(this, inputStream);
        specialDecoder = new SpecialDecoder(this, inputStream);
    }

    /**
     * Convenience method to decode a byte array directly.
     *
     * @param bytes the CBOR encoded data
     * @return a list of {@link DataItem}s
     * @throws CborException if decoding failed
     */
    public static List<DataItem> decode(byte[] bytes) throws CborException {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Decode the {@link InputStream} to a list of {@link DataItem}s.
     *
     * @return the list of {@link DataItem}s
     * @throws CborException if decoding failed
     */
    public List<DataItem> decode() throws CborException {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Streaming decoding of an input stream. On each decoded DataItem, the callback
     * listener is invoked.
     *
     * @param dataItemListener the callback listener
     * @throws CborException if decoding failed
     */
    public void decode(DataItemListener dataItemListener) throws CborException {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Decodes exactly one DataItem from the input stream.
     *
     * @return a {@link DataItem} or null if end of stream has reached.
     * @throws CborException if decoding failed
     */
    public DataItem decodeNext() throws CborException {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    private DataItem decodeLanguageTaggedString(DataItem dataItem) throws CborException {
        if (!(dataItem instanceof Array)) {
            throw new CborException("Error decoding LanguageTaggedString: not an array");
        }
        Array array = (Array) dataItem;
        if (array.getDataItems().size() != 2) {
            throw new CborException("Error decoding LanguageTaggedString: array size is not 2");
        }
        DataItem languageDataItem = array.getDataItems().get(0);
        if (!(languageDataItem instanceof UnicodeString)) {
            throw new CborException("Error decoding LanguageTaggedString: first data item is not an UnicodeString");
        }
        DataItem stringDataItem = array.getDataItems().get(1);
        if (!(stringDataItem instanceof UnicodeString)) {
            throw new CborException("Error decoding LanguageTaggedString: second data item is not an UnicodeString");
        }
        UnicodeString language = (UnicodeString) languageDataItem;
        UnicodeString string = (UnicodeString) stringDataItem;
        return new LanguageTaggedString(language, string);
    }

    private DataItem decodeRationalNumber(DataItem dataItem) throws CborException {
        if (!(dataItem instanceof Array)) {
            throw new CborException("Error decoding RationalNumber: not an array");
        }
        Array array = (Array) dataItem;
        if (array.getDataItems().size() != 2) {
            throw new CborException("Error decoding RationalNumber: array size is not 2");
        }
        DataItem numeratorDataItem = array.getDataItems().get(0);
        if (!(numeratorDataItem instanceof Number)) {
            throw new CborException("Error decoding RationalNumber: first data item is not a number");
        }
        DataItem denominatorDataItem = array.getDataItems().get(1);
        if (!(denominatorDataItem instanceof Number)) {
            throw new CborException("Error decoding RationalNumber: second data item is not a number");
        }
        Number numerator = (Number) numeratorDataItem;
        Number denominator = (Number) denominatorDataItem;
        return new RationalNumber(numerator, denominator);
    }

    public boolean isAutoDecodeInfinitiveArrays() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public void setAutoDecodeInfinitiveArrays(boolean autoDecodeInfinitiveArrays) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public boolean isAutoDecodeInfinitiveMaps() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public void setAutoDecodeInfinitiveMaps(boolean autoDecodeInfinitiveMaps) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public boolean isAutoDecodeInfinitiveByteStrings() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public void setAutoDecodeInfinitiveByteStrings(boolean autoDecodeInfinitiveByteStrings) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public boolean isAutoDecodeInfinitiveUnicodeStrings() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public void setAutoDecodeInfinitiveUnicodeStrings(boolean autoDecodeInfinitiveUnicodeStrings) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public boolean isAutoDecodeRationalNumbers() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public void setAutoDecodeRationalNumbers(boolean autoDecodeRationalNumbers) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public boolean isAutoDecodeLanguageTaggedStrings() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public void setAutoDecodeLanguageTaggedStrings(boolean autoDecodeLanguageTaggedStrings) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public boolean isRejectDuplicateKeys() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public void setRejectDuplicateKeys(boolean rejectDuplicateKeys) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Sets the given amount of bytes as maximum preallocation limit for arrays in
     * all decoders. This prevents OutOfMemory exceptions on malicious CBOR with
     * forged fixed length items. Note that items may exceed the given size when the
     * decoded data actually contains much data. This may be limited by using a
     * limiting stream.
     *
     * @param maxSize Maximum number of bytes to preallocate in array-based items.
     *                Set to 0 to disable.
     */
    public void setMaxPreallocationSize(int maxSize) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
