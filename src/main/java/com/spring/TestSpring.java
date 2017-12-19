package com.spring;

import com.alibaba.fastjson.JSON;
import org.junit.Test;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @User: benhuang
 * @Date: 2017/11/22
 * @Time: 21:19
 */
public class TestSpring {

    @Test
    public void testUser() {

        String a = "fsdf";
        String b = "sdfsdf";
        a.equals(b);

        User user = new User();

        UserBean userBean = new UserBean();
        userBean.setSchool("深圳大学");
        userBean.setGrade("二班");

        user.setUserBean(userBean);
        user.setAge(123);
        user.setName("23423");

        System.out.println(JSON.toJSONString(user));
        try {
            User user2 = (User) user.clone();
            user2.setName("hunaho");

            userBean.setSchool("中山大学");
            userBean.setGrade("一班");
            user2.setUserBean(userBean);

            System.out.println(JSON.toJSONString(user2));
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        System.out.println(JSON.toJSONString(user));

        ApplicationContext ac = null;

        /*
        try {
            ac = new ClassPathXmlApplicationContext("bean1.xml");
            User user = (User) ac.getBean("user");
            System.out.println(user);
        } catch (BeansException e) {
            e.printStackTrace();
        }
        */


    }

}
