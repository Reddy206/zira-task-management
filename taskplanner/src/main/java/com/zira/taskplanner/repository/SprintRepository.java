package com.zira.taskplanner.repository;

import com.zira.taskplanner.model.Sprint;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SprintRepository extends MongoRepository<Sprint,String> {

}
