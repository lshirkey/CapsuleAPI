package com.capsule.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.capsule.model.SearchTask;
import com.capsule.model.TaskUI;
import com.capsule.service.TaskService;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class TaskController {

	@Autowired
	TaskService taskService;
	
	@PostMapping(path = "/add", consumes = "application/json", produces = "application/json")
	@CrossOrigin(origins = "http://localhost:4200", allowedHeaders = "*")
	public ResponseEntity<TaskUI> add(@RequestBody TaskUI task) {
		TaskUI taskUI = taskService.addTask(task);
		return ResponseEntity.ok(taskUI);
	}

	@PostMapping(path = "/update", consumes = "application/json", produces = "application/json")
	@CrossOrigin(origins = "http://localhost:4200", allowedHeaders = "*")
	public ResponseEntity<TaskUI> update(@RequestBody TaskUI task) {
		taskService.updateTask(task);
		return ResponseEntity.ok(taskService.viewTask(task));
	}
	
	@GetMapping(path = "/tasklist", consumes = "application/json", produces = "application/json")
	@CrossOrigin(origins = "http://localhost:4200", allowedHeaders = "*")
	public ResponseEntity<List<TaskUI>> taskList() {
		return ResponseEntity.ok(taskService.listTask());
	}
	
	@PostMapping(path = "/view", consumes = "application/json", produces = "application/json")
	@CrossOrigin(origins = "http://localhost:4200", allowedHeaders = "*")
	public ResponseEntity<TaskUI> view(@RequestBody TaskUI task) {
		return ResponseEntity.ok(taskService.viewTask(task));
	}
	
	
	@PostMapping(path = "/searchtasklist", consumes = "application/json", produces = "application/json")
	@CrossOrigin(origins = "http://localhost:4200", allowedHeaders = "*")
	public ResponseEntity<List<TaskUI>> searchTaskList(@RequestBody SearchTask searchTask) {
		return ResponseEntity.ok(taskService.searchTaskList(searchTask));
	}
	
//	@PostMapping(path = "/endTask", consumes = "application/json", produces = "application/json")
//	@CrossOrigin(origins = "http://localhost:4200", allowedHeaders = "*")
//	public ResponseEntity<List<TaskUI>> endTask(@RequestBody TaskUI task) {
//		taskService.updateTask(task);
//		List<TaskUI> list = taskService.listTask();
//		if (list == null || list.isEmpty()) {
//			list = new ArrayList<TaskUI>();
//		}
//		return ResponseEntity.ok(list);
//	}
}