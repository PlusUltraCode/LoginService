package org.delivery.api.common.annotation;

import org.springframework.core.annotation.AliasFor;
import org.springframework.stereotype.Service;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Service  //이 어노테이션을 붙이면 데이터를 변환하겠다. 빈으로 등록하고
public @interface Converter {

    @AliasFor(annotation = Service.class)
    String value() default "";
}
