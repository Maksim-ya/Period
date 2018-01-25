package com.maksim.service.user;


import com.maksim.domain.User;
import com.maksim.model.impl.UserDaoImpl;

public class RegistrationService {
    public boolean addUser(User user) {

        UserDaoImpl dao = new UserDaoImpl();

        // Validation Should go here....

         return dao.addUser(user);

    }
}
