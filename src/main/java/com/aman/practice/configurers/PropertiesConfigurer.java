package com.aman.practice.configurers;

import lombok.Builder;
import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Configuration
@Data
public class PropertiesConfigurer {

    @Value("${file.input.dir}")
    private String inputFile;

    @Value("${file.output.dir}")
    private String outputFile;

}
