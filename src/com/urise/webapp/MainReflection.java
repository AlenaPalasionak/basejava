package com.urise.webapp;

import com.urise.webapp.model.Resume;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

public class MainReflection {
    public static void main(String[] args) throws IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        Resume resume = new Resume("1");
        Field declaredField = resume.getClass().getDeclaredFields()[0];
        declaredField.setAccessible(true);
        System.out.println(declaredField.getName());
        System.out.println(declaredField.get(resume));
        declaredField.set(resume, "new_uuid");
        System.out.println(resume);
        Class<? extends Resume> clazz = resume.getClass();
        System.out.println(" uuid " + clazz.getDeclaredMethod("toString").invoke(resume));
    }
}
