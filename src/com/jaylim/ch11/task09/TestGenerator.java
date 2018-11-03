package com.jaylim.ch11.task09;

import javax.annotation.processing.AbstractProcessor;
import javax.annotation.processing.RoundEnvironment;
import javax.annotation.processing.SupportedAnnotationTypes;
import javax.annotation.processing.SupportedSourceVersion;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.ExecutableElement;
import javax.lang.model.element.TypeElement;
import javax.tools.JavaFileObject;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.annotation.Annotation;
import java.util.Set;

@SupportedAnnotationTypes("com.jaylim.ch11.task08.TestCases")
@SupportedSourceVersion(SourceVersion.RELEASE_8)
public class TestGenerator extends AbstractProcessor {
    private static final String packageName = "com.jaylim.ch11.task08.";

    public TestGenerator() {
        super();
    }

    @Override
    public boolean process(Set<? extends TypeElement> annotations, RoundEnvironment roundEnv) {
        if (annotations.isEmpty()) return true;

        try {
            Set<?> methods = roundEnv.getElementsAnnotatedWith(TestCases.class);
            for (Object method : methods) {
                ExecutableElement methodElem = (ExecutableElement) method;
                JavaFileObject sourceFile = processingEnv.getFiler().createSourceFile(methodElem.getEnclosingElement() + "Test");
                try (PrintWriter out = new PrintWriter(sourceFile.openWriter())) {
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("import ").append(methodElem.getEnclosingElement()).append(";\n\n");
                    stringBuilder.append("public class ").append(methodElem.getEnclosingElement().getSimpleName()).append("Test").append(" {\n");
                    stringBuilder.append("\tpublic static void main(String[] args) {\n");
                    Annotation[] testCases = methodElem.getAnnotationsByType(TestCase.class);
                    for (int i = 0; i < testCases.length; i++) {
                        TestCase testCaseElem = (TestCase) testCases[i];
                        stringBuilder.append("\t\tassert ");
                        stringBuilder.append(methodElem.getEnclosingElement().getSimpleName()).append(".").append(methodElem.getSimpleName());
                        stringBuilder.append("(").append(testCaseElem.params()).append(")");
                        stringBuilder.append(" == ");
                        stringBuilder.append(testCaseElem.expected());
                        stringBuilder.append(";\n");
                    }
                    stringBuilder.append("\t}\n");
                    stringBuilder.append("}");
                    out.println(stringBuilder.toString());
                    System.out.println(stringBuilder.toString());
                }
            }
        } catch (IOException e) {
            System.out.println("EXCEPTION: " + e.getMessage());
        }

        return true;
    }
}
