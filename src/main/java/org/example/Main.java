package org.example;

import org.example.entity.Users;
import org.example.repository.UserRepository;

import java.sql.SQLException;
import java.util.Date;

public class Main {

    public static void main(String[] args) {

        Users [] user = new Users[3];

//        user[0] = new Users("Javad", "SoltaneGhamHa", new Date());
//        user[1] = new Users("AminBazgir", "1234", new Date());
//        user[2] = new Users("M.Dorali", "shfgjksahjkghdagf436", new Date());



//        UserRepository userRepository = new UserRepository();
//        try {
//            userRepository.saveAll(user);
//
////            userRepository.useDelete(1);
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }

                UserRepository userRepository = new UserRepository();
        try {
            System.out.println(userRepository.loadAll());


//            userRepository.useDelete(1);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }



    }

}

