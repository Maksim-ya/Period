//package com.maksim.service.user;
//
//
//import com.maksim.domain.User;
//import com.maksim.model.impl.DaoFactoryImpl;
//import com.maksim.model.dao.UserDAO;
//
//import java.security.MessageDigest;
//import java.security.NoSuchAlgorithmException;
//
//public class UserService {
//    private static final UserService USER_SERVICE = new UserService();
//    private static final UserDAO DAO = DaoFactoryImpl.getInstance().getUserDao();
//
//    private UserService() {}
//
//    public static UserService getService() {
//        return USER_SERVICE;
//    }
//
//    public boolean login(String login, String password) {
//        password = hashPassword(password);
//        User user = DAO.findByUserName(login);
//        return user != null && user.getPassword().equals(password);
//    }
//
//
//    public boolean register(String login, String password, String email) {
//        password = hashPassword(password);
//        User user = new User(passwordSafeInput(login), password, email, UserGroup.USER);
//        return DAO.insert(user);
//    }
//
//
//    String hashPassword(String password) {
//        String hashedPassword = null;
//        try {
//            MessageDigest md = MessageDigest.getInstance("SHA-256");
//            md.update(password.getBytes());
//            byte[] bytes = md.digest();
//            StringBuilder sb = new StringBuilder();
//            for(int i = 0; i < bytes.length; i++) {
//                sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
//            }
//            hashedPassword = sb.toString();
//        } catch (NoSuchAlgorithmException e) {
//            LOGGER.error(e.getMessage());
//        }
//        LOGGER.info(Log.PASSWORD_HASHED);
//        return hashedPassword;
//    }
//    String passwordSafeInput(String password) {
//        return password.replaceAll("<[^>]*>|[\\s]|[^\\w-]", "").toLowerCase();
//    }
//}
