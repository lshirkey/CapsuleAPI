package com.capsule.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.capsule.entity.ParentTask;
import com.capsule.model.ParentTaskUI;

public class ParentTaskServiceUtility {

	public ParentTask buildParentTask(int parentId, String parentTaskName) {
		ParentTask parentTask = new ParentTask();
		parentTask.setParentId(String.valueOf(parentId));
		parentTask.setParentTask(parentTaskName);
		return parentTask;
	}
	
	public ParentTaskUI buildParentTaskUI(ParentTask parentTask) {
		ParentTaskUI parentTaskUI = new ParentTaskUI();
		parentTaskUI.setParentId(Integer.valueOf(parentTask.getParentId()));
		parentTaskUI.setParentTask(parentTask.getParentTask());
		return parentTaskUI;
	}
	
//	public List<ParentTaskUI> buildParentTaskListUI(List<ParentTask> list) {
//		List<ParentTaskUI> parentTaskUIList = new ArrayList<ParentTaskUI>();
//		for (ParentTask t : list) {
//			parentTaskUIList.add(buildParentTaskUI(t));
//		}
//		return parentTaskUIList;
//	}
	
	public List<ParentTaskUI> buildParentTaskListUI(Iterable<ParentTask> iterable) {
		Iterator<ParentTask> iterator = iterable.iterator();
		
		List<ParentTaskUI> parentTaskUIList = new ArrayList<ParentTaskUI>();
		while (iterator.hasNext()) {
			ParentTask task = iterator.next();
			parentTaskUIList.add(buildParentTaskUI(task));
		}
		
		return parentTaskUIList;
	}
}
