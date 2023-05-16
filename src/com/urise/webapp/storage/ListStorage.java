package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

import java.util.ArrayList;
import java.util.List;

public class ListStorage extends AbstractStorage<Integer> {
    private final List<Resume> resumes = new ArrayList<>();

    @Override
    protected Integer getSearchKey(String uuid) {
        for (int i = 0; i < resumes.size(); i++) {
            if (uuid.equals(resumes.get(i).getUuid())) {
                return i;
            }
        }
        return null;
    }

    @Override
    protected boolean isExist(Integer searchKey) {
        return searchKey != null;
    }

    @Override
    public int size() {
        return resumes.size();
    }

    @Override
    protected void doSave(Resume r, Integer searchKey) {
        resumes.add(r);
    }

    @Override
    protected Resume doGet(Integer index) {
        return resumes.get(index);
    }

    @Override
    public List<Resume> getAllSorted() {
        return resumes;
    }

    @Override
    protected void doUpdate(Resume r, Integer searchKey) {
        resumes.set(searchKey, r);
    }

    @Override
    protected void doDelete(Integer searchKey) {
        resumes.remove((searchKey).intValue());
    }

    @Override
    public void clear() {
        resumes.clear();
    }

    @Override
    protected List<Resume> doCopyAll() {
        return new ArrayList<>(resumes);
    }
}
