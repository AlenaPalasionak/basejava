package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage extends AbstractArrayStorage {
    @Override
    protected Integer getSearchKey(String uuid) {
        for (int i = 0; i < size; i++) {
            if (uuid.equals(resumeStorage[i].getUuid())) {
                return i;
            }
        }
        return -1;
    }

    /**
     * @param index - the null position where delete element was. We move the last element on this position
     */
    @Override
    protected void fillDeletedElement(int index) {
        resumeStorage[index] = resumeStorage[size - 1];
    }

    @Override
    protected void insertElement(Resume r, int index) {
        resumeStorage[size] = r;
    }
}
