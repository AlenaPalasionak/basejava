package com.urise.webapp;

import com.urise.webapp.model.*;

import java.time.Month;

import static com.urise.webapp.model.ContactType.*;
import static com.urise.webapp.model.SectionType.*;

public class ResumeTestData {

    public static void main(String[] args) {
        createResume("1", "Grigory");
    }

    public static Resume createResume(String uuid, String fullName) {
        Resume resume = new Resume(uuid, fullName);
        resume.setContact(PHONE, "+7(921) 855-0482");
        resume.setContact(SKYPE, "skype:grigory.kislin");
        resume.setContact(MOBILE, "3465645645645");
        resume.setContact(HOME_PHONE, "44 44 55");
        resume.setContact(MAIL, "gkislin@yandex.ru");
        resume.setContact(LINKEDIN, "https://www.linkedin.com/in/gkislin/");
        resume.setContact(GITHUB, "settps://github.com/gkislin");
        resume.setContact(STACKOVERFLOW, "https://stackoverflow.com/users/548473/grigory-kislin");
        resume.setContact(HOME_PAGE, "http://gkislin.ru/");

        resume.setSection(OBJECTIVE, new TextSection
                ("Ведущий стажировок и корпоративного обучения по Java Web и Enterprise технологиям"));
        resume.setSection(PERSONAL, new TextSection
                ("Аналитический склад ума, сильная логика, креативность, инициативность. Пурист кода и архитектуры."));
        resume.setSection(ACHIEVEMENT, new ListSection("Achievement1", "Achievement2", "Achievement3"));
        resume.setSection(QUALIFICATIONS, new ListSection("QUALIFICATION1", "QUALIFICATION2", "QUALIFICATION3"));
        resume.setSection(EXPERIENCE, new OrganizationSection(new Organization
                ("Java Online Projects"
                        , "https://javaops.ru/"
                        , new Organization.Position(2013, Month.of(10), "\n" +
                        "Автор проекта."
                        , "Создание, организация и проведение Java онлайн проектов и стажировок.")
                )));

        resume.setSection(SectionType.EDUCATION, new OrganizationSection(new Organization
                ("Coursera"
                        , "https://www.coursera.org/learn/scala-functional-programming"
                        , new Organization.Position(2013, Month.of(3), 2013, Month.of(3)
                        , "Functional Programming Principles in Scala' by Martin Odersky", "")
                )));

        System.out.println(resume.getUuid());
        System.out.println(resume.getFullName());
        for (ContactType ct : ContactType.values()) {
            System.out.println(resume.getContact(ct));
        }

        for (SectionType st : SectionType.values()) {
            System.out.println(resume.getSection(st));
        }
        return resume;
    }
}
