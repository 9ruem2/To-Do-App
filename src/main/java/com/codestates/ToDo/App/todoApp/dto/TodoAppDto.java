package com.codestates.ToDo.App.todoApp.dto;

import lombok.Getter;
import lombok.Setter;

public class TodoAppDto {

    @Setter
    @Getter
    public static class Post{
        private String title;
        private Integer order;
        private Boolean completed;
    }

    @Setter
    @Getter
    public static class Patch{
        private String title;
        private Integer order;
        private Boolean completed;
    }

    @Getter
    @Setter
    public static class Response{
        private Long todoId;
        private String title;
        private Integer order;
        private Boolean completed;
    }
}
