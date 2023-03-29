package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

import java.util.Collection;
import java.util.Map;
import java.util.TreeMap;

public class MapUuidStorage extends AbstractStorage {

    Map<String, Resume> resumesMap = new TreeMap<>();

    @Override
    protected Object getSearchKey(String uuid) {
        return uuid;
    }

    @Override
    protected boolean isExist(Object searchKey) {
        return resumesMap.containsKey(searchKey);
    }

    @Override
    protected void doSave(Resume r, Object searchKey) {
        resumesMap.put(searchKey.toString(), r);
    }

    @Override
    protected void doUpdate(Resume r, Object searchKey) {
        resumesMap.put(searchKey.toString(), r);
    }

    @Override
    protected Resume doGet(Object searchKey) {
        return resumesMap.get(searchKey);
    }

    @Override
    protected void doDelete(Object searchKey) {
        resumesMap.remove(searchKey);
    }

    @Override
    public int size() {
        return resumesMap.size();
    }

    @Override
    public Resume[] getAll() {
        Collection<Resume> values = resumesMap.values();
        return values.toArray(new Resume[values.size()]);
    }

    @Override
    public void clear() {
        resumesMap.clear();
    }
}
