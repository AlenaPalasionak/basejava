package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

import java.util.List;

public interface Storage {
    int size();

    void save(Resume r);

    Resume get(String uuid);

    List<Resume> getAllSorted();

    void update(Resume r);

    void delete(String uuid);

    void clear();
}