package co.nstant.in.cbor.model;

import java.util.Objects;

public class DoublePrecisionFloat extends Special {

    private final double value;

    public DoublePrecisionFloat(double value) {
        super(SpecialType.IEEE_754_DOUBLE_PRECISION_FLOAT);
        this.value = value;
    }

    public double getValue() {
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
