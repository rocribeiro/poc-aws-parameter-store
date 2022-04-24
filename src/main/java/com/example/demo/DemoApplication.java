package com.example.demo;

import com.amazonaws.services.simplesystemsmanagement.model.GetParameterRequest;
import com.amazonaws.services.simplesystemsmanagement.model.ParameterNotFoundException;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;

@SpringBootApplication
@Configuration
public class DemoApplication {
	private GetParameterRequest buildFetchRequest(String parameterName) {
		return new GetParameterRequest().withName(parameterName).withWithDecryption(true);
	}

	private String getByParameterName(String parameterName) {
		try {
			AWSConfig awsConfig = new AWSConfig();
			return awsConfig.awsSimpleSystemsManagement().getParameter(buildFetchRequest(parameterName)).getParameter()
					.getValue();
		}
		catch (ParameterNotFoundException e) {
			throw e;
		}
	}
	public static void main(String[] args) {

		DemoApplication demoApplication = new DemoApplication();

		System.out.println(demoApplication.getByParameterName("Parametro-name"));
	}


}
