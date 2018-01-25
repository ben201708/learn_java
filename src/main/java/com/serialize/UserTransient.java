package com.serialize;

import java.io.Serializable;

/**
 * @User: benhuang
 * @Date: 2017/11/24
 * @Time: 16:22
 */
public class UserTransient implements Serializable{

    private String name;
    private transient String pwd;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }
}
