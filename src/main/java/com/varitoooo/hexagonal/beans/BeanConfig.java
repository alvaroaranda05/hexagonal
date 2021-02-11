package com.varitoooo.hexagonal.beans;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import({
        RepositoryBeans.class
})
public class BeanConfig {

}
