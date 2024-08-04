package com.taskmanage.tasks.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import com.taskmanage.tasks.model.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
