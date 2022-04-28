package com.sunhp.activiti.config;

import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

/**
 * @author sujian
 * @Description fastjson配置
 **/
@Configuration
public class FastJsonConfig extends WebMvcConfigurationSupport {
    @Override
    protected void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
        FastJsonHttpMessageConverter converter = new FastJsonHttpMessageConverter();
        com.alibaba.fastjson.support.config.FastJsonConfig fastJsonConfig = new com.alibaba.fastjson.support.config.FastJsonConfig();
        fastJsonConfig.setSerializerFeatures(
                //保留map空的字段
                SerializerFeature.WriteMapNullValue,
                //将String类型的null转化为""
                SerializerFeature.WriteNullStringAsEmpty,
                //将number类型的null转化为0
                SerializerFeature.WriteNullNumberAsZero,
                //将List类型的null转化为[]
                SerializerFeature.WriteNullListAsEmpty,
                //将Boolean类型的null转化为false
                SerializerFeature.WriteNullBooleanAsFalse,
                //避免循环引用
                SerializerFeature.DisableCircularReferenceDetect
        );
        converter.setFastJsonConfig(fastJsonConfig);
        converter.setDefaultCharset(Charset.forName("UTF-8"));
        List<MediaType> mediaTypeList = new ArrayList<>();
        //解决中文乱码问题，相当于在Controller的@RequestMapping中加了个属性produces="application/json"
        mediaTypeList.add(MediaType.APPLICATION_JSON);
        converter.setSupportedMediaTypes(mediaTypeList);
        converters.add(converter);
    }
}
