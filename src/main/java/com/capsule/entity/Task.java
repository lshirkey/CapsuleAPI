package com.capsule.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
@Table(name = "TASK")
public class Task {

	@Id
	//@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "Task_ID", nullable = false)
	private int taskId;
	
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "parent_id_fk", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
	private ParentTask parentTask = null;
	
	@Column(name = "Task", nullable = false)
	private String task = null;
	
	@Column(name = "Start_Date", nullable = false)
	private Date startDate = null;
	
	@Column(name = "End_Date", nullable = false)
	private Date endDate = null;
	
	@Column(name = "Priority", nullable = false)
	private int priority = 0;

	@Column(name = "Task_Status", nullable = false)
	private String taskStatus = "A";
	
	public int getTaskId() {
		return taskId;
	}

	public void setTaskId(int taskId) {
		this.taskId = taskId;
	}

	public ParentTask getParentTask() {
		return parentTask;
	}

	public void setParentTask(ParentTask parentTask) {
		this.parentTask = parentTask;
	}

	public String getTask() {
		return task;
	}

	public void setTask(String task) {
		this.task = task;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
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
		return "Task [taskId=" + taskId + ", parentTask=" + parentTask + ", task=" + task + ", startDate=" + startDate
				+ ", endDate=" + endDate + ", priority=" + priority + ", taskStatus=" + taskStatus + "]";
	}
}
