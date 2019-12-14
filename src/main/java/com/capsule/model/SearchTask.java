package com.capsule.model;

public class SearchTask {

	String sDate;
	String eDate; 
	String fPriority;
	String tPriority;
	String task;
	String pTask;

	public String getsDate() {
		return sDate;
	}
	public void setsDate(String sDate) {
		this.sDate = sDate;
	}
	public String geteDate() {
		return eDate;
	}
	public void seteDate(String eDate) {
		this.eDate = eDate;
	}
	public String getfPriority() {
		return fPriority;
	}
	public void setfPriority(String fPriority) {
		this.fPriority = fPriority;
	}
	public String gettPriority() {
		return tPriority;
	}
	public void settPriority(String tPriority) {
		this.tPriority = tPriority;
	}
	public String getTask() {
		return task;
	}
	public void setTask(String task) {
		this.task = task;
	}
	public String getpTask() {
		return pTask;
	}
	public void setpTask(String pTask) {
		this.pTask = pTask;
	}
	@Override
	public String toString() {
		return "SearchTask [sDate=" + sDate + ", eDate=" + eDate + ", fPriority=" + fPriority + ", tPriority="
				+ tPriority + ", task=" + task + ", pTask=" + pTask + "]";
	}
}
