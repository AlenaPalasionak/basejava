package com.urise.webapp.storage;

import org.junit.Test;

import static org.junit.Assert.*;

public class ObjectStreamPathStorageTest extends AbstractStorageTest {

    public ObjectStreamPathStorageTest() {
        super(new ObjectStreamPathStorage(STORAGE_DIR.getAbsolutePath()));
    }

    @Test
    public void doWrite() {
    }

    @Test
    public void doRead() {
    }
}