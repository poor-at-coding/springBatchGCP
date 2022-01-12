package com.Examples.job;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.LineMapper;
import org.springframework.batch.item.file.builder.FlatFileItemReaderBuilder;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.mapping.FieldSetMapper;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.batch.item.file.transform.FieldSet;
import org.springframework.batch.item.file.transform.LineTokenizer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.FileSystemResource;
import org.springframework.validation.BindException;

@Configuration
@EnableBatchProcessing
public class ImportUserJob {

    @Autowired
    private JobBuilderFactory jobBuilderFactory;

    @Autowired
    private StepBuilderFactory stepBuilderFactory;

    @Bean
    public Job job() {
        return jobBuilderFactory.get("importUserJob")
                .start(step1())
                .build();
    }

    @Bean
    public Step step1() {
        return stepBuilderFactory.get("step1")
                .chunk(1000)
                .reader(fileReader())
                .writer(list -> {})
                .build();
    }

    @Bean
    public FlatFileItemReader fileReader() {
        return new FlatFileItemReaderBuilder<>()
                .name("fileReader")
                .resource(new FileSystemResource(""))
                .linesToSkip(1)
                .lineTokenizer(createLineTokenizer())
                .fieldSetMapper(createFieldSetMapper())
                .build();
    }

    private FieldSetMapper<Object> createFieldSetMapper() {
        return new FieldSetMapper<Object>() {
            @Override
            public Object mapFieldSet(FieldSet fieldSet) throws BindException {
                return null;
            }
        };
    }

    private LineTokenizer createLineTokenizer() {
        DelimitedLineTokenizer lineTokenizer = new DelimitedLineTokenizer();
        lineTokenizer.setDelimiter(",");
        lineTokenizer.setStrict(false);
        return lineTokenizer;
    }
}
