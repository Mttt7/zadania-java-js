package com.mtomaszewski.zadania.repository;

import com.mtomaszewski.zadania.model.Request;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RequestRepository extends JpaRepository<Request,Long> {

}
