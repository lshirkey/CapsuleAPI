package com.capsule.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capsule.model.ParentTaskUI;
import com.capsule.service.ParentService;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class ParentTaskController {

	@Autowired
	ParentService parentService;

	@GetMapping(path = "/parentlist", consumes = "application/json", produces = "application/json")
	@CrossOrigin(origins = "http://localhost:4200", allowedHeaders = "*")
	public ResponseEntity<List<ParentTaskUI>> taskList() {
		return ResponseEntity.ok(parentService.listParentTask());
	}
}