package com.urise.webapp.model;

import java.util.Objects;

public class SimpleTextSection extends Section { //Позиция, Личные качества,
    private static final long serialVersionUID = 1L;
    private String text;

    public SimpleTextSection(String text) {
        Objects.requireNonNull(text, "text must not be null");
        this.text = text;
    }

    public String getText() {
        return text;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SimpleTextSection that = (SimpleTextSection) o;
        return text.equals(that.text);
    }

    @Override
    public int hashCode() {
        return text.hashCode();
    }

    @Override
    public String toString() {
        return "SimpleTextSection{" +
                "text='" + text + '\'' +
                '}';
    }
}
