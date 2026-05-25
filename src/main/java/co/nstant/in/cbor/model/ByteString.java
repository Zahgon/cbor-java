package co.nstant.in.cbor.model;

import java.util.Arrays;

public class ByteString extends ChunkableDataItem {

    private final byte[] bytes;

    public ByteString(byte[] bytes) {
        super(MajorType.BYTE_STRING);
        if (bytes == null) {
            this.bytes = null;
        } else {
            this.bytes = bytes;
        }
    }

    public byte[] getBytes() {
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
