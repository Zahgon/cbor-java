package co.nstant.in.cbor;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;
import java.util.Objects;
import co.nstant.in.cbor.model.Array;
import co.nstant.in.cbor.model.ByteString;
import co.nstant.in.cbor.model.DataItem;
import co.nstant.in.cbor.model.Map;
import co.nstant.in.cbor.model.NegativeInteger;
import co.nstant.in.cbor.model.SimpleValue;
import co.nstant.in.cbor.model.Special;
import co.nstant.in.cbor.model.Tag;
import co.nstant.in.cbor.model.UnicodeString;
import co.nstant.in.cbor.model.UnsignedInteger;

/**
 * Encoder for the CBOR format based.
 */
public class CborEncoder {

    private CborOutputStream cborOutputStream;

    /**
     * Initialize a new encoder which writes the binary encoded data to an
     * {@link OutputStream}.
     *
     * @param outputStream the {@link OutputStream} to write the encoded data to
     */
    public CborEncoder(OutputStream outputStream) {
        Objects.requireNonNull(outputStream);
        cborOutputStream = new CborOutputStream(outputStream);
    }

    /**
     * Encode a list of {@link DataItem}s, also known as a stream.
     *
     * @param dataItems a list of {@link DataItem}s
     * @throws CborException if the {@link DataItem}s could not be encoded or there
     *                       was an problem with the {@link OutputStream}.
     */
    public void encode(List<DataItem> dataItems) throws CborException {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Encode a single {@link DataItem}.
     *
     * @param dataItem the {@link DataItem} to encode. If null, encoder encodes a
     *                 {@link SimpleValue} NULL value.
     * @throws CborException if {@link DataItem} could not be encoded or there was
     *                       an problem with the {@link OutputStream}.
     */
    public void encode(DataItem dataItem) throws CborException {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public boolean isCanonical() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public CborEncoder nonCanonical() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Encode a list of {@link DataItem}s, also known as a stream, to a byte array.
     *
     * @param dataItems a list of {@link DataItem}s
     */
    public static byte[] encodeToBytes(List<DataItem> dataItems) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Encode a single {@link DataItem} to a byte array.
     *
     * @param dataItem the {@link DataItem} to encode. If null, encoder encodes a
     *                 {@link SimpleValue} NULL value.
     */
    public static byte[] encodeToBytes(DataItem dataItem) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
