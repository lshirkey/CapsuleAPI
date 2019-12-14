package com.capsule.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.capsule.entity.ParentTask;

@Repository
public interface ParentTaskRepository extends CrudRepository<ParentTask, String> {
	
	@Query("select p from ParentTask p where p.parentId = :parentId")
	Optional<ParentTask> findUserByUserAndEmail(@Param("parentId") String parentId);
}
