package com.main.FiscalIQ.model;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * This class represents user detail which store in database, as well as, request body.
 */

public class UserDetail {

    private Integer id;

    private String firstName;

    private String lastName;

    private String email;

    private String phone;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String password;
}
