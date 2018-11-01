package com.jaylim.ch11.task02;

import com.sun.istack.internal.NotNull;
import com.sun.xml.internal.ws.encoding.soap.SerializationException;

import java.io.*;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;

public class CustomObjectOutputStream {
    private ObjectOutputStream stream;

    public CustomObjectOutputStream(@NotNull ObjectOutputStream stream) {
        this.stream = stream;
    }

    public void writeObject(Object object) throws IOException, IllegalAccessException {
        Class<?> cl = object.getClass();

        Annotation annotation = cl.getAnnotation(Serializable.class);
        if (annotation == null) {
            throw new SerializationException("Serialization not supported.");
        }

        stream.writeUTF(cl.getCanonicalName());

        Field[] fields = cl.getDeclaredFields();
        for (Field field : fields) {
            field.setAccessible(true);
            if (field.getType().isPrimitive() | field.getType().isInstance(java.io.Serializable.class)) {
                stream.writeObject(field.get(object));
            }
        }
    }

    public static CustomObjectOutputStream openStream(String filename) throws IOException {
        return new CustomObjectOutputStream(
                new ObjectOutputStream(
                        new FileOutputStream(
                                new File(filename)
                        )
                )
        );
    }
}
