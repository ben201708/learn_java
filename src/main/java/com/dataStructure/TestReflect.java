package com.dataStructure;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

/**
 * @User: benhuang
 * @Date: 2017/9/13
 * @Time: 16:54
 */
public class TestReflect {

    public static void main(String[] args) {

        String str1 = "abc";
        Class cls1 = str1.getClass();
        Class cls2 = String.class;
        Class cls3 = null;

        try {
            cls3 = Class.forName("java.lang.String");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        System.out.println(cls1 == cls2);
        System.out.println(cls2 == cls3);
        System.out.println(int.class.isPrimitive());
        System.out.println(String.class.isPrimitive());
        System.out.println(int[].class.isArray());

        new TestReflect().testC(1);
        new TestReflect().testC(2);
        new TestReflect().testC(3);
    }

    private void testC(int type) {

        ReflectPoint reflectPoint1 = new ReflectPoint(3, 3);
        ReflectPoint reflectPoint2 = new ReflectPoint(5, 5);
        ReflectPoint reflectPoint3 = new ReflectPoint(3, 3);

        switch (type) {
            case 1:
                List l = new ArrayList();

                l.add(reflectPoint1);
                l.add(reflectPoint2);
                l.add(reflectPoint3);

                System.out.println(l);

                reflectPoint3.setX(5);
                l.remove(reflectPoint3);
                System.out.println(l.size());
                break;

            //内存泄漏
            case 2:
                HashSet s = new HashSet<ReflectPoint>();

                s.add(reflectPoint1);
                s.add(reflectPoint2);
                s.add(reflectPoint3);

                System.out.println(s);

                reflectPoint3.setX(5);
                s.remove(reflectPoint3);
                System.out.println(s.size());
                break;

            //内存泄漏
            case 3:
                HashMap<ReflectPoint, Object> hp = new HashMap<ReflectPoint, Object>();

                hp.put(reflectPoint1,new Object());
                hp.put(reflectPoint2,new Object());
                hp.put(reflectPoint3,new Object());

                System.out.println(hp);

                reflectPoint3.setX(5);
                hp.remove(reflectPoint3);
                System.out.println(hp.size());
                break;
        }


    }
}
