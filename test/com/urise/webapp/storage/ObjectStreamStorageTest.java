package com.urise.webapp.storage;

import org.junit.Test;

public class ObjectStreamStorageTest extends AbstractStorageTest {
    public ObjectStreamStorageTest() {
        super(new ObjectStreamStorage(STORAGE_DIR));
    }

    @Test
    public void doWrite() {
    }

    @Test
    public void doRead() {
    }
}