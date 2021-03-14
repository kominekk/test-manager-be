package com.mycompany.hexagonal.jpa.entity;

import com.mycompany.hexagonal.model.ExecutionStatus;
import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "TESTS")
@Data
public class TestEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Integer id;

    @Column
    private String name;

    @Column
    private String description;

    @Column
    @Enumerated(EnumType.STRING)
    private ExecutionStatus executionStatus;
}