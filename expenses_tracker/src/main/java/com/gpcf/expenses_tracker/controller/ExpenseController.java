package com.gpcf.expenses_tracker.controller;

import com.gpcf.expenses_tracker.entity.Expense;
import com.gpcf.expenses_tracker.service.ExpenseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/expenses")
public class ExpenseController {

    @Autowired
    ExpenseService service;

    @PostMapping
    public Expense addExpense(@RequestBody Expense expense) {

        return service.saveExpense(expense);
    }

    @GetMapping
    public List<Expense> getExpenses() {

        return service.getAllExpenses();
    }
    @GetMapping("/{id}")
    public Expense getExpenses(@PathVariable  Long id) {

        return service.getExpensesById(id);
    }

    @PutMapping("/{id}")
    public Expense updateExpense(
            @PathVariable Long id,
            @RequestBody Expense expense) {

        return service.updateExpense(id, expense);
    }

    @DeleteMapping("/{id}")
    public void deleteExpense(@PathVariable Long id) {

        service.deleteExpense(id);
    }

}