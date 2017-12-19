package com.spring;

import java.io.Serializable;

/**
 * @User: benhuang
 * @Date: 2017/11/22
 * @Time: 21:29
 */
public class User implements Serializable, Cloneable {

    private String name;
    private Integer age;
    private UserBean userBean;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }


    public UserBean getUserBean() {
        return userBean;
    }

    public void setUserBean(UserBean userBean) {
        this.userBean = userBean;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
