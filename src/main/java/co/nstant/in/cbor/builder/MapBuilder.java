package co.nstant.in.cbor.builder;

import co.nstant.in.cbor.model.Array;
import co.nstant.in.cbor.model.DataItem;
import co.nstant.in.cbor.model.Map;

public class MapBuilder<T extends AbstractBuilder<?>> extends AbstractBuilder<T> {

    private final Map map;

    private DataItem lastItem = null;

    public MapBuilder(T parent, Map map) {
        super(parent);
        this.map = map;
    }

    public MapBuilder<T> put(DataItem key, DataItem value) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public MapBuilder<T> put(long key, long value) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public MapBuilder<T> put(long key, boolean value) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public MapBuilder<T> put(long key, float value) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public MapBuilder<T> put(long key, double value) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public MapBuilder<T> put(long key, byte[] value) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public MapBuilder<T> put(long key, String value) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public MapBuilder<T> put(String key, long value) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public MapBuilder<T> put(String key, boolean value) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public MapBuilder<T> put(String key, float value) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public MapBuilder<T> put(String key, double value) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public MapBuilder<T> put(String key, byte[] value) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public MapBuilder<T> put(String key, String value) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public ArrayBuilder<MapBuilder<T>> putArray(DataItem key) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public ArrayBuilder<MapBuilder<T>> putArray(long key) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public ArrayBuilder<MapBuilder<T>> putArray(String key) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public ArrayBuilder<MapBuilder<T>> startArray(DataItem key) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public ArrayBuilder<MapBuilder<T>> startArray(long key) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public ArrayBuilder<MapBuilder<T>> startArray(String key) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public MapBuilder<MapBuilder<T>> putMap(DataItem key) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public MapBuilder<MapBuilder<T>> putMap(long key) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public MapBuilder<MapBuilder<T>> putMap(String key) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public MapBuilder<MapBuilder<T>> startMap(DataItem key) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    private MapBuilder<MapBuilder<T>> startMap(DataItem key, boolean chunked) {
        Map nestedMap = new Map();
        nestedMap.setChunked(chunked);
        put(key, nestedMap);
        return new MapBuilder<>(this, nestedMap);
    }

    public MapBuilder<MapBuilder<T>> startMapNotChunked(DataItem key) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public MapBuilder<T> tagged(long tag) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public MapBuilder<MapBuilder<T>> startMap(long key) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public MapBuilder<MapBuilder<T>> startMap(String key) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public MapBuilder<MapBuilder<T>> startMapNotChunked(long key) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public MapBuilder<MapBuilder<T>> startMapNotChunked(String key) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public T end() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public MapEntryBuilder<MapBuilder<T>> addKey(long key) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public MapEntryBuilder<MapBuilder<T>> addKey(String key) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
