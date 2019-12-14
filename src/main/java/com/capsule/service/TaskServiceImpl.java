package com.capsule.service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capsule.dao.TaskRepository;
import com.capsule.entity.Task;
import com.capsule.model.SearchTask;
import com.capsule.model.TaskUI;

@Service
public class TaskServiceImpl implements TaskService {
	
	@Autowired
	TaskRepository taskRepository;

	@Override
	public TaskUI addTask(TaskUI taskUI) {
		Task task =	(new TaskServiceUtility()).buildTask(taskUI);
		Task taskAdd = taskRepository.save(task);
		return (new TaskServiceUtility()).buildTaskUI(taskAdd);
	}

	@Override
	public TaskUI updateTask(TaskUI taskUI) {
		Task task =	(new TaskServiceUtility()).buildTask(taskUI);
		Task taskAdd = taskRepository.save(task);
		return (new TaskServiceUtility()).buildTaskUI(taskAdd);
	}

	@Override
	public void deleteTask(TaskUI taskUI) {
		Task task =	(new TaskServiceUtility()).buildTask(taskUI);
		taskRepository.delete(task);
	}

	@Override
	public TaskUI viewTask(TaskUI taskUI) {
		int taskId = taskUI.getTaskId();
		Optional<Task> task = taskRepository.findById(taskId);
		if (task.isPresent()) {
			return (new TaskServiceUtility()).buildTaskUI(task.get());
		} else {
			return null;
		}
	}

	@Override
	public List<TaskUI> listTask() {
		Iterable<Task> iterable = taskRepository.findAll();	
		List<TaskUI> taskUIList = (new TaskServiceUtility()).buildTaskListUI(iterable);

		return taskUIList;		
	}

	@Override
	public List<TaskUI> listTask(Map<String, String> map) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<TaskUI> searchTaskList(SearchTask searchTask) {

//		SearchTask searchTask = new SearchTask();
//		searchTask.setfPriority("0");
//		searchTask.settPriority("30");
//		searchTask.setTask("TASKNew");
//		searchTask.setpTask("Worldcup");
//		searchTask.setsDate("2019-12-07");
//		searchTask.seteDate("2019-12-10");
//		return searchTaskList(searchTask);
		
		int fPriority;
		int tPriority;
		String task;
		String pTask;
		Date sDate= new Date();
		Date eDate= new Date();

		if (searchTask.getsDate() == null) {
			sDate = taskRepository.minStartDate();
		} else if ("".equals(searchTask.getsDate())) {
			sDate = taskRepository.minStartDate();
		} else {
			try {
				sDate = new SimpleDateFormat("yyyy-MM-dd").parse(searchTask.getsDate());
			} catch (Exception e) {e.printStackTrace();}
		}
		
		if (searchTask.geteDate() == null) {
			eDate = taskRepository.maxEndDate();
		} else if ("".equals(searchTask.geteDate())) { 
			eDate = taskRepository.maxEndDate();
		} else {
			try {
				eDate = new SimpleDateFormat("yyyy-MM-dd").parse(searchTask.geteDate());
			} catch (Exception e) {e.printStackTrace();}
		}
		
		if (searchTask.getfPriority()==null || searchTask.getfPriority().isEmpty()) {
			fPriority = 0;
		} else {
			fPriority = Integer.parseInt(searchTask.getfPriority());
		}
		
		if (searchTask.gettPriority()==null || searchTask.gettPriority().isEmpty()) {
			tPriority = 30;
		} else {
			tPriority = Integer.parseInt(searchTask.gettPriority());
		}
		
		if (searchTask.getTask()==null) {
			task = "";
		} else {
			task = searchTask.getTask();
		}
		
		if (searchTask.getpTask()==null) {
			pTask = "";
		} else {
			pTask = searchTask.getpTask();
		}		
		return (new TaskServiceUtility()).buildTaskListUI(taskRepository.searchTask(sDate, eDate, fPriority, tPriority, task, pTask));
	}
}