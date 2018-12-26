package com.senon.lib_common.bean;

import java.io.Serializable;
import java.util.List;

/**
 * 登录--实体
 */
public class Login {

    /**
     * chapterTops : []
     * collectIds : [2683,2880,2875,2868,2831,2829,2807]
     * email :
     * icon :
     * id : 1864
     * password :
     * token :
     * type : 0
     * username : senonwx
     */

    public String email;
    public String icon;
    public int id;
    public String password;
    public String token;
    public int type;
    public String username;
    public List<?> chapterTops;
    public List<Integer> collectIds;

    public Login() {
    }

    @Override
    public String toString() {
        return "Login{" +
                "email='" + email + '\'' +
                ", icon='" + icon + '\'' +
                ", id=" + id +
                ", password='" + password + '\'' +
                ", token='" + token + '\'' +
                ", type=" + type +
                ", username='" + username + '\'' +
                ", chapterTops=" + chapterTops +
                ", collectIds=" + collectIds +
                '}';
    }
}
