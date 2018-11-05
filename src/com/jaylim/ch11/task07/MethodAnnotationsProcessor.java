package com.jaylim.ch11.task07;

import javax.annotation.processing.AbstractProcessor;
import javax.annotation.processing.RoundEnvironment;
import javax.annotation.processing.SupportedAnnotationTypes;
import javax.annotation.processing.SupportedSourceVersion;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.*;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.annotation.Annotation;
import java.util.List;
import java.util.Set;

@SupportedAnnotationTypes({"com.jaylim.ch11.task06.Param", "com.jaylim.ch11.task06.Return"}) // FIXME: 03.11.2018
@SupportedSourceVersion(SourceVersion.RELEASE_8)
public class MethodAnnotationsProcessor extends AbstractProcessor {
    public MethodAnnotationsProcessor() {
        super();
    }

    @Override
    public boolean process(Set<? extends TypeElement> annotations, RoundEnvironment roundEnv) {
        if (annotations.isEmpty()) return true;

        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append("PROCESSING @Param AND @Return RESULT\n\n");

        Set<?> methodsByParams = roundEnv.getElementsAnnotatedWith(Params.class);
        Set<?> methodsByReturns = roundEnv.getElementsAnnotatedWith(Return.class);
        for (Object m : methodsByParams) {
            ExecutableElement method = (ExecutableElement) m;
            Set<Modifier> modifiers = method.getModifiers();
            Name methodName = method.getSimpleName();
            List<?> params = method.getParameters();
            for (Modifier modifier : modifiers) {
                stringBuilder.append(modifier.toString()).append(" ");
            }
            stringBuilder.append(methodName).append("(");
            for (Object param : params) {
                VariableElement var = (VariableElement) param;
                stringBuilder.append(var.getSimpleName()).append(", ");
            }
            stringBuilder.append(") { \n\t...");
            Annotation returnAnnotation = null;
            Annotation[] methodParamsAnnotations = method.getAnnotationsByType(Param.class);
            if (methodsByReturns.contains(method)) {
                stringBuilder.append("\nreturn ").append(method.getReturnType()).append(";");
                returnAnnotation = method.getAnnotation(Return.class);
                methodsByReturns.remove(method);
            }
            stringBuilder.append("\n}\nMethod annotated with: ");
            for (Annotation annotation : methodParamsAnnotations) {
                stringBuilder.append(annotation.toString()).append(", ");
            }
            if (returnAnnotation != null) {
                stringBuilder.append(returnAnnotation.toString());
            }
            stringBuilder.append("\n\n");
        }

        for (Object m : methodsByReturns) {
            ExecutableElement method = (ExecutableElement) m;
            Set<Modifier> modifiers = method.getModifiers();
            Name methodName = method.getSimpleName();
            List<?> params = method.getParameters();
            for (Modifier modifier : modifiers) {
                stringBuilder.append(modifier.toString()).append(" ");
            }
            stringBuilder.append(methodName).append("(");
            for (Object param : params) {
                VariableElement var = (VariableElement) param;
                stringBuilder.append(var.getSimpleName()).append(", ");
            }
            stringBuilder.append(") { \n\t...");
            stringBuilder.append("\n\treturn ").append(method.getReturnType()).append(";");

            Annotation returnAnnotation = method.getAnnotation(Return.class);
            Annotation[] methodParamsAnnotations = method.getAnnotationsByType(Param.class);
            stringBuilder.append("\n}\nMethod annotated with: ");
            for (Annotation annotation : methodParamsAnnotations) {
                stringBuilder.append(annotation.toString()).append(", ");
            }
            stringBuilder.append("\n\n");
        }

        File file = new File("methods.html");
        try (PrintWriter printWriter = new PrintWriter(new FileWriter(file))) {
            if (!file.exists()) {
                file.createNewFile();
            }
            printWriter.println(stringBuilder.toString());
            System.out.println(stringBuilder.toString());
        } catch (IOException e) {
            System.out.println("EXCEPTION: " + e.getMessage());
        }

        return true;
    }
}
