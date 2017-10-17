package com.gc;

/**
 * OldGC垃圾回收
 *
 * @User: benhuang
 * @Date: 2017/10/10
 * @Time: 12:08
 */
public class OldGcMain {

    public static void main(String[] args) {

        String str1 = new OldGcMain().getStr(1);
        String str2 = new OldGcMain().getStr(2);
        String str3 = new OldGcMain().getStr(3);

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
        for (int i = 0; i <= 10000; i++) {
            str = str + String.valueOf(i);
        }
        return str;
    }

}
