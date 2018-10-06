package main.java;

import org.hibernate.annotations.Proxy;

import javax.persistence.*;
import javax.transaction.Transactional;


@Entity
@Table(name= "apl")
@Proxy(lazy=false)
public class User {
    @Id

    @Column(name="id")
    private int id;
    @Column(name="name")
    private String name;
    @Column(name="login")
    private String login;
    @Column(name="password")
    private String password;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }
}
