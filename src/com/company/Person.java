package com.company;

public class Person {
    private String name;
    private int age;
    private int code;

    public Person(String name, int age)
    {
        this.name = name;
        this.age = age;

    }
    public String getName()
    {
        return name;
    }
    public int getAge()
    {
        return age;
    }
    public void setCode(int c)
    {
        code = c;
    }
    public int getCode()
    {
        return code;
    }
}
