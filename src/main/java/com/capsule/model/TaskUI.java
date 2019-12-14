package com.capsule.model;

public class TaskUI {

	private int taskId;
	private String task = null;
	private int parentId;
	private String parentTask = null;
	private String startDate = null;
	private String endDate = null;
	private int priority = 0;
	private String taskStatus=null;

	public int getTaskId() {
		return taskId;
	}
	public void setTaskId(int taskId) {
		this.taskId = taskId;
	}
	public String getTask() {
		return task;
	}
	public void setTask(String task) {
		this.task = task;
	}
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
	public String getStartDate() {
		return startDate;
	}
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}
	public String getEndDate() {
		return endDate;
	}
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}
	public int getPriority() {
		return priority;
	}
	public void setPriority(int priority) {
		this.priority = priority;
	}
	public String getTaskStatus() {
		return taskStatus;
	}
	public void setTaskStatus(String taskStatus) {
		this.taskStatus = taskStatus;
	}

	@Override
	public String toString() {
		return "TaskUI [taskId=" + taskId + ", task=" + task + ", parentId=" + parentId + ", parentTask=" + parentTask
				+ ", startDate=" + startDate + ", endDate=" + endDate + ", priority=" + priority + ", taskStatus="
				+ taskStatus + "]";
	}
}
