package com.jsystems.api.models;

public class TestuserGeneric<T> {
    public T id;
    public String name;
    public String surname;


    @Override
    public String toString() {
        return "TestuserGeneric{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                '}';
    }
}
