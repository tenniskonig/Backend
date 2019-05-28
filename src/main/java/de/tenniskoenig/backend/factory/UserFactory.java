package de.tenniskoenig.backend.factory;

import de.tenniskoenig.backend.domain.User;

public class UserFactory {
    private static User user;

    public static void createNewObject(){
        user = new User();
    }

    public static void setFirstName(String name){
        user.setFirstName(name);
    }
    public static void setLastName(String name){
        user.setLastName(name);
    }
    public static void setPassword(String password){
        user.setPassword(password);
    }
    public static void setGeschlecht(boolean weiblich){
        user.setGeschlechtw(weiblich);
    }

    public static void setUsername(String name){
        user.setUsername(name);
    }
    public static User getObject(){return user;};
}
