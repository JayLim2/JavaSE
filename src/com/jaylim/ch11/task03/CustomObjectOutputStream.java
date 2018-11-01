package com.jaylim.ch11.task03;

import com.sun.istack.internal.NotNull;
import com.sun.xml.internal.ws.encoding.soap.SerializationException;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
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

            if (field.get(object).equals(object)) {
                System.out.println("Cyclic reference is found. Field skipped.");
                stream.writeObject(CyclicReferenceObject.get());
            } else if (field.getType().isPrimitive() | field.getType().isInstance(java.io.Serializable.class)) {
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
