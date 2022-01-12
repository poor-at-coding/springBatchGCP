package com.Examples.job;

import org.springframework.batch.core.configuration.support.ApplicationContextFactory;
import org.springframework.batch.core.configuration.support.GenericApplicationContextFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JobConfiguration {

    @Bean
    public ApplicationContextFactory importUserJobFactory(){
        return new GenericApplicationContextFactory(ImportUserJob.class);
    }
}
