package com.main.FiscalIQ.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * This class represents request body when logging in.
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserPassword {

    @NotNull(message = "userId can not be empty")
    private Integer userId;

    @NotBlank(message = "password can not be empty")
    private String password;

}
