package com.main.FiscalIQ.model;


import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * This class represents user detail which store in database, as well as, request body.
 */
@Getter
@Setter
@Entity
@Table(name="user_detail")
@NoArgsConstructor
@AllArgsConstructor
public class UserDetail {

    @Id
    @Column(name = "id")
    @NotNull
    @Positive(message = " (Id must be positive value)")
    private Integer id;

    @Column(name = "name")
    @NotBlank
    private String firstName;

    @Column(name = "name")
    @NotBlank
    private String lastName;

    @Column(name = "email")
    @NotBlank
    private String email;

    @Column(name = "phone")
    @NotBlank
    private String phone;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @Column(name = "password")
    private String password;
}
