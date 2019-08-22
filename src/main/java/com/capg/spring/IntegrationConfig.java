package com.capg.spring;

import java.io.File;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.dsl.IntegrationFlow;
import org.springframework.integration.dsl.IntegrationFlows;
import org.springframework.integration.dsl.Pollers;
import org.springframework.integration.file.FileReadingMessageSource;
import org.springframework.integration.file.FileWritingMessageHandler;

/**
 * @author chilaksh
 * 
 * Class to read and write the file using DSL(Domain Specific Language)
 *
 */
@Configuration
public class IntegrationConfig {

	@Autowired
	private Processor processor;

	/**
	 * use of DSL(Domain Specific Language) to transform a CSV data to JSON format
	 * 
	 * @return json format
	 * 
	 */
	@Bean
	public IntegrationFlow integrationFlow() {
		return IntegrationFlows.from(fileReader(), spec -> spec.poller(Pollers.fixedDelay(500)))

				.transform(processor, "transform")
                
				.handle(fileWriter()).get();
	}

	/**
	 * Writing data to destination folder using FileWritingMessageHandler
	 * 
	 * @return the file with json format
	 * 
	 */
	@Bean
	public FileWritingMessageHandler fileWriter() {
		FileWritingMessageHandler handler = new FileWritingMessageHandler(new File("destination"));

		handler.setExpectReply(false);
		return handler;
	}
	
	

	/**
	 * Reading data from CSV file using FileReadingMessageSource
	 * 
	 * @return the data in csv format
	 * 
	 */
	@Bean
	public FileReadingMessageSource fileReader() {
		FileReadingMessageSource source = new FileReadingMessageSource();

		source.setDirectory(new File("source"));
		return source;
	}

}