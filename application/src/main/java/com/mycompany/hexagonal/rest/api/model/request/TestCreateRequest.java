package com.mycompany.hexagonal.rest.api.model.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class TestCreateRequest {

    @NotEmpty
    @Size(max = 50)
    private String name;
    @NotEmpty
    @Size(max = 100)
    private String description;
}
