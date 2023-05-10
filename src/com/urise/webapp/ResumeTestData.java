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
        resume.addContact(PHONE, "+7(921) 855-0482");
        resume.addContact(SKYPE, "skype:grigory.kislin");
        resume.addContact(MOBILE, "3465645645645");
        resume.addContact(HOME_PHONE, "44 44 55");
        resume.addContact(MAIL, "gkislin@yandex.ru");
        resume.addContact(LINKED_IN, "https://www.linkedin.com/in/gkislin/");
        resume.addContact(GIT_HUB, "https://github.com/gkislin");
        resume.addContact(STACK_OVERFLOW, "https://stackoverflow.com/users/548473/grigory-kislin");
        resume.addContact(HOME_PAGE, "http://gkislin.ru/");

        resume.addSection(OBJECTIVE, new SimpleTextSection
                ("Ведущий стажировок и корпоративного обучения по Java Web и Enterprise технологиям"));
        resume.addSection(PERSONAL, new SimpleTextSection
                ("Аналитический склад ума, сильная логика, креативность, инициативность. Пурист кода и архитектуры."));
        resume.addSection(ACHIEVEMENT, new ListSection("Achievement1", "Achievement2", "Achievement3"));
        resume.addSection(QUALIFICATIONS, new ListSection("QUALIFICATION1", "QUALIFICATION2", "QUALIFICATION3"));
        resume.addSection(EXPERIENCE, new OrganisationSection(new Organisation
                ("Java Online Projects"
                        , "https://javaops.ru/"
                        , new Organisation.Position(2013, Month.of(10), "\n" +
                        "Автор проекта."
                        , "Создание, организация и проведение Java онлайн проектов и стажировок.")
                )));

        resume.addSection(SectionType.EDUCATION, new OrganisationSection(new Organisation
                ("Coursera"
                        , "https://www.coursera.org/learn/scala-functional-programming"
                        , new Organisation.Position(2013, Month.of(3), 2013, Month.of(3)
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
