package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage extends AbstractArrayStorage {

    @Override
    protected void fillDeletedElement(int index) {
        resumeStorage[index] = resumeStorage[size - 1];
    }

    @Override
    protected void insertElement(Resume resume, int index) {
        resumeStorage[size] = resume;
    }

    protected int getIndex(String uuid) {
        for (int i = 0; i < size; i++) {
            if (resumeStorage[i].getUuid().equals(uuid)) {
                return i;
            }
        }
        return -1;
    }
}
