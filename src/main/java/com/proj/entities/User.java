package com.proj.entities;

import com.google.common.base.Objects;
import org.springframework.data.annotation.Id;

import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * User: dima
 * Date: 21.01.13
 * Time: 15:21
 * To change this template use File | Settings | File Templates.
 */
public class User {

    @Id
    private String id;
    private String login;
    private String name;
    private String password;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;

        User user = (User) o;
        return  Objects.equal(name, user.getName()) &&
                Objects.equal(login, user.getLogin()) &&
                Objects.equal(password, user.getPassword());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(name, login, password);
    }
}
