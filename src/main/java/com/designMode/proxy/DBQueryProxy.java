package com.designMode.proxy;

public class DBQueryProxy extends IDBQuery {

    private DBQuery real = null;

    @Override
    public String request(){
        if(real == null){
            real = new DBQuery();
        }
        return  real.request();
    }
}
