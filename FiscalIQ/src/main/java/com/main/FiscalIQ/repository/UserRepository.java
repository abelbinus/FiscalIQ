package com.main.FiscalIQ.repository;

import com.main.FiscalIQ.model.UserDetail;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * This class represents database operation related to user table.
 */
@Repository
public interface UserRepository extends JpaRepository<UserDetail, Integer> {

}
