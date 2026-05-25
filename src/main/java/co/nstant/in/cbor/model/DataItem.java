package co.nstant.in.cbor.model;

import java.util.Objects;
import co.nstant.in.cbor.CborEncoder;

public class DataItem {

    private final MajorType majorType;

    private Tag tag;

    protected DataItem(MajorType majorType) {
        this.majorType = majorType;
        Objects.requireNonNull(majorType, "majorType is null");
    }

    public MajorType getMajorType() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public void setTag(long tag) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public void setTag(Tag tag) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public void removeTag() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public Tag getTag() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public boolean hasTag() {
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

    protected void assertTrue(boolean condition, String message) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public DataItem getOuterTaggable() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public byte[] encodeToBytes() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
