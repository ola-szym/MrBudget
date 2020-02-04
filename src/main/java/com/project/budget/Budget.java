package com.project.budget;

import com.project.transaction.Transaction;
import org.springframework.format.annotation.NumberFormat;

import com.sun.istack.NotNull;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.List;
import java.util.Objects;

@Entity
public class Budget {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @NotNull
    @Size(min = 1)
    @Column(unique = true)
    private String name;

    @NotBlank
    @NumberFormat(pattern = "#,##0.00")
    private double balance;

    @OneToMany(mappedBy = "budget", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Transaction> relatedTransactions;

    public Budget(String name, double balance) {
        this.name = name;
        this.balance = balance;
    }

    public Budget(){
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

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public List<Transaction> getRelatedTransactions() {
        return relatedTransactions;
    }

    public void setRelatedTransactions(List<Transaction> relatedTransactions) {
        this.relatedTransactions = relatedTransactions;
    }

    @Override
    public String toString() {
        return "Budget{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", balance=" + balance +
                ", relatedTransactions=" + relatedTransactions +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Budget budget = (Budget) o;
        return  Objects.equals(id, budget.id) &&
                Objects.equals(name, budget.name);

    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, balance);
    }
}
