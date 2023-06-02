package com.urise.webapp.storage;

import com.urise.webapp.storage.serializer.ObjectStreamSerializer;
import org.junit.Test;

public class FileStorageTest extends AbstractStorageTest {

    public FileStorageTest() {
        super(new FileStorage(STORAGE_DIR, new ObjectStreamSerializer()));
    }

    @Test
    public void doWrite() {
    }

    @Test
    public void doRead() {
    }
}