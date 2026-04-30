package com.gpcf.expenses_tracker.service;
import java.util.List;

import com.gpcf.expenses_tracker.entity.Expense;
import com.gpcf.expenses_tracker.repository.ExpenseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ExpenseService {

    @Autowired
    ExpenseRepository repo;

    public Expense saveExpense(Expense expense) {
        return repo.save(expense);
    }

    public List<Expense> getAllExpenses() {
        return repo.findAll();
    }

    public Expense getExpensesById(Long id) {
        return repo.findById(id).orElse(null);
    }

    public Expense updateExpense(Long id, Expense expense) {

        Expense existing = repo.findById(id).get();

        existing.setName(expense.getName());
        existing.setAmount(expense.getAmount());
        existing.setDate(expense.getDate());
        existing.setDescription(expense.getDescription());

        return repo.save(existing);
    }

    public void deleteExpense(Long id) {
        repo.deleteById(id);
    }
}