package com.pragra.firstride.service;

import com.pragra.firstride.entity.UserEntity;
import com.pragra.firstride.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepo userRepo;

    /**
     * saving new user to the userdb
     * @param user
     * @return user saved in db returned with a response entity
     */
    public ResponseEntity<UserEntity> createUser(UserEntity user){
        UserEntity savedUserEntity = userRepo.save(user);
        return ResponseEntity.ok(savedUserEntity);

    }

    /**
     * deleting a user from the userdb
     * @param userId
     * @return user deleted from db returned with a response entity or returned not found message
     */
    public ResponseEntity<UserEntity> deleteUser(Integer userId){
        Optional<UserEntity> userbyId = userRepo.findById(userId);
        if(userbyId.isPresent()) {
            System.out.println("Yes present");
            userRepo.delete(userbyId.get());
            return ResponseEntity.ok(userbyId.get());
        }
        else
            return ResponseEntity.notFound().build();
    }
    /**
     * finding a user by userID
     *
     **/
    public ResponseEntity<UserEntity> findUser(Integer userId){
        Optional<UserEntity> userfoundbyId = userRepo.findById(userId);
        if(userfoundbyId.isPresent())
            return ResponseEntity.ok(userfoundbyId.get());
        return ResponseEntity.notFound().build();
    }
    /**
     * finding all users
     *
     **/
    public ResponseEntity<List<UserEntity>> findAll(){
        List<UserEntity> allUsers = userRepo.findAll();
        return ResponseEntity.ok(allUsers);
    }
    /**
     * updating an existing user
     *
     **/
    public ResponseEntity<UserEntity> update(Integer userId, UserEntity user){
        Optional<UserEntity> userEntity = userRepo.findById(userId);
        if (userEntity.isPresent()){
            UserEntity oldUser=userEntity.get();
            oldUser.setFName(user.getFName());
            oldUser.setLName(user.getLName());
            oldUser.setAddress(user.getAddress());
            oldUser.setDob(user.getDob());
            oldUser.setPassword(user.getPassword());
            oldUser.setUserEmail(user.getUserEmail());
            return ResponseEntity.ok(userRepo.save(oldUser));
            }
        else
            return ResponseEntity.notFound().build();


    }


}
