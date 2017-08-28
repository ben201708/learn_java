package com.company.design_mode;

public class DBQuery extends IDBQuery {
    public DBQuery() {
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String request(){
        return  "request";
    }
}
