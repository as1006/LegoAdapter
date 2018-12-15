package com.xincubate.lego.processor;

import com.google.auto.service.AutoService;
import com.squareup.javapoet.JavaFile;
import com.squareup.javapoet.MethodSpec;
import com.squareup.javapoet.TypeName;
import com.squareup.javapoet.TypeSpec;
import com.xincubate.lego.annotation.LegoRegister;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import javax.annotation.processing.AbstractProcessor;
import javax.annotation.processing.Filer;
import javax.annotation.processing.Messager;
import javax.annotation.processing.ProcessingEnvironment;
import javax.annotation.processing.Processor;
import javax.annotation.processing.RoundEnvironment;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.Element;
import javax.lang.model.element.Modifier;
import javax.lang.model.element.TypeElement;
import javax.lang.model.util.Elements;
import javax.lang.model.util.Types;
import javax.tools.Diagnostic;

@AutoService(Processor.class)
public class RegisterProcessor extends AbstractProcessor {

    private Filer mFiler; //文件相关的辅助类
    private Messager mMessager;
    private Elements mElementUtils;
    private Types mTypeUtils;

    @Override
    public synchronized void init(ProcessingEnvironment processingEnv) {
        super.init(processingEnv);
        mFiler = processingEnv.getFiler();
        mMessager = processingEnv.getMessager();
        mElementUtils = processingEnv.getElementUtils();
        mTypeUtils = processingEnv.getTypeUtils();
    }

    @Override
    public Set<String> getSupportedAnnotationTypes() {
        HashSet<String> supportTypes = new LinkedHashSet<>();
        supportTypes.add(LegoRegister.class.getCanonicalName());
        return supportTypes;
    }

    @Override
    public SourceVersion getSupportedSourceVersion() {
        return SourceVersion.latestSupported();
    }

    @Override
    public boolean process(Set<? extends TypeElement> annotations, RoundEnvironment roundEnvironment) {
        mMessager.printMessage(Diagnostic.Kind.NOTE, "processing...");

        Set<? extends Element> elements = roundEnvironment.getElementsAnnotatedWith(LegoRegister.class);
        MethodSpec.Builder initMethodBuilder = MethodSpec.constructorBuilder()
                .addModifiers(Modifier.PUBLIC);
        initMethodBuilder.addStatement("items = new $T()",ArrayList.class);

        for (Element element : elements){
            TypeElement typeElement = (TypeElement) element;
            initMethodBuilder.addStatement("items.add($T.class)",mTypeUtils.getDeclaredType(typeElement));
        }

        TypeSpec finderClass = TypeSpec.classBuilder("LegoRegisterItems")
                .addModifiers(Modifier.PUBLIC)
                .addField(List.class,"items",Modifier.PUBLIC)
                .addMethod(initMethodBuilder.build())
                .build();
        try {
            JavaFile.builder("com.xincubate.lego.generate", finderClass).build().writeTo(mFiler);
        } catch (IOException e) {
            e.printStackTrace();
        }
        mMessager.printMessage(Diagnostic.Kind.NOTE, "process finish ...");
        return true;
    }
}
