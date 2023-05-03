package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MapResumeStorage extends AbstractStorage<Resume> {

    Map<String, Resume> resumesMap = new HashMap<>();

    @Override
    protected Resume getSearchKey(String uuid) {
        return resumesMap.get(uuid);
    }

    @Override
    protected boolean isExist(Resume resume) {
        return resume != null;
    }

    @Override
    protected void doSave(Resume r, Resume resume) {
        resumesMap.put(r.getUuid(), r);
    }

    @Override
    protected Resume doGet(Resume resume) {
        return resume;
    }

    @Override
    protected void doUpdate(Resume r, Resume resume) {
        resumesMap.put(r.getUuid(), r);
    }

    @Override
    protected void doDelete(Resume resume) {
        resumesMap.remove((resume).getUuid());
    }

    @Override
    public int size() {
        return resumesMap.size();
    }

    @Override
    public void clear() {
        resumesMap.clear();
    }

    @Override
    protected List<Resume> doCopyAll() {
        return new ArrayList<>(resumesMap.values());
    }
}
