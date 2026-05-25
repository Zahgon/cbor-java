package co.nstant.in.cbor.model;

import java.util.Objects;

public class Tag extends DataItem {

    private final long value;

    public Tag(long value) {
        super(MajorType.TAG);
        this.value = value;
    }

    public long getValue() {
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
