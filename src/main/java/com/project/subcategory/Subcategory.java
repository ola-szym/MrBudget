package com.project.subcategory;

import com.project.category.Category;
import com.project.transaction.Transaction;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;
import java.util.Objects;

@Entity
public class Subcategory extends Category {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @NotNull
    @Size(min = 1)
    @Column(unique = true)
    private String name;

    @ManyToOne
    private Category category;

    @OneToMany(mappedBy = "subcategory", fetch = FetchType.LAZY)
    private List<Transaction> relatedTransactions;

    public Subcategory(String name) {
        super(name);
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

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public List<Transaction> getRelatedTransactions() {
        return relatedTransactions;
    }

    public void setRelatedTransactions(List<Transaction> relatedTransactions) {
        this.relatedTransactions = relatedTransactions;
    }

    @Override
    public String toString() {
        return "Subcategory{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", category=" + category +
                ", relatedTransactions=" + relatedTransactions +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Subcategory that = (Subcategory) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }
}
