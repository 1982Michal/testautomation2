package com.jsystems.api.models;

import java.io.Serializable;

public class Person implements Serializable {

    public String name;
    public String surname;

    public Person() {

    }

    public Person(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }




    @Override

    public String toString() {
        return "Person(" +
                "name='" + name + '\'' +
                ", surname='"
                + surname + '\'' + '}';

    }
}
