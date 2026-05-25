package co.nstant.in.cbor.model;

/**
 * The initial byte of each data item contains both information about the major
 * type (the high-order 3 bits) and additional information (the low-order 5
 * bits). When the value of the additional information is less than 24, it is
 * directly used as a small unsigned integer. When it is 24 to 27, the
 * additional bytes for a variable-length integer immediately follow; the values
 * 24 to 27 of the additional information specify that its length is a 1-, 2-,
 * 4- or 8-byte unsigned integer, respectively. Additional information value 31
 * is used for indefinite length items, described in Section 2.2. Additional
 * information values 28 to 30 are reserved for future expansion.
 */
public enum AdditionalInformation {

    // 0-23
    DIRECT(0),
    // 24
    ONE_BYTE(24),
    // 25
    TWO_BYTES(25),
    // 26
    FOUR_BYTES(26),
    // 27
    EIGHT_BYTES(27),
    // 28-30
    RESERVED(28),
    // 31
    INDEFINITE(31);

    private final int value;

    private AdditionalInformation(int value) {
        this.value = value;
    }

    public int getValue() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public static AdditionalInformation ofByte(int b) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
