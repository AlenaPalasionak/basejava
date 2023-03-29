package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

public interface Storage {

    int size();

    void save(Resume resume);

    void update(Resume resume);

    Resume get(String uuid);

    Resume[] getAll();

    void delete(String uuid);

    void clear();
}

