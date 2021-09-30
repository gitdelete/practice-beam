package com.aman.practice.pipelineoptions;

import com.aman.practice.exception.IlegalRunnerException;
import com.aman.practice.pipelineoptions.aws.AWSStorageTransferDirectOptions;
import com.aman.practice.pipelineoptions.gcp.GCPStorageTransferDataflowOptions;
import com.aman.practice.pipelineoptions.gcp.GCPStorageTransferDirectOptions;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class PipelineFactory {

    public static Class getRunnerOptionsClass(String optionType){

        Class optionClass;
        if(optionType.equals("AWS-Direct")){
            optionClass= AWSStorageTransferDirectOptions.class;
        }else if(optionType.equals("GCP-Direct")){
            optionClass= GCPStorageTransferDirectOptions.class;
        }else if(optionType.equals("GCP-Dataflow")){
            optionClass= GCPStorageTransferDataflowOptions.class;
        }else if(optionType.equals("Direct")){
            optionClass= DirectRunnerOptions.class;
        }else if(optionType.equals("Flink")){
            optionClass= FlinkRunnerOptions.class;
        }else {
            log.info("Defined runnerType = "+optionType+ " is illegal type !!");
            throw new IlegalRunnerException("Defined runnerType = "+optionType+ " is illegal type !!");
        }
        return optionClass;
    }

}
