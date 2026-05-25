package co.nstant.in.cbor.model;

import java.util.Objects;

public class AbstractFloat extends Special {

    private final float value;

    public AbstractFloat(SpecialType specialType, float value) {
        super(specialType);
        this.value = value;
    }

    public float getValue() {
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
