package com.codestates.ToDo.App.todoApp.service;

import com.codestates.ToDo.App.todoApp.entity.TodoApp;
import com.codestates.ToDo.App.todoApp.repository.TodoAppRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TodoAppService {
    private final TodoAppRepository todoAppRepository;

    public TodoApp createTodo(TodoApp todoApp) {
        return todoAppRepository.save(todoApp);
    }


    public TodoApp updateTodo(TodoApp todoApp) {
        TodoApp findTodo = todoAppRepository.findById(todoApp.getTodoId()).get();
        Optional.ofNullable(todoApp.getTitle()).ifPresent(findTodo::setTitle);
        Optional.ofNullable(todoApp.getTodoOrder()).ifPresent(findTodo::setTodoOrder);
        Optional.ofNullable(todoApp.getCompleted()).ifPresent(findTodo::setCompleted);
        return todoAppRepository.save(findTodo);
    }

    public void deleteTodo(Long todoId){
        todoAppRepository.deleteById(todoId);
    }

    public List<TodoApp> getAllTodo() {
        List<TodoApp> findTodoList = todoAppRepository.findAll();
        return findTodoList;
    }

    public TodoApp getTodo(Long todoId) {
        Optional<TodoApp> optionalTodoApp = todoAppRepository.findById(todoId);
        if(optionalTodoApp.isPresent()){
            return optionalTodoApp.get();
        }else {
            return null;
        }
    }
}
