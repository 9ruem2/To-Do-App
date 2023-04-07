package com.codestates.ToDo.App.todoApp.repository;

import com.codestates.ToDo.App.todoApp.entity.TodoApp;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TodoAppRepository extends JpaRepository<TodoApp,Long> {
    boolean existsByTodoOrder(Integer todoOrder);
}
