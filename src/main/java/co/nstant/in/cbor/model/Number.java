package co.nstant.in.cbor.model;

import java.math.BigInteger;
import java.util.Objects;

public abstract class Number extends DataItem {

    private final BigInteger value;

    protected Number(MajorType majorType, BigInteger value) {
        super(majorType);
        this.value = Objects.requireNonNull(value);
    }

    public BigInteger getValue() {
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
