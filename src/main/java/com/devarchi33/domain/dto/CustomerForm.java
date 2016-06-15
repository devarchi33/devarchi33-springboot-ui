package com.devarchi33.domain.dto;

import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Created by donghoon on 2016. 6. 15..
 */
@Data
public class CustomerForm {

    @NotNull
    @Size(min = 1, max = 127)
    private String firstName;
    @NotNull
    @Size(min = 1, max = 127)
    private String lastName;


}
