package co.nstant.in.cbor.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Array extends ChunkableDataItem {

    private final ArrayList<DataItem> objects;

    public Array() {
        super(MajorType.ARRAY);
        objects = new ArrayList<>();
    }

    public Array(int initialCapacity) {
        super(MajorType.ARRAY);
        objects = new ArrayList<>(initialCapacity);
    }

    public Array add(DataItem object) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public List<DataItem> getDataItems() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public boolean equals(Object object) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public int hashCode() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public String toString() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public DataItem peekLast() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
