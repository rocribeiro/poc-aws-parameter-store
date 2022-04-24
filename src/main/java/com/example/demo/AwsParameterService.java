package com.example.demo;

import com.amazonaws.services.simplesystemsmanagement.model.GetParameterRequest;
import com.amazonaws.services.simplesystemsmanagement.model.ParameterNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AwsParameterService {

    @Autowired
    private AWSConfig awsConfig;

    private GetParameterRequest buildFetchRequest(String parameterName) {
        return new GetParameterRequest().withName(parameterName).withWithDecryption(true);
    }

    public String getByParameterName(String parameterName) {
        AWSConfig awsConfig1 = new AWSConfig();
        try {
            return awsConfig.awsSimpleSystemsManagement().getParameter(buildFetchRequest(parameterName)).getParameter()
                    .getValue();
        }
        catch (ParameterNotFoundException e) {
            return null;
        }
    }
}
