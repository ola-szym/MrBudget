package com.project.security;

import com.project.budget.Budget;
import com.project.category.Category;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @NotNull
    @NotBlank
    @Size(min = 3)
    private String userName;

//    @NotNull
//    @NotBlank
//    @Size(min = 3)
//    @Column(unique = true)
//    @Email
//    private String email;
//
//    @NotNull
//    @NotBlank
//    @Size(min = 3)
//    @Column(unique = true)
//    private String login;

    @NotNull
    @NotBlank
    @Size(min = 3)
    private String password;

    @Transient
    private String passwordConfirm;

    @ManyToMany
    private Set<Role> roles;


    @OneToOne
    private Budget selectedBudget;

    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Category> relatedCategories;

    /**
     * Hibernate (JPA) needs it.
     */
    @SuppressWarnings("unused")
    User(){
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPasswordConfirm() {
        return passwordConfirm;
    }

    public void setPasswordConfirm(String passwordConfirm) {
        this.passwordConfirm = passwordConfirm;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    public Budget getSelectedBudget() {
        return selectedBudget;
    }

    public void setSelectedBudget(Budget selectedBudget) {
        this.selectedBudget = selectedBudget;
    }

    public List<Category> getRelatedCategories() {
        return relatedCategories;
    }

    public void setRelatedCategories(List<Category> relatedCategories) {
        this.relatedCategories = relatedCategories;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", selectedBudget=" + selectedBudget +
                '}';
    }
}
