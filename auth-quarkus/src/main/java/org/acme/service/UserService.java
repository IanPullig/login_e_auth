package org.acme.service;

import jakarta.enterprise.context.ApplicationScoped;
import org.acme.entity.UserEntity;

@ApplicationScoped
public class UserService {

    public static UserEntity createUser(UserEntity userEntity){
        UserEntity.persist(userEntity);
        return  userEntity;


    }
}
