package com.project.transaction;

import com.project.budget.Budget;
import com.project.subcategory.Subcategory;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.Objects;

@Entity
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @NotNull
    @NotBlank
    @Column(unique = true)
    private String name;

    @NotNull
    @NotBlank
    private double amount;

    @DateTimeFormat(pattern = "dd.MM.yyyy")
    private LocalDate date;

    @ManyToOne
    private Budget budget;

    @ManyToOne
    private Subcategory subcategory;


    public Transaction(String name, double amount, LocalDate date, Budget budget, Subcategory subcategory) {
        this.name = name;
        this.amount = amount;
        this.date = date;
        this.budget = budget;
        this.subcategory = subcategory;
    }

    public Transaction(){
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Budget getBudget() {
        return budget;
    }

    public void setBudget(Budget budget) {
        this.budget = budget;
    }

    public Subcategory getSubcategory() {
        return subcategory;
    }

    public void setSubcategory(Subcategory subcategory) {
        this.subcategory = subcategory;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", amount=" + amount +
                ", date=" + date +
                ", budget=" + budget +
                ", subcategory=" + subcategory +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Transaction that = (Transaction) o;
        return Double.compare(that.amount, amount) == 0 &&
                Objects.equals(id, that.id) &&
                Objects.equals(name, that.name) &&
                Objects.equals(date, that.date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, amount, date);
    }
}
