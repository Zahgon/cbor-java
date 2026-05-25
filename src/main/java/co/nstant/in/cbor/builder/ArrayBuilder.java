package co.nstant.in.cbor.builder;

import co.nstant.in.cbor.model.Array;
import co.nstant.in.cbor.model.DataItem;
import co.nstant.in.cbor.model.Map;
import co.nstant.in.cbor.model.SimpleValue;

public class ArrayBuilder<T extends AbstractBuilder<?>> extends AbstractBuilder<T> {

    private final Array array;

    public ArrayBuilder(T parent, Array array) {
        super(parent);
        this.array = array;
    }

    public ArrayBuilder<T> add(DataItem dataItem) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public ArrayBuilder<T> add(long value) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public ArrayBuilder<T> add(boolean value) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public ArrayBuilder<T> add(float value) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public ArrayBuilder<T> add(double value) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public ArrayBuilder<T> add(byte[] bytes) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public ArrayBuilder<T> add(String string) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public ArrayBuilder<T> tagged(long tag) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public ArrayBuilder<ArrayBuilder<T>> addArray() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public ArrayBuilder<ArrayBuilder<T>> startArray() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public MapBuilder<ArrayBuilder<T>> addMap() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public MapBuilder<ArrayBuilder<T>> startMap() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public T end() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
