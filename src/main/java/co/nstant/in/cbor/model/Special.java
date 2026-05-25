package co.nstant.in.cbor.model;

import java.util.Objects;

public class Special extends DataItem {

    public static final Special BREAK = new Special(SpecialType.BREAK);

    private final SpecialType specialType;

    protected Special(SpecialType specialType) {
        super(MajorType.SPECIAL);
        this.specialType = Objects.requireNonNull(specialType);
    }

    public SpecialType getSpecialType() {
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
