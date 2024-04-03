package com.main.FiscalIQ.controller;

import com.main.FiscalIQ.common.Result;
import com.main.FiscalIQ.config.AuthHandler;
import com.main.FiscalIQ.model.UserDetail;
import com.main.FiscalIQ.service.UserManagementService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * This controller class is for handling user.
 */
@RestController
@RequestMapping("/api/projectshare")
public class UserController {

    @Autowired
    private UserManagementService userManagementService;

    private AuthHandler authHandler;

    /**
     * This API is for adding new user. Only admin role can access this API.
     *
     * @param userDetail UserDetail class includes id, name, email, department, type, and password. All fields must not be null.
     * @param token Authorization token from header.
     * @return ResponseEntity with status Created and body indicating the result of this transaction.
     */
    @PostMapping("/registration")
    public ResponseEntity<Result> addUser(@Valid @RequestBody UserDetail userDetail) {
        String userName = "";
        String password = "";
        userManagementService.addUser(userDetail);
        authHandler.authenticate(userName, password);
        Result result = new Result(true, "", "User added successfully");

        return ResponseEntity.status(HttpStatus.CREATED).body(result);
    }

    /**
     * This API is for deleting user. Only admin role can access this API.
     *
     * @param userId userId to be deleted.
     * @param token Authorization token from header.
     * @return ResponseEntity with status ok and body indicating the result of this transaction.
     */
    @DeleteMapping("/user/{userId}")
    public ResponseEntity<Result> deleteUser(@PathVariable Integer userId) {

        userManagementService.deleteUser(userId);

        Result result = new Result(true, "", "User deleted successfully");

        return ResponseEntity.status(HttpStatus.OK).body(result);
    }

    /**
     * This API is for updating user's information. Only admin role can access this API.
     *
     * @param updatedUserDetail UserDetail class includes id, name, email, department, type, and password. All fields must not be null.
     * @return ResponseEntity with status ok and body indicating the result of this transaction.
     */
    @PutMapping("/user")
    public ResponseEntity<Result> updateUser(@RequestBody UserDetail updatedUserDetail) {

        userManagementService.updateUser(updatedUserDetail);

        Result result = new Result(true, "", "User updated successfully");

        return ResponseEntity.status(HttpStatus.OK).body(result);
    }

    /**
     * This API is for getting all users. Only admin role can access this API.
     *
     * @param token Authorization token from header.
     * @return ResponseEntity with status ok, users' information (if any), and message indicating the result of this transaction.
     */
    @GetMapping("/users")
    public ResponseEntity<Result> getAllUsers() {

        List<UserDetail> userDetails = userManagementService.getAllUsers();

        Result result = new Result(true, userDetails, "Get all users successfully");

        return ResponseEntity.status(HttpStatus.OK).body(result);
    }

    /**
     * This API is for getting user by Id. Only admin role can access this API.
     *
     * @param userId Id to get information.
     * @return ResponseEntity with status ok, staffs' information (if any), and message indicating the result of this transaction.
     * @throws NonExistentIdException when user id not exist.
     */
    @GetMapping("/user/{userId}")
    public ResponseEntity<Result> getUserByUserId(@PathVariable Integer userId) {

        Result result = userManagementService.getUserById(userId);

        return ResponseEntity.status(HttpStatus.OK).body(result);
    }

    /**
     * Updates password for user
     * 
     * @param oldPass Old password of the user
     * @param newPass New password of the user
     * @param userId The user ID of the user
     * @return ResponseEntity<Result> ResponseEntity containing a Result object with the success or failure message.
     */
    @PutMapping("/user/changePassword/{oldPass}/{newPass}/{userId}")
    public ResponseEntity<Result> changePassword(@PathVariable String oldPass, @PathVariable String newPass, @PathVariable Integer userId) {
        // Update password for user
        Result result = userManagementService.changePassword(oldPass, newPass, userId);
        // Return the result in a ResponseEntity with HTTP status OK
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }

}
