package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

import java.util.List;

public interface Storage {

    int size();

    void save(Resume r);

    void update(Resume r);

    Resume get(String uuid);

    List<Resume> getAllSorted();

    void delete(String uuid);

    void clear();
}