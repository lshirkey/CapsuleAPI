package com.capsule.dao;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.capsule.entity.Task;

@Repository
public interface TaskRepository extends CrudRepository<Task, Integer> {

//	@Query("SELECT t FROM Task t WHERE (DATE(t.startDate) >= :sDate AND  DATE(t.endDate) <= :eDate) AND (t.priority >= :fPriority AND t.priority <= :tPriority) AND UPPER(t.task) LIKE %:task%")
//	List<Task> searchTask(@Param("sDate") Date sDate, @Param("eDate") Date eDate, @Param("fPriority") int fPriority, @Param("tPriority") int tPriority, @Param("task") String task);
	
//	@Query("SELECT t FROM Task t WHERE (t.priority >= :fPriority AND t.priority <= :tPriority) AND UPPER(t.task) LIKE %:task%")
//	List<Task> searchTask(@Param("fPriority") int fPriority, @Param("tPriority") int tPriority, @Param("task") String task);

//	@Query("SELECT t FROM Task t WHERE (t.priority >= :fPriority AND t.priority <= :tPriority) AND UPPER(t.task) LIKE %:task% AND UPPER(t.parentTask.parentTask) LIKE %:ptask%")
//	List<Task> searchTask(@Param("fPriority") int fPriority, @Param("tPriority") int tPriority, @Param("task") String task, @Param("ptask") String ptask);
	
	@Query("SELECT t FROM Task t WHERE (DATE(t.startDate) >= :sDate AND  DATE(t.endDate) <= :eDate) AND  (t.priority >= :fPriority AND t.priority <= :tPriority) AND UPPER(t.task) LIKE %:task% AND UPPER(t.parentTask.parentTask) LIKE %:ptask%")
	List<Task> searchTask(@Param("sDate") Date sDate, @Param("eDate") Date eDate, @Param("fPriority") int fPriority, @Param("tPriority") int tPriority, @Param("task") String task, @Param("ptask") String ptask);
	
	@Query("SELECT  MAX(endDate) FROM Task")
	Date maxEndDate();
	
	@Query("SELECT  MIN(startDate) FROM Task")
	Date minStartDate();
}
