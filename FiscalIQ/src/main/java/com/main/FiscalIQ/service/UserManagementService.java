package com.main.FiscalIQ.service;

import com.main.FiscalIQ.common.Result;
import com.main.FiscalIQ.model.UserDetail;
import com.main.FiscalIQ.model.UserPassword;
import com.main.FiscalIQ.repository.FinanceRepository;
import com.main.FiscalIQ.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * This class is for handling user.
 */
@Service
public class UserManagementService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private FinanceRepository financeRepository;

    /**
     * This method is to handle add new user logic.
     *
     * @param userDetail userDetail to be added.
     * @throws DuplicatedDataException  when user has already exists in database.
     * @throws DatabaseException        when save to database fails.
     * @throws IllegalArgumentException when value in attributes are illegal (email attribute not contains '@').
     * @throws NullException            when password is null or empty.
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
        return userRepository.findAll();
    }

    /**
     * Check whether the given userId and password is matched with the information in database or not.
     *
     * @param userPassword UserPassword object containing userId and password.
     * @return true if given userId and password is valid, else return false.
     */
    public boolean isUserValid(UserPassword userPassword) {
        return true;
    }

    /**
     * Get user detail from database.
     *
     * @param userId UserId
     * @return UserDetail if there exists in database, else return null.
     */
    public UserDetail getUser(Integer userId) {
        Optional<UserDetail> optionalUserDetail = userRepository.findById(userId);
        return optionalUserDetail.orElse(null);
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
