package com.codestates.ToDo.App.todoApp.mapper;

import com.codestates.ToDo.App.todoApp.dto.TodoAppDto;
import com.codestates.ToDo.App.todoApp.entity.TodoApp;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel ="spring")
public interface TodoAppMapper {
    @Mapping(source = "order",target = "todoOrder")
    TodoApp todoAppPostDtoToTodoApp(TodoAppDto.Post postDto);

    @Mapping(source = "order",target = "todoOrder")
    TodoApp todoAppPatchDtoTodoApp(TodoAppDto.Patch patchDto);

    @Mapping(source = "todoOrder",target = "order")
    TodoAppDto.Response todoAppToResponseDto(TodoApp todoApp);
}
