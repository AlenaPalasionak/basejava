package com.urise.webapp.model;

public enum ContactType {
    PHONE("Тел."),
    MOBILE("Мобильный"),
    HOME_PHONE("Домашний тел."),
    SKYPE("Skype"),
    MAIL("Почта"),
    LINKED_IN("Профиль LinkedIn"),
    GIT_HUB("Профиль GitHub"),
    STACK_OVERFLOW("Профиль Stackoverflow"),
    HOME_PAGE("Домашняя страница");
    private String title;

    ContactType(String contact) {
        this.title = contact;
    }

    public String getTitle() {
        return title;
    }
}