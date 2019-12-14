package com.capsule.service;

import java.util.List;
import java.util.Map;

import com.capsule.model.SearchTask;
import com.capsule.model.TaskUI;

public interface TaskService {

	public TaskUI addTask(TaskUI taskUI);
	
	public TaskUI updateTask(TaskUI taskUI);
	
	public void deleteTask(TaskUI taskUI);
	
	public TaskUI viewTask(TaskUI taskUI);
	
	public List<TaskUI> listTask();
	
	public List<TaskUI> listTask(Map<String, String> map);
	
	public List<TaskUI> searchTaskList(SearchTask searchTask);
 }
