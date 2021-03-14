package com.mycompany.hexagonal.model;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class Test {

    private Integer id;
    private String name;
    private String description;
    private ExecutionStatus executionStatus;


}
