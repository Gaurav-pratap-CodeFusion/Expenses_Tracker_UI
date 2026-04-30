package com.gpcf.expenses_tracker.controller;

import com.gpcf.expenses_tracker.entity.Expense;
import com.gpcf.expenses_tracker.service.ExpenseService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/expenses")
@CrossOrigin(origins = "*")
public class ExpenseController {

    @Autowired
    private ExpenseService service;

    @PostMapping
    public ResponseEntity<Expense> addExpense(
            @RequestBody Expense expense)
    {
        Expense savedExpense =
                service.saveExpense(expense);

        return ResponseEntity.ok(savedExpense);
    }

    @GetMapping
    public ResponseEntity<List<Expense>> getExpenses()
    {
        List<Expense> expenses = service.getAllExpenses();
        return ResponseEntity.ok(expenses);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Expense> getExpenseById(
            @PathVariable Long id)
    {
        Expense expense = service.getExpensesById(id);

        return ResponseEntity.ok(expense);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Expense> updateExpense(
            @PathVariable Long id,
            @RequestBody Expense expense)
    {
        Expense updatedExpense = service.updateExpense(id, expense);

        return ResponseEntity.ok(updatedExpense);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteExpense(
            @PathVariable Long id)
    {
        service.deleteExpense(id);

        return ResponseEntity.ok("Expense deleted successfully");
    }
}