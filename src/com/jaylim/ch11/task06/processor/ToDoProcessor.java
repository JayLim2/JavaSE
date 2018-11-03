package com.jaylim.ch11.task06.processor;

import com.jaylim.ch11.task06.ToDo;

import javax.annotation.processing.AbstractProcessor;
import javax.annotation.processing.RoundEnvironment;
import javax.annotation.processing.SupportedAnnotationTypes;
import javax.annotation.processing.SupportedSourceVersion;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.Element;
import javax.lang.model.element.TypeElement;
import javax.tools.Diagnostic;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Set;

@SupportedAnnotationTypes("com.jaylim.ch11.task05.ToDo")
@SupportedSourceVersion(SourceVersion.RELEASE_8)
public class ToDoProcessor extends AbstractProcessor {

    public ToDoProcessor() {
        super();
    }

    @Override
    public boolean process(Set<? extends TypeElement> annotations, RoundEnvironment roundEnv) {
        if (annotations.isEmpty()) return true;

        File file = new File("todo.log");
        try (PrintWriter writer = new PrintWriter(new FileWriter(file))) {
            Set<?> elements = roundEnv.getElementsAnnotatedWith(ToDo.class);
            StringBuilder stringBuilder = new StringBuilder();

            stringBuilder.append("PROCESSING RESULT:\n\n");

            for (Object o : elements) {
                Element element = (Element) o;
                stringBuilder.append(element.getKind()).append(", ").append(element.getSimpleName());
                stringBuilder.append("\n#TODO: ").append(element.getAnnotation(ToDo.class).message());
                stringBuilder.append("\n\n");
            }

            processingEnv.getMessager().printMessage(Diagnostic.Kind.NOTE, stringBuilder.toString());

            System.out.println("Hello world");

            writer.println(stringBuilder.toString());
        } catch (Exception e) {
            return false;
        }

        return true;
    }
}
