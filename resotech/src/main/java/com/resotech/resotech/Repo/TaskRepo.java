package com.resotech.resotech.Repo;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.resotech.resotech.Model.Task;

@Repository
public interface TaskRepo extends JpaRepository<Task, Long> {

    

}

