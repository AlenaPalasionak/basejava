package com.urise.webapp.storage;

import com.urise.webapp.exception.StorageException;
import com.urise.webapp.model.Resume;
import org.junit.Test;

import static org.junit.Assert.fail;

public abstract class AbstractArrayStorageTest extends AbstractStorageTest {

    public AbstractArrayStorageTest(Storage storage) {
        super(storage);
    }

    @Test(expected = StorageException.class)
    public void saveOverflow() {
        int i = 3;
        try {
            for (i = 3; i <= AbstractArrayStorage.STORAGE_LIMIT; i++) {
                storage.save(new Resume("dummy"));
            }
        } catch (Exception e) {
            if (i < AbstractArrayStorage.STORAGE_LIMIT) {
                fail("Storage is overflowed ahead of time");
            } else {
                throw new StorageException("Storage overflowed ", String.valueOf(i));
            }
        }
    }
}
