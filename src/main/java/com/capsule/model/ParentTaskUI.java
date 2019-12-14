package com.capsule.model;

public class ParentTaskUI {

	private int parentId;
	private String parentTask = null;

	public int getParentId() {
		return parentId;
	}

	public void setParentId(int parentId) {
		this.parentId = parentId;
	}

	public String getParentTask() {
		return parentTask;
	}

	public void setParentTask(String parentTask) {
		this.parentTask = parentTask;
	}

	@Override
	public String toString() {
		return "ParentTask [parentId=" + parentId + ", parentTask=" + parentTask + "]";
	}
}
