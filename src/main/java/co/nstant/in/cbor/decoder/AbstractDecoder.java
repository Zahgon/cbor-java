package co.nstant.in.cbor.decoder;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigInteger;
import co.nstant.in.cbor.CborDecoder;
import co.nstant.in.cbor.CborException;
import co.nstant.in.cbor.model.AdditionalInformation;

public abstract class AbstractDecoder<T> {

    private static final int BUFFER_SIZE = 4096;

    protected static final int INFINITY = -1;

    protected final InputStream inputStream;

    protected final CborDecoder decoder;

    private int maxPreallocationSize;

    public AbstractDecoder(CborDecoder decoder, InputStream inputStream) {
        this.decoder = decoder;
        this.inputStream = inputStream;
    }

    public abstract T decode(int initialByte) throws CborException;

    protected int nextSymbol() throws CborException {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    protected byte[] nextSymbols(int amount) throws CborException {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    byte[] decodeBytes(long length) throws CborException {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    protected long getLength(int initialByte) throws CborException {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    protected BigInteger getLengthAsBigInteger(int initialByte) throws CborException {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    int getPreallocationSize(long length) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public void setMaxPreallocationSize(int maxPreallocationSize) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
