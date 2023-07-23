package com.example.orange.batch.aa01;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.FileSystemResource;

import com.example.orange.common.entity.Item;

@EnableBatchProcessing
@Configuration
public class FishShopConfig {

    @Autowired
    private FishShopProcessor fishShopProcessor;
    @Autowired
    private FishShopWriter fishShopWriter;

    @Autowired
    private StepBuilderFactory stepBuilderFactory;
    @Autowired
    private JobBuilderFactory jobBuilderFactory;

    @Bean
    public FlatFileItemReader<CsvItem> fishReader() {

        DelimitedLineTokenizer lineTokenizer = new DelimitedLineTokenizer();
        lineTokenizer.setNames("id", "itemName", "price");
        lineTokenizer.setStrict(false);

        BeanWrapperFieldSetMapper<CsvItem> fieldSetMapper = new BeanWrapperFieldSetMapper<>();
        fieldSetMapper.setTargetType(CsvItem.class);

        DefaultLineMapper<CsvItem> lineMapper = new DefaultLineMapper<>();
        lineMapper.setLineTokenizer(lineTokenizer);
        lineMapper.setFieldSetMapper(fieldSetMapper);

        FlatFileItemReader<CsvItem> reader = new FlatFileItemReader<>();
        reader.setLineMapper(lineMapper);
        reader.setResource(new FileSystemResource("a.csv"));
        return reader;
    };

    @Bean
    public Job fishShopJob(@Qualifier("stepFishShop1") Step step1) {
        return jobBuilderFactory.get("fishShopJob")
                .incrementer(new RunIdIncrementer())
                .start(step1)
                .build();
    }

    @Bean
    public Step stepFishShop1() {
        return stepBuilderFactory.get("stepFishShop1")
                .<CsvItem, Item>chunk(1000)
                .reader(fishReader())
                .processor(fishShopProcessor)
                .writer(fishShopWriter)
                .build();
    }
}
