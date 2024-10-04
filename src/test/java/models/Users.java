package models;

import java.util.List;

public class Users {
    private List<User> users;
    private double dataBaseVersion;

    public double getDataBaseVersion() {
        return dataBaseVersion;
    }

    public List<User> getUsers() {
        return users;
    }

    public static class User {
        private Integer id;
        private String name;
        private Integer age;

        public Integer getId() {
            return id;
        }

        public String getName() {
            return name;
        }

        public Integer getAge() {
            return age;
        }
    }
}


