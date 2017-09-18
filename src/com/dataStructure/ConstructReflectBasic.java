package com.dataStructure;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * @User: benhuang
 * @Date: 2017/9/14
 * @Time: 17:05
 */
public class ConstructReflectBasic {

    public static void main(String[] args) {

        int a = 1;

        new ConstructReflectBasic().getClass(ConstructReflect1.class, 1).get(111111);
        new ConstructReflectBasic().getClass(ConstructReflect2.class, 2).get(333333);
        new ConstructReflectBasic().getClass(ConstructReflect2.class, "222").get(222222);

    }

    public <T> T getClass(Class<T> cs, Object... args) {

        try {

            Constructor constructor = cs.getConstructor(args[0].getClass());
            return (T) constructor.newInstance(args);

        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

        return null;
    }
}
