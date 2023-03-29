package com.urise.webapp.storage;

import com.urise.webapp.exception.StorageException;
import com.urise.webapp.model.Resume;

import java.util.Arrays;

public abstract class AbstractArrayStorage extends AbstractStorage {
    protected static final int STORAGE_LIMIT = 100000;
    protected Resume[] resumeStorage = new Resume[STORAGE_LIMIT];
    protected int size = 0;

    protected abstract Integer getSearchKey(String uuid);
    protected abstract void fillDeletedElement(int index);
    protected abstract void insertElement(Resume r, int index);

    @Override
    public int size() {
        return size;
    }

    @Override
    protected void doSave(Resume r, Object index) {
        if (size == STORAGE_LIMIT) {
            throw new StorageException("The resume can not be saved. Storage is overflowed.", r.getUuid());
        } else {
            insertElement(r, (Integer) index);
            size++;
        }
    }

    @Override
    public void doUpdate(Resume r, Object searchKey) {
        resumeStorage[(Integer) searchKey] = r;
    }

    @Override
    protected Resume doGet(Object index) {
        return resumeStorage[(Integer) index];
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    @Override
    public Resume[] getAll() {
        return Arrays.copyOfRange(resumeStorage, 0, size);
    }

    @Override
    protected void doDelete(Object index) {
        fillDeletedElement((Integer) index);
        resumeStorage[size - 1] = null;
        size--;
    }

    @Override
    public void clear() {
        if (size > 0) {
            Arrays.fill(resumeStorage, 0, size - 1, null);
            size = 0;
        }
    }

    protected boolean isExist(Object searchKey) {
        return (Integer) searchKey >= 0;
    }
}
