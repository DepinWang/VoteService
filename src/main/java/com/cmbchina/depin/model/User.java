package com.cmbchina.depin.model;

/**
 * Created by wdphu on 2017/7/14.
 */
public class User {
    private int id;
    private String password;
    private String name;
    private String nickname;

    public User(){this.id = -1;}

    public User(int id, String password, String name, String nickname) {
        this.id = id;
        this.password = password;
        this.name = name;
        this.nickname = nickname;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String toString(){
        return id+password+name+nickname;
    }
}
