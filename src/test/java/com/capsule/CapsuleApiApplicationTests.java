package com.capsule;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.jdbc.Sql;

import com.capsule.model.TaskUI;


@SpringBootTest(classes = CapsuleApiApplication.class, webEnvironment = WebEnvironment.RANDOM_PORT)
class CapsuleApiApplicationTests {

	private String HOST_URL = "http://localhost:";
	
	private String TASK_LIST_URI= "/tasklist";
	
	private String ADD_TASK_URI= "/add";
	
	private String UPDATE_TASK_URI= "/update";
	
	@LocalServerPort
	private int PORT;
	
	@Autowired
	private TestRestTemplate restTemplate;

	@Sql({ "schema.sql", "data.sql" })
	@Test
	public void testTaskManagement()
	{
       final HttpHeaders headers = new HttpHeaders();
       headers.set("Content-Type", "application/json");
       
       TaskUI create = getTaskUIObject();
       HttpEntity<TaskUI> entityCreate = new HttpEntity<>(create, headers);
       String addURL = HOST_URL + PORT + ADD_TASK_URI;
       ResponseEntity<TaskUI> createTaskUI = restTemplate.exchange(addURL, HttpMethod.POST, entityCreate, TaskUI.class);
       assertEquals(200, createTaskUI.getStatusCodeValue());
       
       TaskUI update = getTaskUIObject();
       update.setPriority(10);
       HttpEntity<TaskUI>  entityUpdate = new HttpEntity<>(update, headers);
       String updateURL = HOST_URL + PORT + UPDATE_TASK_URI;
       ResponseEntity<TaskUI> updateTaskUI = restTemplate.exchange(updateURL, HttpMethod.POST, entityUpdate, TaskUI.class);
       assertEquals(200, updateTaskUI.getStatusCodeValue());
              
       HttpEntity<String> entityList = new HttpEntity<>(headers);
       String url = HOST_URL + PORT + TASK_LIST_URI;
       assertEquals(true, !restTemplate.exchange(url, HttpMethod.GET, entityList, ArrayList.class).getBody().isEmpty());
	}
	
	private TaskUI getTaskUIObject()
	{
		TaskUI taskUI = new TaskUI();
		taskUI.setEndDate("2019-12-12");
		taskUI.setParentId(1);
		taskUI.setParentTask("PTASK_NAME");
		taskUI.setPriority(20);
		taskUI.setStartDate("2019-12-12");
		taskUI.setTask("TASK_NAME");
		taskUI.setTaskId(1);
		taskUI.setTaskStatus("A");
		return taskUI;		
	}
}
