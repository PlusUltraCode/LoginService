package org.delivery.api.config.objectmapper;


import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jdk8.Jdk8Module;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ObjectMapperConfig {

    @Bean
    public ObjectMapper objectMapper(){

        var objectMapper = new ObjectMapper();

        objectMapper.registerModule(new Jdk8Module()); //jdk 8버전 이상등록

        objectMapper.registerModule(new JavaTimeModule()); //local date 시리즈

        objectMapper.configure(DeserializationFeature.FAIL_ON_IGNORED_PROPERTIES,false); // 모르는 json필드 무시

        objectMapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false); //비어있는 빈들은 무시한다.

        objectMapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);    //날짜 관련 직렬화

        objectMapper.setPropertyNamingStrategy(new PropertyNamingStrategies.SnakeCaseStrategy());   //스네이크

        return objectMapper;
    }
}
