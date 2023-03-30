package com.example.springdocboot3.jsonview;

import com.fasterxml.jackson.annotation.JsonView;
import io.swagger.v3.core.converter.AnnotatedType;
import io.swagger.v3.core.converter.ModelConverters;
import io.swagger.v3.core.converter.ResolvedSchema;

import java.lang.annotation.Annotation;

/**
 * SpringDocAnnotationsUtils.extractSchema から
 * Swagger-coreのModelConverters.getInstance().resolveAsResolvedSchemaを呼び出している箇所で失敗
 */
public class Test {
  public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, NoSuchFieldException {
    JsonView jsonview = JsonViewController.class.getMethod("create", MealParty.class).getAnnotation(JsonView.class);
    Annotation[] annotations = MealParty.class.getDeclaredField("name").getAnnotations();

    /**
     *  おそらくModelResolver.hiddenByJsonViewで
     *  annotationsがある箇所だけをチェックしているのが原因
     *  annotationがない箇所も対象になる。
     *          boolean containsJsonViewAnnotation = false;をtrueに変えればいけそう
     *
     *  いやダメそう: https://github.com/swagger-api/swagger-core/issues/4127
     *  AnnotatedTypeにmapperを渡して設定をチェックすればいけるか。
     *  そもそもJSONVIEWでありえる設定が何があるか確認して1つだけならそのプロパティを追加すればいけるかも
      */
    ResolvedSchema resolvedSchema = ModelConverters.getInstance()
         .resolveAsResolvedSchema(
            new AnnotatedType(MealParty.class).resolveAsRef(true).jsonViewAnnotation(jsonview).ctxAnnotations(annotations));
    System.out.println(resolvedSchema.referencedSchemas.get("MealParty_Public").getProperties().keySet());
  }
}
