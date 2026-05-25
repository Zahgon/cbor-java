package co.nstant.in.cbor.builder;

import co.nstant.in.cbor.model.DataItem;

public class MapEntryBuilder<T extends MapBuilder<?>> extends AbstractBuilder<T> {

    private final DataItem key;

    public MapEntryBuilder(T parent, DataItem key) {
        super(parent);
        this.key = key;
    }

    public T value(boolean value) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public T value(byte[] value) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public T value(double value) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public T value(String value) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    private T put(DataItem key, DataItem value) {
        getParent().put(key, value);
        return getParent();
    }

    public MapEntryBuilder<T> tagged(long tag) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
