package com.acoustic.assignment.search;
import java.io.File;
import java.util.Collections;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;

import com.acoustic.assignment.search.Repository.UserRepository;
import com.acoustic.assignment.search.entity.User;
import com.fasterxml.jackson.databind.MappingIterator;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;



@Component
public class UserDaoServiceCommandLineRunner 
implements CommandLineRunner{

	@Autowired
	UserRepository repository;
	
	
	private static final Logger log=LoggerFactory.getLogger(UserDaoServiceCommandLineRunner.class);
	
	@Override
	public void run(String... args) throws Exception {
		
		try {
		List<User> userList = loadObjectList(User.class,"user.csv");
		repository.saveAll(userList);
		}
		catch(Exception e) {
			log.error("Error while saving records"+e);
		}
		
		
		log.debug("Inserting records done");		
	}
	public <T> List<T> loadObjectList(Class<T> type, String fileName) {
	    try {
	        CsvSchema bootstrapSchema = CsvSchema.emptySchema().withHeader();
	        CsvMapper mapper = new CsvMapper();
	        File file = new ClassPathResource(fileName).getFile();
	        MappingIterator<T> readValues = 
	          mapper.reader(type).with(bootstrapSchema).readValues(file);
	        return readValues.readAll();
	    } catch (Exception e) {
	    	log.error("Error occurred while loading object list from file " + fileName, e);
	        return Collections.emptyList();
	    }
	}
	
	

}
