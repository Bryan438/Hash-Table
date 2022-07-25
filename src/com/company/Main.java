package com.company;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        hashTable hTable = new hashTable();
        Scanner console = new Scanner(System.in);


        boolean status = false;
        while(status == false)
        {
            System.out.println("Name?, type quit to quit");
            String name = console.next();
            System.out.println("Age?");
            int age = console.nextInt();

            if(name.equals("quit"))
            {
                status = true;
            }
            Person firstPer = new Person (name, age);
            hTable.insertPerson(firstPer);
            Person p = hTable.getPerson("bryanwang");
            System.out.println(p.getName() + " " + p.getAge());
            hTable.deletePerson("bryanwang");
        }

    }
}
