package com.thread2;

/**
 * 数据源
 *
 * @User: benhuang
 * @Date: 2017/9/24
 * @Time: 13:35
 */
public class Data {

    int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Data{" +
                "id=" + id +
                '}';
    }
}
