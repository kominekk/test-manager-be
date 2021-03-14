package com.mycompany.hexagonal.rest.api.model.response;

import lombok.*;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class TestResponse {
    private Integer id;
    private String name;
    private String description;
    private String executionStatus;
}
