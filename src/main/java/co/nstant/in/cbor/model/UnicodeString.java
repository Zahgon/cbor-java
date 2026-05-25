package co.nstant.in.cbor.model;

public class UnicodeString extends ChunkableDataItem {

    private final String string;

    public UnicodeString(String string) {
        super(MajorType.UNICODE_STRING);
        this.string = string;
    }

    @Override
    public String toString() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public String getString() {
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
