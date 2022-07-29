package com.company;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        hashTable hTable = new hashTable <Person>();
        Scanner console = new Scanner(System.in);


        boolean status = false;
        while(status == false)
        {
            System.out.println("Name? type quit to quit");
            String name = console.next();
            System.out.println("Age?");
            int age = console.nextInt();

            if(name.equals("quit"))
            {
                status = true;
                continue;
            }
            Person firstPer = new Person(name, age);
            hTable.insertPerson(firstPer, firstPer.getName());
        }

    }
}
