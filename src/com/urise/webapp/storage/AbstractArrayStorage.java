package com.urise.webapp.storage;

import com.urise.webapp.exception.StorageException;
import com.urise.webapp.model.Resume;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public abstract class AbstractArrayStorage extends AbstractStorage<Integer> {
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
    protected void doSave(Resume r, Integer index) {
        if (size == STORAGE_LIMIT) {
            throw new StorageException("The resume can not be saved. Storage is overflowed.", r.getUuid());
        } else {
            insertElement(r, index);
            size++;
        }
    }

    @Override
    protected Resume doGet(Integer index) {
        return resumeStorage[index];
    }

    @Override
    public void doUpdate(Resume r, Integer searchKey) {
        resumeStorage[searchKey] = r;
    }

    @Override
    protected void doDelete(Integer index) {
        fillDeletedElement(index);
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

    @Override
    protected List<Resume> doCopyAll() {
        return Arrays.stream(resumeStorage).limit(size).collect(Collectors.toList());
    }

    protected boolean isExist(Integer searchKey) {
        return searchKey >= 0;
    }
}
