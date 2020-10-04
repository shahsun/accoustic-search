package com.acoustic.assignment.search.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Component;

import com.acoustic.assignment.search.Repository.UserRepository;
import com.acoustic.assignment.search.entity.User;
import com.acoustic.assignment.search.response.KeyTypeResponse;
import com.acoustic.assignment.search.response.SearchResponse;

@Component
public class SearchService {
	
	@Autowired
	UserRepository repository;
	
	@Value("${no.records}")
	private int size;
	
	public KeyTypeResponse SearchTopRecords(int page,String key) {
		KeyTypeResponse keyTypeResponse = new KeyTypeResponse();
		Page<User> userListPage= repository.getLastUserByKeyWord(key, PageRequest.of(page, size));
		List<String> userStr =  userListPage.getContent().stream().map(s->s.getFirstName()+" "+s.getLastName()).collect(Collectors.toList());
		keyTypeResponse.setName(userStr);
		return keyTypeResponse;
		
	}
	

	public SearchResponse SearcAllRecords(int page, String key) {

		SearchResponse response = new SearchResponse();
		Page<User> userListPage= repository.getLastUserByKeyWord(key, PageRequest.of(page, size));
		response.setTotalNoOfPages(userListPage.getTotalPages()); 
		response.setTotalNoOfRecords(userListPage.getTotalElements());
		List<String> userStr =  userListPage.getContent().stream().map(s->s.getFirstName()+" "+s.getLastName()).collect(Collectors.toList());
		response.setName(userStr);
		return response;
	}

}
