package com.project.category;

import com.project.subcategory.Subcategory;
import com.project.security.User;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @NotNull
    @Size(min = 1)
    @Column(unique = true)
    private String name;

    @ManyToOne
    private User user;

    @OneToMany(mappedBy = "category", fetch = FetchType.LAZY)
    private List<Subcategory> relatedSubcategories;

    public Category(String name) {
        this.name = name;
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

    public User getUser() { return user; }

    public void setUser(User user) { this.user = user;
    }

    public List<Subcategory> getRelatedSubcategories() {
        return relatedSubcategories;
    }

    public void setRelatedSubcategories(List<Subcategory> relatedSubcategories) {
        this.relatedSubcategories = relatedSubcategories;
    }

    @Override
    public String toString() {
        return "Category{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", user=" + user +
                ", relatedSubcategories=" + relatedSubcategories +
                '}';
    }
}
