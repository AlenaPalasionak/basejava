package com.urise.webapp.storage;

import com.urise.webapp.exception.ExistStorageException;
import com.urise.webapp.exception.NotExistStorageException;
import com.urise.webapp.model.Resume;

import java.util.Collections;
import java.util.List;
import java.util.logging.Logger;

public abstract class AbstractStorage<K> implements Storage {

    private static final Logger LOG = Logger.getLogger(AbstractStorage.class.getName());

    protected abstract K getSearchKey(String uuid);

    protected abstract boolean isExist(K searchKey);

    protected abstract void doSave(Resume resume, K searchKey);

    protected abstract void doUpdate(Resume resume, K searchKey);

    protected abstract Resume doGet(K searchKey);

    protected abstract void doDelete(K searchKey);

    protected abstract List<Resume> doCopyAll();

    public void save(Resume r) {
        LOG.info("save" + r);
        K searchKey = getNotExistedKey(r.getUuid());
        doSave(r, searchKey);
    }

    public void update(Resume r) {
        LOG.info("update" + r);
        K searchKey = getExistedKey(r.getUuid());
        doUpdate(r, searchKey);
    }

    public Resume get(String uuid) {
        LOG.info("get" + uuid);
        K searchKey = getExistedKey(uuid);
        return doGet(searchKey);
    }

    @Override
    public List<Resume> getAllSorted() {
        LOG.info("getAllSorted");
        List<Resume> list = doCopyAll();
        Collections.sort(list);
        return list;
    }

    public void delete(String uuid) {
        LOG.info("delete" + uuid);
        K searchKey = getExistedKey(uuid);
        doDelete(searchKey);
    }

    private K getExistedKey(String uuid) {
        LOG.info("getExistedKey" + uuid);
        K searchKey = getSearchKey(uuid);
        if (!isExist(searchKey)) {
            LOG.warning("Resume " + uuid + " not exist");
            throw new NotExistStorageException(uuid);
        }
        return searchKey;
    }

    private K getNotExistedKey(String uuid) {
        LOG.info("getNotExistedKey" + uuid);
        K searchKey = getSearchKey(uuid);
        if (isExist(searchKey)) {
            LOG.warning("Resume " + uuid + " already exist");
            throw new ExistStorageException(uuid);
        }
        return searchKey;
    }
}