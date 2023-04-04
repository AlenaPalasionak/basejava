package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

import java.util.ArrayList;
import java.util.List;

public class ListStorage extends AbstractStorage {

    private List<Resume> resumesList = new ArrayList<>();

    @Override
    protected Integer getSearchKey(String uuid) {
        for (int i = 0; i < resumesList.size(); i++) {
            if (uuid.equals(resumesList.get(i).getUuid())) {
                return i;
            }
        }
        return null;
    }

    @Override
    protected boolean isExist(Object searchKey) {
        return searchKey != null;
    }

    @Override
    public int size() {
        return resumesList.size();
    }

    @Override
    protected void doSave(Resume r, Object searchKey) {
        resumesList.add(r);
    }

    @Override
    protected void doUpdate(Resume r, Object searchKey) {
        resumesList.set((Integer) searchKey, r);
    }

    @Override
    protected Resume doGet(Object index) {
        return resumesList.get((Integer) index);
    }

    @Override
    public List<Resume> getAllSorted() {
        return resumesList;
    }

    @Override
    protected void doDelete(Object searchKey) {
        resumesList.remove(((Integer) searchKey).intValue());
    }

    @Override
    public void clear() {
        resumesList.clear();
    }
}
