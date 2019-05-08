package com.springclouddataflow;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;

import com.springclouddataflow.entity.Data;
import com.springclouddataflow.repository.SinkRepository;

@EnableBinding(Sink.class)
@SpringBootApplication
public class SinkApplication {

	private static Logger logger = LoggerFactory.getLogger(SinkApplication.class);

	@Autowired
	SinkRepository repository;
	
	@StreamListener(Sink.INPUT)
	public void loggerSink(String data) {
		logger.info("########## Message Start ##########");
		logger.info(data);
		logger.info("########## Message Done  ##########");
		Data fileData=new Data();
		fileData.setData(data);
		repository.save(fileData);
	}

	public static void main(String[] args) {
		SpringApplication.run(SinkApplication.class, args);
	}
}
