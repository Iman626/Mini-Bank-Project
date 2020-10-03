package com.myspring.entities;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "users")
public class Users implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int id;

    @Column(name = "login")
    private String login;

    @Column(name = "password")
    private String password;

    @Column(name = "full_name")
    private String full_name;

    @ManyToOne
    @JoinColumn(name = "role_id")
    Roles role;

    public Users() {
    }

    public Users(String login, String password, String full_name, Roles role) {
        this.login = login;
        this.password = password;
        this.full_name = full_name;
        this.role = role;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getFull_name() {
        return full_name;
    }

    public void setFull_name(String full_name) {
        this.full_name = full_name;
    }

    public Roles getRole_id() {
        return role;
    }

    public void setRole_id(int role_id) {
        this.role = role;
    }
}
