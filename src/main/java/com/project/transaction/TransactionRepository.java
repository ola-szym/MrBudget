package com.project.transaction;

import com.project.budget.Budget;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction,Integer> {

    List<Transaction> findAllByBudget(Budget budget);
}
