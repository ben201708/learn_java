package com.dataStructure;

import java.io.*;

/**
 * @User: benhuang
 * @Date: 2017/9/8
 * @Time: 11:43
 */
public class ReflectPoint {

    private int x;
    private int y;
    public String str1 = "";
    public String str2 = "";
    public String str3 = "";

    public ReflectPoint(int x, int y) {
        super();
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ReflectPoint that = (ReflectPoint) o;

        if (x != that.x) return false;
        return y == that.y;
    }

    @Override
    public int hashCode() {
        int result = x;
        result = 31 * result + y;
        return result;
    }
}
