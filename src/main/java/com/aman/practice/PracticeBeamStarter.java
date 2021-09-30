package com.aman.practice;


import com.aman.practice.configurers.PropertiesConfigurer;
import com.aman.practice.exception.IlegalRunnerException;
import com.aman.practice.pipelineoptions.DataflowRunnerOptions;
import com.aman.practice.pipelineoptions.DirectRunnerOptions;
import com.aman.practice.pipelineoptions.FlinkRunnerOptions;
import com.aman.practice.pipelineoptions.PipelineFactory;
import lombok.extern.slf4j.Slf4j;
import org.apache.beam.runners.flink.FlinkPipelineOptions;
import org.apache.beam.runners.flink.FlinkRunner;
import org.apache.beam.sdk.Pipeline;
import org.apache.beam.sdk.io.TextIO;
import org.apache.beam.sdk.options.PipelineOptions;
import org.apache.beam.sdk.options.PipelineOptionsFactory;
import org.apache.beam.sdk.transforms.Count;
import org.apache.beam.sdk.transforms.Filter;
import org.apache.beam.sdk.transforms.FlatMapElements;
import org.apache.beam.sdk.transforms.MapElements;
import org.apache.beam.sdk.values.KV;
import org.apache.beam.sdk.values.TypeDescriptors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

import javax.annotation.PostConstruct;
import java.util.Arrays;

@Slf4j
@EnableAutoConfiguration
@SpringBootApplication
public class PracticeBeamStarter implements CommandLineRunner{

    @Value("${beam.active.runner}")
    private String runnerType;

    public static void main(String[] args) {
        log.info("String PracticeBeam Application !!! ");
        new SpringApplicationBuilder(PracticeBeamStarter.class).web(WebApplicationType.NONE).run(args);
    }

    @Override
    public void run(String... args) throws Exception {

        FlinkRunnerOptions options = null;
        Class optionClass = PipelineFactory.getRunnerOptionsClass(runnerType);
        PipelineOptionsFactory.register(optionClass);
        options= PipelineOptionsFactory.fromArgs(args).withValidation().as(FlinkRunnerOptions.class);
        options.setRunner(FlinkRunner.class);
        Pipeline p = Pipeline.create(options);
        System.out.println(options.getRunner());
        System.out.println(options.getFlinkMaster());

    }
}
