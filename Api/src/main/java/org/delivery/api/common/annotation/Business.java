package org.delivery.api.common.annotation;

import org.springframework.core.annotation.AliasFor;
import org.springframework.stereotype.Service;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Service // 이 어노테이션을 붙이면 빈으로 등록하고 Business 처리하겠따.
public @interface Business {

    @AliasFor(annotation = Service.class)
    String value() default "";
}
