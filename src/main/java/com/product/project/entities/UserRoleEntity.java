package com.product.project.entities;

import javax.persistence.*;

/**
 * Created by nonal on 17.10.2017.
 */
@Entity
@Table(name = "roles")
public class UserRoleEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "ROLE_TYPE", length = 15, nullable = false, unique = true)
    private String roleType = UserRoleTypeEntity.USER.getUserRoleType();

    @Override
    public String toString() {
        return "UserRoleEntity{" +
                "id=" + id +
                ", roleType='" + roleType + '\'' +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRoleType() {
        return roleType;
    }

    public void setRoleType(String roleType) {
        this.roleType = roleType;
    }
}
