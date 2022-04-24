package com.example.demo;

import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicSessionCredentials;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.simplesystemsmanagement.AWSSimpleSystemsManagement;
import com.amazonaws.services.simplesystemsmanagement.AWSSimpleSystemsManagementClientBuilder;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AWSConfig {
    private final String awsRegion = "us-east-1";
    private final String awsAccessKey = "Acess Key ID";
    private final String awsSecretKey  = "Secret Key";
    private final String sessionToken = "Session Token";


    public AWSSimpleSystemsManagement awsSimpleSystemsManagement(){

        return AWSSimpleSystemsManagementClientBuilder.standard()
                .withCredentials(new AWSStaticCredentialsProvider(new BasicSessionCredentials(awsAccessKey,awsSecretKey,sessionToken)))
                .withRegion(Regions.fromName(awsRegion))
                .build();
    }
}
