package com.product.project.entities;


import javax.persistence.*;
import java.util.Set;

/**
 * Created by nonal on 17.10.2017.
 */
@Entity
@Table(name = "users")
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "PASSWORD")
    private String password;
    @Column(name = "EMAIL")
    private String email;
    //    @Transient
    @Column(name = "ADMIN", columnDefinition = "BOOLEAN")
    private boolean isAdmin;
    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.REFRESH)
    @JoinTable(name = "user_roles",
            joinColumns = @JoinColumn(name = "USER_ID"),
            inverseJoinColumns = @JoinColumn(name = "ROLE_ID"))
    private Set<UserRoleEntity> userRoleEntities;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isAdmin() {
        return isAdmin;
    }

    public void setAdmin(boolean admin) {
        isAdmin = admin;
    }

    public Set<UserRoleEntity> getUserRoleEntities() {
        return userRoleEntities;
    }

    public void setUserRoleEntities(Set<UserRoleEntity> userRoleEntities) {
        this.userRoleEntities = userRoleEntities;
    }

    @Override
    public String toString() {
        return "UserEntity{" +
                "id=" + id +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", isAdmin=" + isAdmin +
                ", userRoleEntities=" + userRoleEntities +
                '}';
    }
}