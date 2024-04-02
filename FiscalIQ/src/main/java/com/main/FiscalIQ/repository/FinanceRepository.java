package com.main.FiscalIQ.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.main.FiscalIQ.model.FinanceDetail;
/**
 * This class represents database operation related to project detail table.
 */
@Repository
public interface FinanceRepository extends JpaRepository<FinanceDetail, Integer> {

}
