package com.codestates.ToDo.App.todoApp.controller;

import com.codestates.ToDo.App.todoApp.dto.TodoAppDto;
import com.codestates.ToDo.App.todoApp.entity.TodoApp;
import com.codestates.ToDo.App.todoApp.mapper.TodoAppMapper;
import com.codestates.ToDo.App.todoApp.service.TodoAppService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Positive;
import java.util.List;

@CrossOrigin
@RestController
@Slf4j
@Validated
@RequiredArgsConstructor
@RequestMapping
public class TodoAppController {
    private final TodoAppMapper mapper;
    private final TodoAppService todoAppService;

    //Create
    //할 일 목록을 등록할 수 있어야 합니다.
    @PostMapping
    public ResponseEntity postTodo(@Valid @RequestBody TodoAppDto.Post PostDto){
        TodoApp todoApp = todoAppService.createTodo(mapper.todoAppPostDtoToTodoApp(PostDto));
        return new ResponseEntity(mapper.todoAppToResponseDto(todoApp), HttpStatus.CREATED);
    }

    @PatchMapping("/{todo-id}")
    public ResponseEntity patchTodo(@PathVariable("todo-id") @Positive Long todoId,
                                    @Valid @RequestBody TodoAppDto.Patch patchDto){
        patchDto.setTodoId(todoId);
        TodoApp todoApp = todoAppService.updateTodo(mapper.todoAppPatchDtoTodoApp(patchDto));
        return new ResponseEntity(mapper.todoAppToResponseDto(todoApp), HttpStatus.OK);
    }

    @DeleteMapping("/{todo-id}")
    public void deleteTodo(@PathVariable("todo-id") @Positive Long todoId){
        todoAppService.deleteTodo(todoId);
    }

    @GetMapping
    public ResponseEntity getAll(){
        List<TodoApp> findTodoList = todoAppService.getAllTodo();
        return new ResponseEntity(findTodoList, HttpStatus.OK);
    }

    @GetMapping("/{todo-id}")
    public ResponseEntity getTodo(@PathVariable("todo-id") @Positive Long todoId){
        TodoApp findTodo = todoAppService.getTodo(todoId);
        return new ResponseEntity(findTodo,HttpStatus.OK);
    }



}
