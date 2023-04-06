package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

import java.util.*;

public class MapUuidStorage extends AbstractStorage {

    Map<String, Resume> resumesMap = new HashMap<>();

    @Override
    protected Object getSearchKey(String uuid) {
        return uuid;
    }

    @Override
    protected boolean isExist(Object uuid) {
        return resumesMap.containsKey((String) uuid);
    }

    @Override
    protected void doSave(Resume r, Object uuid) {
        resumesMap.put((String) uuid, r);
    }

    @Override
    protected void doUpdate(Resume r, Object uuid) {
        resumesMap.put((String) uuid, r);
    }

    @Override
    protected Resume doGet(Object uuid) {
        return resumesMap.get((String) uuid);
    }

    @Override
    protected void doDelete(Object uuid) {
        resumesMap.remove((String) uuid);
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
