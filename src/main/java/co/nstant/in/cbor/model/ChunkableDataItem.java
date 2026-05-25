package co.nstant.in.cbor.model;

import java.util.Objects;

class ChunkableDataItem extends DataItem {

    private boolean chunked = false;

    protected ChunkableDataItem(MajorType majorType) {
        super(majorType);
    }

    public boolean isChunked() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public ChunkableDataItem setChunked(boolean chunked) {
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
}
