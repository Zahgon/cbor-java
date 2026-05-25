package co.nstant.in.cbor.builder;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.math.BigInteger;
import co.nstant.in.cbor.CborEncoder;
import co.nstant.in.cbor.CborException;
import co.nstant.in.cbor.decoder.HalfPrecisionFloatDecoder;
import co.nstant.in.cbor.model.ByteString;
import co.nstant.in.cbor.model.DataItem;
import co.nstant.in.cbor.model.DoublePrecisionFloat;
import co.nstant.in.cbor.model.HalfPrecisionFloat;
import co.nstant.in.cbor.model.NegativeInteger;
import co.nstant.in.cbor.model.SimpleValue;
import co.nstant.in.cbor.model.SinglePrecisionFloat;
import co.nstant.in.cbor.model.Tag;
import co.nstant.in.cbor.model.UnicodeString;
import co.nstant.in.cbor.model.UnsignedInteger;

public abstract class AbstractBuilder<T> {

    private final T parent;

    public AbstractBuilder(T parent) {
        this.parent = parent;
    }

    protected T getParent() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    protected void addChunk(DataItem dataItem) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    protected DataItem convert(long value) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    protected DataItem convert(BigInteger value) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    protected DataItem convert(boolean value) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    protected DataItem convert(byte[] bytes) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    protected DataItem convert(String string) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    protected DataItem convert(float value) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    protected DataItem convert(double value) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    protected Tag tag(long value) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    private boolean isHalfPrecisionEnough(float value) {
        try {
            byte[] bytes = new HalfPrecisionFloat(value).encodeToBytes();
            ByteArrayInputStream inputStream = new ByteArrayInputStream(bytes);
            HalfPrecisionFloatDecoder decoder = getHalfPrecisionFloatDecoder(inputStream);
            if (inputStream.read() == -1) {
                // to skip type byte
                throw new CborException("unexpected end of stream");
            }
            HalfPrecisionFloat halfPrecisionFloat = decoder.decode(0);
            return value == halfPrecisionFloat.getValue();
        } catch (CborException cborException) {
            return false;
        }
    }

    protected HalfPrecisionFloatDecoder getHalfPrecisionFloatDecoder(InputStream inputStream) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
