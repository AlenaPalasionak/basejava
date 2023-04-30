package com.urise.webapp;

import com.urise.webapp.model.Resume;


public class ResumeTestData {

    public static void main(String[] args) {
        Resume resume = new Resume("1", "r1");


        //1/ ПРОВЕРЬТЕ свою модель: создайте класс ResumeTestData с методом main, а в нем объект Resume и заполните
        // все его разделы данными, взятыми из Образца резюме. Выведите все секции на консоль

         //2/Реализуйте метод, который будет принимать uuid и fullName, создавать резюме,
        // заполнять его данными (все секции резюме должны быть заполнены) и возвращать для тестирования в
        // AbstractStorageTest. Используйте его для всех резюме, создаваемых в AbstractStorageTest
    }
}
