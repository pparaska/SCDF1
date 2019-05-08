package com.springclouddataflow;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Processor;
import org.springframework.integration.annotation.Transformer;

@EnableBinding(Processor.class)
@SpringBootApplication
public class ProcessorApplication {

	@Transformer(inputChannel = Processor.INPUT, outputChannel = Processor.OUTPUT)
	public Object transform(String path) throws IOException {
		File file = new File(path);
		try (BufferedReader br = new BufferedReader(new FileReader(file))) {
			String currentLine;
			StringBuffer message = new StringBuffer();
			while ((currentLine = br.readLine()) != null) {
				message.append(currentLine);
				message.append(System.lineSeparator());
			}
			return message.toString();
		}
	}

	public static void main(String[] args) {
		SpringApplication.run(ProcessorApplication.class, args);
	}
	
}
