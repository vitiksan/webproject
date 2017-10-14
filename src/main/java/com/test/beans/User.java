package com.test.beans;// Created by on 08.10.2017.

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;

public class User extends Person{
    private String login;
    private String password;
    private UserState state;
    private UserGroup group;
    private LocalDateTime created;
    private LocalDateTime lastAccess;

    public User() {
        super();
        this.login = "no-login";
        this.password = "no-password";
        this.state = UserState.NEW;
        this.group = UserGroup.STUDENT;
        this.created = LocalDateTime.now();
        this.lastAccess = LocalDateTime.now();
    }

    public User(String name, String surname, String login, String password) {
        super(name, surname);
        this.login = login;
        this.password = password;
        this.created = LocalDateTime.now();
        this.lastAccess = LocalDateTime.now();
    }

    public User(String name, String surname, LocalDate birthday,
                String login, String password, UserState state, UserGroup group) {
        super(name, surname, birthday);
        this.login = login;
        this.password = password;
        this.state = state;
        this.group = group;
        this.created = LocalDateTime.now();
        this.lastAccess = LocalDateTime.now();
    }

    public User(String name, String surname, LocalDate birthday,
                String login, String password, UserState state, UserGroup group,
                LocalDateTime created, LocalDateTime lastAccess) {
        super(name, surname, birthday);
        this.login = login;
        this.password = password;
        this.state = state;
        this.group = group;
        this.created = created;
        this.lastAccess = lastAccess;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public UserState getState() {
        return state;
    }

    public void setState(UserState state) {
        this.state = state;
    }

    public UserGroup getGroup() {
        return group;
    }

    public void setGroup(UserGroup group) {
        this.group = group;
    }

    public LocalDateTime getCreated() {
        return created;
    }

    public void setCreated(LocalDateTime created) {
        this.created = created;
    }

    public LocalDateTime getLastAccess() {
        return lastAccess;
    }

    public void setLastAccess(LocalDateTime lastAccess) {
        this.lastAccess = lastAccess;
    }

    @Override
    public String toString() {
        return "User{" +
                "login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", state=" + state +
                ", group=" + group +
                ", created=" + created +
                ", lastAccess=" + lastAccess +
                '}';
    }
}
