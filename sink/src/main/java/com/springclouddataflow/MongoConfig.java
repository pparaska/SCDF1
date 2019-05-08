package com.springclouddataflow;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;

import com.mongodb.MongoClient;

@Configuration
public class MongoConfig extends AbstractMongoConfiguration {

	@Override
	public MongoClient mongoClient() {
		return new MongoClient("172.18.0.4", 27017);
	}

	@Override
	protected String getDatabaseName() {
		return "test";
	}

	
	

	/*
	 * @Override protected String getDatabaseName() { return "test"; }
	 * 
	 * @Override public MongoClient mongoClient() { return new
	 * MongoClient("172.18.0.4", 27017); }
	 * 
	 * @Override protected String getMappingBasePackage() { return "org.baeldung"; }
	 * 
	 * @Override public Mongo mongo() throws Exception { // TODO Auto-generated
	 * method stub return null; }
	 */
}

//172.18.0.4