package com.codestates.ToDo.App.todoApp.entity;

import com.codestates.ToDo.App.audit.Auditable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class TodoApp extends Auditable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long todoId;

    @Column(nullable = false)
    private String title;

    @Column(unique = true)
    private Integer todoOrder; //todo리스트 우선순위

    @Column
    private Boolean completed;
}
