package com.project.budget;

import com.project.budget.Budget;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BudgetRepository extends JpaRepository<Budget,Integer> {

    Budget findByName(String name);
}
