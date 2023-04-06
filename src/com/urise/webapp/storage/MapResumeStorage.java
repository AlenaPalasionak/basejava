package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MapResumeStorage extends AbstractStorage {

    Map<String, Resume> resumesMap = new HashMap<>();

    @Override
    protected Resume getSearchKey(String uuid) {
        return resumesMap.get(uuid);
    }

    @Override
    protected boolean isExist(Object resume) {
        return resume != null;
    }

    @Override
    protected void doSave(Resume r, Object resume) {
        resumesMap.put(r.getUuid(), r);
    }

    @Override
    protected void doUpdate(Resume r, Object resume) {
        resumesMap.put(r.getUuid(), r);
    }

    @Override
    protected Resume doGet(Object resume) {
        return (Resume) resume;
    }

    @Override
    protected void doDelete(Object resume) {
        resumesMap.remove(((Resume) resume).getUuid());
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
