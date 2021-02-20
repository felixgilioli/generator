package com.generator.generator.config;

import java.net.InetAddress;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer;

import no.api.freemarker.java8.Java8ObjectWrapper;

@Configuration
@EnableWebMvc
public class FreemarkerConfig implements BeanPostProcessor, WebMvcConfigurer {

    @Value("${server.port}")
    private int port;

    /**
     Após a criação de qualquer Bean feita pelo Spring esse método é invocado,
     por isso verificamos se o objeto Bean recebido por parâmetro é uma instancia de FreeMarkerConfigure,
     para que assim sejamos capazes de definir o Wrapper padrão do FreeMarker,
     definindo nossa dependência que sabe lidar com os novos objetos de Data do Java 8
     */
    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        if (bean instanceof FreeMarkerConfigurer) {
            FreeMarkerConfigurer configurer = (FreeMarkerConfigurer) bean;
            freemarker.template.Configuration configuration = configurer.getConfiguration();
            try {
                configuration.setSharedVariable("path", "http://" + InetAddress.getLocalHost().getHostName() + ":" + this.port);
            } catch (Exception e) {
                e.printStackTrace();
            }
            configuration.setObjectWrapper(new Java8ObjectWrapper(freemarker.template.Configuration.getVersion()));
        }
        return bean;
    }

    /**
     Definimos que os arquivos estáticos a serem expostos se encontram no diretório resources e static que ficam no classpath da nossa aplicação,
     bem como também configuração a utilização de webjars.
     */
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/**")
                .addResourceLocations(
                        "classpath:/META-INF/resources/",
                        "classpath:/resources/",
                        "classpath:/static/",
                        "/webjars/"
                );
    }

}
