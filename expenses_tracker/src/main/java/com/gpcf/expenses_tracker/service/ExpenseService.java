package com.gpcf.expenses_tracker.service;

import com.gpcf.expenses_tracker.entity.Expense;
import com.gpcf.expenses_tracker.exception.ResourceNotFoundException;
import com.gpcf.expenses_tracker.repository.ExpenseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
        return repo.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("Expense not found with id: " + id));
    }

    public Expense updateExpense(Long id, Expense expense) {

        Expense existing = repo.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("Expense not found with id: " + id));

        existing.setName(expense.getName());
        existing.setAmount(expense.getAmount());
        existing.setDate(expense.getDate());
        existing.setDescription(expense.getDescription());

        return repo.save(existing);
    }

    public void deleteExpense(Long id) {
        repo.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("Expense not found with id: " + id));
        repo.deleteById(id);
    }
}