package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

import java.util.Arrays;

public class SortedArrayStorage extends AbstractArrayStorage {

    @Override
    protected void fillDeletedElement(int index) {
        int numMoved = size - index - 1;
        if (numMoved > 0) {
            System.arraycopy(resumeStorage, index + 1, resumeStorage, index, numMoved);
        }
    }

    @Override
    protected void insertElement(Resume resume, int index) {
        int insertIndex = -index - 1;
        System.arraycopy(resumeStorage, insertIndex, resumeStorage, insertIndex + 1, size - insertIndex);
        resumeStorage[insertIndex] = resume;
    }

    @Override
    protected int getIndex(String uuid) {
        Resume searchKey = new Resume(uuid);
        return Arrays.binarySearch(resumeStorage, 0, size, searchKey);
    }
}
