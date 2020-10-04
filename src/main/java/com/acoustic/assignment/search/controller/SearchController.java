package com.acoustic.assignment.search.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.acoustic.assignment.search.response.KeyTypeResponse;
import com.acoustic.assignment.search.response.SearchResponse;
import com.acoustic.assignment.search.service.SearchService;

@RestController
public class SearchController {
	

	@Autowired
	SearchService searchService;
	
	@GetMapping("/search/{text}")
	public ResponseEntity<KeyTypeResponse> getTopResult(@PathVariable("text") String text) {
		
		return ResponseEntity.ok(searchService.SearchTopRecords(0,text));
						
	}
	@GetMapping("/allsearch/{text}/{pageNo}")
	public ResponseEntity<SearchResponse> getResult(@PathVariable("text") String text,@PathVariable("pageNo") int pageNo) {
		
		return ResponseEntity.ok(searchService.SearcAllRecords(pageNo,text));
						
	}

}
