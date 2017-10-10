package com.gc;

/**
 * YoungGC垃圾回收
 *
 * @User: benhuang
 * @Date: 2017/10/10
 * @Time: 12:08
 */
public class YoungGcMain {

    public static void main(String[] args) {

        String str1 = new YoungGcMain().getStr(1);
        String str2 = new YoungGcMain().getStr(2);
        String str3 = new YoungGcMain().getStr(3);

        System.gc();
    }

    private String getStr(Integer type) {
        String str = "";
        switch (type) {
            case 1:
                str = "aaa";
                break;
            case 2:
                str = "bbb";
                break;
            default:
                str = "zzz";
                break;
        }
        for (int i = 0; i <= 1000; i++) {
            str = str + String.valueOf(i);
        }
        return str;
    }

}
