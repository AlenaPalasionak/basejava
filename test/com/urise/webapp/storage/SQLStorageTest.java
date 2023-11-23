package com.urise.webapp.storage;

import com.urise.webapp.Config;

public class SQLStorageTest extends AbstractStorageTest {

    public SQLStorageTest() {
        super(Config.get().getStorage());
    }
}