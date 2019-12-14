package com.capsule.service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.capsule.entity.Task;
import com.capsule.model.TaskUI;

public class TaskServiceUtility extends ParentTaskServiceUtility {

	public Task buildTask(TaskUI taskUI) {
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Task task = new Task();
		try {
		task.setEndDate(dateFormat.parse(taskUI.getEndDate()));
		task.setParentTask(buildParentTask(taskUI.getParentId(), taskUI.getParentTask()));
		task.setPriority(taskUI.getPriority());
		task.setStartDate(dateFormat.parse(taskUI.getStartDate()));
		task.setTask(taskUI.getTask());
		task.setTaskId(taskUI.getTaskId());
		task.setTaskStatus(taskUI.getTaskStatus());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return task;
	}
	

	public TaskUI buildTaskUI(Task task) {
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		TaskUI taskUI = new TaskUI();
		taskUI.setEndDate(dateFormat.format(task.getEndDate()));
		taskUI.setParentId(Integer.valueOf(task.getParentTask().getParentId()));
		taskUI.setParentTask(task.getParentTask().getParentTask());
		taskUI.setPriority(task.getPriority());
		taskUI.setStartDate(dateFormat.format(task.getStartDate()));
		taskUI.setTask(task.getTask());
		taskUI.setTaskId(task.getTaskId());
		taskUI.setTaskStatus(task.getTaskStatus());
		return taskUI;
	}
	
	public List<TaskUI> buildTaskListUI(Iterable<Task> iterable) {
		Iterator<Task> iterator = iterable.iterator();
		
		List<TaskUI> taskUIList = new ArrayList<TaskUI>();
		while (iterator.hasNext()) {
			Task task = iterator.next();
			taskUIList.add((new TaskServiceUtility()).buildTaskUI(task));
		}
		
		return taskUIList;
	}
	
	public List<TaskUI> buildTaskListUI(List<Task> list) {
		
		List<TaskUI> taskUIList = new ArrayList<TaskUI>();
		for (Task t : list) {
			taskUIList.add((new TaskServiceUtility()).buildTaskUI(t));
		}
		
		return taskUIList;
	}
	
	
//	public List<TaskUI> buildTaskListUI(List<TaskUI> taskUIList, TaskUI taskUI) {
//		List<TaskUI> list = new ArrayList<TaskUI>();
//		
//		for (TaskUI ui : taskUIList) {
//			if (objectFilter(ui, taskUI)) {
//				list.add(ui);
//			}
//		}
//		
//		return list;
//	}
	
//	private boolean objectFilter(TaskUI ui, TaskUI search) {
//		boolean matched = true;
//		if (matched && search.getTask()!=null && !search.getTask().trim().isEmpty()) {
//			if (!(search.getTask().toLowerCase().lastIndexOf(ui.getTask().toUpperCase()) > 0)) {
//				matched = false;
//			}
//		} 
//		
//		if (matched && search.getTask()!=null && !search.getTask().trim().isEmpty()) {
//			if (!(search.getTask().toLowerCase().lastIndexOf(ui.getTask().toUpperCase()) > 0)) {
//				matched = false;
//			}
//		} 
//		return matched;
//	}
}
