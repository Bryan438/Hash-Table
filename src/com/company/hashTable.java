package com.company;
import java.util.*;

public class hashTable<E> {


    private Object[] buffer;
    private int count = 0;

    class Wrapper{
        private String key;
        private int code;
        private Object obj;

        public void setKey(String k) {
            key = k;
        }

        public void setCode(int c) {
            code = c;
        }

        public void setObj(Object e) {
            obj = e;
        }

        public int getCode() {
            return code;
        }
        public E getObj()
        {
            return (E)obj;
        }
    }

    public hashTable()
    {
        buffer = new Object [10];
    }
    private int translateString(String code)
    {
        String key = "";
        if(code.length() == 1)
        {
            key = code.substring(0,1) + code.substring(0,1) + code.substring(0,1) + code.substring(0,1);
        }
        else {
            key = code.substring(0, 2) + code.substring(code.length() - 2, code.length());
        }

        int i = 0;
        int val = key.charAt(i);
        while(i < key.length() - 1) {
            i++;
            System.out.println(Integer.toHexString(val));
            val = val << 8;
            System.out.println(Integer.toHexString(val));
            int val2 = key.charAt(i);
            System.out.println(Integer.toHexString(val2));
            val = val + val2;
            System.out.println(Integer.toHexString(val));
        }
        return val;
    }

    private int translateInt (int code, int size) {
        int result = code % size;
        return result;
    }

    public void insertPerson(E p, String name)
    {
        int code = translateString(name);
        int uniqueIndex = translateInt(code, buffer.length);
        Wrapper wrapper = new Wrapper();
        wrapper.setCode(code);
        wrapper.setObj(p);
        putEleAt(uniqueIndex, wrapper);
        extendArray(uniqueIndex, wrapper);

    }

    private void putEleAt(int pos, Object obj) {
        buffer[pos] = obj;
    }

    private void extendArray(int uniqueIndex, Wrapper w)
    {
        count++;
        if(count >= buffer.length/2)
        {
            Object[] newBuffer = new Object[buffer.length*2];

            for(int i = 0; i < buffer.length; i++)
            {
                if(buffer[i] != null)
                {
                    uniqueIndex = translateInt(w.getCode(), newBuffer.length);
                    newBuffer[uniqueIndex] = w;
                }
            }
            buffer = newBuffer;
        }
    }

    public E getPerson (String name)
    {
        int code = translateString(name);
        int uniqueIndex = translateInt(code, buffer.length);
        return ((Wrapper)buffer[uniqueIndex]).getObj();
    }

    public void deletePerson (String name)
    {
        int code = translateString(name);
        int uniqueIndex = translateInt(code, buffer.length);
        buffer[uniqueIndex] = null;
    }



}
