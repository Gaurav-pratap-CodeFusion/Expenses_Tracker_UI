package com.gpcf.expenses_tracker.repository;


import com.gpcf.expenses_tracker.entity.Expense;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExpenseRepository extends JpaRepository<Expense, Long> {
}
