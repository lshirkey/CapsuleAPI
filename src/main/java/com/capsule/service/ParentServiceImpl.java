package com.capsule.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capsule.dao.ParentTaskRepository;
import com.capsule.entity.ParentTask;
import com.capsule.model.ParentTaskUI;

@Service
public class ParentServiceImpl implements ParentService{

	@Autowired
	ParentTaskRepository parentTaskRepository;
	
	@Override
	public List<ParentTaskUI> listParentTask() {
		Iterable<ParentTask> iterable = parentTaskRepository.findAll();
		List<ParentTaskUI> parentTaskUIList = (new ParentTaskServiceUtility()).buildParentTaskListUI(iterable);
		return parentTaskUIList;
	}

}
