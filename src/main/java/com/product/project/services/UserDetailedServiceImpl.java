package com.product.project.services;

import com.product.project.entities.UserEntity;
import com.product.project.entities.UserRoleEntity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

/**
 * Created by nonal on 17.10.2017.
 */
public class UserDetailedServiceImpl implements UserDetailsService {

    private final UserService userService;

    public UserDetailedServiceImpl(UserService userService) {
        this.userService = userService;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        UserEntity userEntity = userService.getByEmail(email);
        if (userEntity == null) {
            throw new UsernameNotFoundException("UserEntity not exists!!!");
        }

        String[] roles = userEntity.getUserRoleEntities()
                .stream()
                .map(UserRoleEntity::getRoleType)
                .toArray(String[]::new);

        return User.withUsername(userEntity.getEmail())
                .password(userEntity.getPassword())
                .roles(roles)
                .build();
    }
}
