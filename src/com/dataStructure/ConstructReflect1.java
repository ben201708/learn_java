package com.dataStructure;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * @User: benhuang
 * @Date: 2017/9/14
 * @Time: 17:05
 */
public class ConstructReflect1 {


    public ConstructReflect1(Integer aa) {

        System.out.println("111");
    }

    public ConstructReflect1(String aa) {

        System.out.println("111aaa");
    }

    public Integer get(Integer aaa) {
        System.out.println("1111aaa" + aaa);
        return aaa;
    }

}
