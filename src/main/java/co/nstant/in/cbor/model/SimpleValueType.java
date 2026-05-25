package co.nstant.in.cbor.model;

public enum SimpleValueType {

    FALSE(20),
    TRUE(21),
    NULL(22),
    UNDEFINED(23),
    RESERVED(0),
    UNALLOCATED(0);

    private final int value;

    private SimpleValueType(int value) {
        this.value = value;
    }

    public int getValue() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public static SimpleValueType ofByte(int b) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
