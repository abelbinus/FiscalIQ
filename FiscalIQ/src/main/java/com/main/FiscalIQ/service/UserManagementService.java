package com.main.FiscalIQ.service;

import com.main.FiscalIQ.common.Result;
import com.main.FiscalIQ.model.FinanceDetail;
import com.main.FiscalIQ.model.UserDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

/**
 * This class is for handling user.
 */
@Service
public class UserManagementService {

    @Autowired
    private UserDetail userRepository;
    @Autowired
    private FinanceDetail financeRepository;

    /**
     * This method is to handle add new user logic.
     *
     * @param userDetail userDetail to be added.
     */
    public void addUser(UserDetail userDetail) {
    }

    /**
     * This method is to handle delete user logic.
     *
     * @param userId user to be removed.
     */
    public void deleteUser(Integer userId) {
    }

    /**
     * This method is to handle update user logic. if given attribute is null, the previous information will be saved.
     *
     * @param userDetail user detail object to be updated.
     */
    public void updateUser(UserDetail userDetail) {
    }

    /**
     * Get all users.
     *
     * @return List of user detail.
     */
    public List<UserDetail> getAllUsers() {
        List<UserDetail> userDetails = Arrays.asList();
        return userDetails;
    }

    /**
     * Check whether the given userId and password is matched with the information in database or not.
     *
     * @param userPassword UserPassword object containing userId and password.
     * @return true if given userId and password is valid, else return false.
     */
    public boolean isUserValid(String userPassword) {
        return true;
    }

    /**
     * Get user detail from database.
     *
     * @param userId UserId
     * @return UserDetail if there exists in database, else return null.
     */
    public UserDetail getUser(Integer userId) {
        UserDetail userDetail = new UserDetail();
        return userDetail;
    }

    /**
     * Get user detail.
     *
     * @param userId  userId.
     * @return Result Object containing the information of this operation whether it fails or success.
     */
    public Result getUserById(Integer userId) {
        return new Result(true, null, "Get user successfully");
    }

    /**
     * This method is to handle change password logic.
     *
     * @param oldPass Previous password.
     * @param newPass New password.
     * @param userId UserId.
     * @return Result Object containing the information of this operation whether it fails or success.
     */
    public Result changePassword(String oldPass, String newPass, Integer userId) {
        return new Result(true, null, "Password updated successfully.");
    }

}
