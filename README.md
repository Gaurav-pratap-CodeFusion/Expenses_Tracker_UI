# Expense Tracker Application

This is a simple Expense Tracker web application developed using HTML, CSS, JavaScript (localStorage) and Java Spring Boot REST APIs.

The application allows users to register, login, add expenses, update expenses, view expense list and manage their daily expenses easily.

---

## Features

- User Registration (temporary frontend storage)
- User Login validation using localStorage
- Add Expense
- Update Expense
- View Expense List
- Backend REST APIs using Spring Boot
- MySQL database integration
- Clean navigation between pages

---

## Technologies Used

Frontend:
- HTML
- CSS
- JavaScript (localStorage)

Backend:
- Java
- Spring Boot
- Spring Data JPA
- REST API
- MySQL Database

---

## Project Structure

Frontend Pages:

- login.html
- register.html
- dashboard.html
- add-expense.html
- update-expense.html
- expense-list.html

Backend Modules:

- Controller Layer
- Service Layer
- Repository Layer
- Entity Class

---

## REST API Endpoints

| Method | Endpoint | Description |
|--------|----------|-------------|
| POST | /expenses | Add expense |
| GET | /expenses | Get all expenses |
| PUT | /expenses/{id} | Update expense |
| DELETE | /expenses/{id} | Delete expense |

---

## Database Configuration

Database Name:

expenses_tracker

Table Name:

expense

---
