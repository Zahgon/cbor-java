package co.nstant.in.cbor;

import java.math.BigInteger;
import java.util.LinkedList;
import java.util.List;
import co.nstant.in.cbor.builder.AbstractBuilder;
import co.nstant.in.cbor.builder.ArrayBuilder;
import co.nstant.in.cbor.builder.ByteStringBuilder;
import co.nstant.in.cbor.builder.MapBuilder;
import co.nstant.in.cbor.builder.UnicodeStringBuilder;
import co.nstant.in.cbor.model.Array;
import co.nstant.in.cbor.model.ByteString;
import co.nstant.in.cbor.model.DataItem;
import co.nstant.in.cbor.model.Map;
import co.nstant.in.cbor.model.UnicodeString;

public class CborBuilder extends AbstractBuilder<CborBuilder> {

    private final LinkedList<DataItem> dataItems = new LinkedList<>();

    public CborBuilder() {
        super(null);
    }

    public CborBuilder reset() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public List<DataItem> build() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public CborBuilder add(DataItem dataItem) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public CborBuilder add(long value) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public CborBuilder add(BigInteger value) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public CborBuilder add(boolean value) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public CborBuilder add(float value) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public CborBuilder add(double value) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public CborBuilder add(byte[] bytes) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public ByteStringBuilder<CborBuilder> startByteString() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public ByteStringBuilder<CborBuilder> startByteString(byte[] bytes) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public CborBuilder add(String string) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public UnicodeStringBuilder<CborBuilder> startString() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public UnicodeStringBuilder<CborBuilder> startString(String string) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public CborBuilder addTag(long value) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public CborBuilder tagged(long value) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public ArrayBuilder<CborBuilder> startArray() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public ArrayBuilder<CborBuilder> addArray() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public MapBuilder<CborBuilder> addMap() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public MapBuilder<CborBuilder> startMap() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    protected void addChunk(DataItem dataItem) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
