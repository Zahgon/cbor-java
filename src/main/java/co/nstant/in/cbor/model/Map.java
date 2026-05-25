package co.nstant.in.cbor.model;

import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;

public class Map extends ChunkableDataItem {

    private final LinkedHashMap<DataItem, DataItem> map;

    private final List<DataItem> keys = new LinkedList<>();

    public Map() {
        super(MajorType.MAP);
        map = new LinkedHashMap<>();
    }

    public Map(int initialCapacity) {
        super(MajorType.MAP);
        map = new LinkedHashMap<>(initialCapacity);
    }

    public Map put(DataItem key, DataItem value) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public DataItem get(DataItem key) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public DataItem remove(DataItem key) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public Collection<DataItem> getKeys() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public Collection<DataItem> getValues() {
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
}
