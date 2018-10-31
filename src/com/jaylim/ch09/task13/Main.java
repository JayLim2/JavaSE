package com.jaylim.ch09.task13;

import java.io.*;

public class Main {
    public static void main(String[] args) throws CloneNotSupportedException {
        TestObject object1 = new TestObject();
        TestObject object2 = (TestObject) object1.clone();
        object1.setParam(999);
        System.out.println(object1);
        System.out.println(object2);
    }
}

class TestObject implements Serializable, Cloneable {
    private int param = 154;

    public int getParam() {
        return param;
    }

    public void setParam(int param) {
        this.param = param;
    }

    @Override
    protected Object clone() {
        byte[] arr = new byte[1024];
        ByteArrayOutputStream baos = new ByteArrayOutputStream(1024);

        Object obj = null;
        try {
            ObjectOutputStream out = new ObjectOutputStream(baos);
            out.writeObject(this);
            arr = baos.toByteArray();
            ObjectInputStream in = new ObjectInputStream(new ByteArrayInputStream(arr));
            obj = in.readObject();
        } catch (ClassNotFoundException ex) {
            System.out.println("Deserializing class not exists.");
        } catch (IOException ex) {
            System.out.println("IOException");
        }

        return obj;
    }

    @Override
    public String toString() {
        return "param: " + param;
    }
}
