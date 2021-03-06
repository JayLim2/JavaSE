package com.jaylim.ch11.task02;

import com.sun.istack.internal.NotNull;
import com.sun.xml.internal.ws.encoding.soap.SerializationException;

import java.io.*;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

public class CustomObjectInputStream {
    private ObjectInputStream stream;

    public CustomObjectInputStream(@NotNull ObjectInputStream stream) {
        this.stream = stream;
    }

    public Object readObject() throws IOException, NoSuchMethodException, ClassNotFoundException, InstantiationException, IllegalAccessException, InvocationTargetException {
        Object object = null;

        String className = stream.readUTF();
        Class<?> cl = Class.forName(className);

        //Serializable?
        Annotation annotation = cl.getAnnotation(Serializable.class);
        if (annotation == null) {
            throw new NotSerializableException("Serialization not supported");
        }

        //Конструируем пустой объект
        if (cl.getConstructor() == null) {
            throw new SerializationException("No default constructor");
        }

        object = cl.newInstance();

        Field[] fields = cl.getDeclaredFields();
        for (Field field : fields) {
            field.setAccessible(true);

            if (field.getType().isPrimitive() || field.getType().isInstance(java.io.Serializable.class)) {
                field.set(object, stream.readObject());
            }
        }

        return object;
    }

    public static CustomObjectInputStream openStream(String filename) throws IOException {
        return new CustomObjectInputStream(
                new ObjectInputStream(
                        new FileInputStream(
                                new File(filename)
                        )
                )
        );
    }
}
