package com.product.project.entities;

/**
 * Created by nonal on 17.10.2017.
 */
public enum UserRoleTypeEntity {
    USER("USER"),
    ADMIN("ADMIN");

    private String UserRoleType;

    UserRoleTypeEntity(String userRoleType) {
        UserRoleType = userRoleType;
    }

    public String getUserRoleType() {
        return UserRoleType;
    }
}
