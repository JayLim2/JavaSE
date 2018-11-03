package com.jaylim.ch11.task10;

import javax.annotation.Resource;
import javax.annotation.processing.AbstractProcessor;
import javax.annotation.processing.RoundEnvironment;
import javax.annotation.processing.SupportedAnnotationTypes;
import javax.annotation.processing.SupportedSourceVersion;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.Element;
import javax.lang.model.element.TypeElement;
import javax.lang.model.element.VariableElement;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Set;

@SupportedSourceVersion(SourceVersion.RELEASE_8)
@SupportedAnnotationTypes("javax.annotation.Resource")
public class URLProcessor extends AbstractProcessor {
    public URLProcessor() {
        super();
    }

    @Override
    public boolean process(Set<? extends TypeElement> annotations, RoundEnvironment roundEnv) {
        if (annotations.isEmpty()) return true;

        Set<?> annotated = roundEnv.getElementsAnnotatedWith(Resource.class);
        StringBuilder stringBuilder = new StringBuilder();
        for (Object o : annotated) {
            if (((Element) o).getKind().isField()) {
                VariableElement annotatedField = (VariableElement) o;
                Resource resource = annotatedField.getAnnotation(Resource.class);
                if (resource.name().equals("URL")) {
                    try {
                        /*
                        Загружает класс тот класс, из которого обрабатывает аннотации.
                        Поэтому компиляция с процессором происходит в 3 этапа:
                        1) компиляция класса без процессора
                        2) перепаковка процессора
                        3) компиляция класса с процессором
                         */
                        Class<?> cl = Class.forName(annotatedField.getEnclosingElement().toString());
                        Field field = cl.getDeclaredField(annotatedField.getSimpleName().toString());
                        field.setAccessible(true);
                        String value = field.getType() == String.class ? field.get(null).toString() : null;
                        URL url = new URL(value != null ? value : "");
                        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                        if (connection.getResponseCode() == 200) {
                            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                            while (reader.ready()) {
                                stringBuilder.append(reader.readLine()).append("\n");
                            }
                            stringBuilder.append("\n");
                        }
                    } catch (ClassNotFoundException ex) {
                        System.out.println("Class " + annotatedField.getEnclosingElement().toString() + " not found.");
                    } catch (NoSuchFieldException ex) {
                        ex.printStackTrace();
                        System.out.println("Field " + annotatedField.getSimpleName().toString() + " not found.");
                    } catch (IllegalAccessException ex) {
                        System.out.println("Field " + annotatedField.getSimpleName().toString() + " illegal access exception");
                    } catch (MalformedURLException ex) {
                        System.out.println("URL error");
                    } catch (IOException ex) {
                        System.out.println("I/O Exception.");
                    }
                }
            }
        }

        System.out.println(stringBuilder.toString());

        return true;
    }
}
