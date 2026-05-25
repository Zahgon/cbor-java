package co.nstant.in.cbor.model;

import co.nstant.in.cbor.CborException;

public enum SpecialType {

    SIMPLE_VALUE,
    SIMPLE_VALUE_NEXT_BYTE,
    IEEE_754_HALF_PRECISION_FLOAT,
    IEEE_754_SINGLE_PRECISION_FLOAT,
    IEEE_754_DOUBLE_PRECISION_FLOAT,
    BREAK;

    public static SpecialType ofByte(int b) throws CborException {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
