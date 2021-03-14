package com.mycompany.hexagonal.rest.api.model.request;


import com.mycompany.hexagonal.model.ExecutionStatus;
import com.mycompany.hexagonal.rest.api.model.common.ValueOfEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class TestChangeStatusRequest {

    @NotNull
    private Integer id;

    @ValueOfEnum(enumClass = ExecutionStatus.class, message = "Wrong execution status")
    private String newStatus;

}
