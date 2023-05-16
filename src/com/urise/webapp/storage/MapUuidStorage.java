package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

import java.util.*;

public class MapUuidStorage extends AbstractStorage<String> {
    Map<String, Resume> resumesMap = new HashMap<>();

    @Override
    protected String getSearchKey(String uuid) {
        return uuid;
    }

    @Override
    protected boolean isExist(String uuid) {
        return resumesMap.containsKey(uuid);
    }

    @Override
    protected void doSave(Resume r, String uuid) {
        resumesMap.put(uuid, r);
    }

    @Override
    protected Resume doGet(String uuid) {
        return resumesMap.get(uuid);
    }

    @Override
    protected void doUpdate(Resume r, String uuid) {
        resumesMap.put(uuid, r);
    }

    @Override
    protected void doDelete(String uuid) {
        resumesMap.remove(uuid);
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
