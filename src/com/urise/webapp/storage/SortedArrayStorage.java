package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

import java.util.Arrays;
import java.util.Comparator;

public class SortedArrayStorage extends AbstractArrayStorage {

    private static final Comparator<Resume> RESUME_COMPARATOR = (o1, o2) -> o1.getUuid().compareTo(o2.getUuid());

    /**
     * @param uuid - we create a Resume with this uuid
     * @return index of the search key or (-(insertion point) - 1)
     */
    @Override
    protected Integer getSearchKey(String uuid) {
        Resume searchKey = new Resume(uuid, "dummy");
        return Arrays.binarySearch(resumeStorage, 0, size, searchKey, RESUME_COMPARATOR);
    }

    @Override
    protected void fillDeletedElement(int index) {
        int numMoved = size - index - 1;
        if (numMoved > 0) {
            System.arraycopy(resumeStorage, index + 1, resumeStorage, index, numMoved);
        }
    }

    @Override
    protected void insertElement(Resume r, int index) {
        int insertIndex = -index - 1;
        System.arraycopy(resumeStorage, insertIndex, resumeStorage, insertIndex + 1, size - insertIndex);
        resumeStorage[insertIndex] = r;
    }
}
