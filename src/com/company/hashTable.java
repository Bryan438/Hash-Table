package com.company;

public class hashTable {
    private Person[] array = new Person [10];
    private int count = 0;

    public int translateString(String code)
    {
        String part = code.substring(0, 2) + code.substring(code.length() - 2, code.length());
        int i = 0;
        int val = part.charAt(i);
        while(i < part.length() - 1) {
            i++;
            System.out.println(Integer.toHexString(val));
            val = val << 8;
            System.out.println(Integer.toHexString(val));
            int val2 = part.charAt(i);
            System.out.println(Integer.toHexString(val2));
            val = val + val2;
            System.out.println(Integer.toHexString(val));
        }
        return val;
    }

    public int translateInt (int code, int size) {
        int result = code % size;
        return result;
    }

    public void insertPerson(Person p, String name)
    {
        int code = translateString(p.getName());
        int uniqueIndex = translateInt(code, getLength());
        p.setCode(code);
        getArray()[uniqueIndex] = p;
        extendArray(uniqueIndex, p);

    }

    public void extendArray(int uniqueIndex, Person p)
    {
        count++;
        if(count >= getLength()/2)
        {
            Person [] newArray = new Person [getLength() * 2];
            Person [] oldArray = getArray();
            for(int i = 0; i < oldArray.length; i++)
            {
                if(oldArray[i] != null)
                {
                    uniqueIndex = translateInt(p.getCode(), newArray.length);
                    newArray[uniqueIndex] = p;
                }
            }
            setArray(newArray);
        }
    }

    public Person getPerson (String name)
    {
        int code = translateString(name);
        int uniqueIndex = translateInt(code, getLength());
        return array[uniqueIndex];
    }

    public void deletePerson (String name)
    {
        int code = translateString(name);
        int uniqueIndex = translateInt(code, getLength());
        array[uniqueIndex] = null;
    }

    private Person[] getArray()
    {
        return array;
    }
    private void setArray(Person[] newArray)
    {
        array = newArray;
    }
    private int getLength()
    {
        return array.length;
    }
}
