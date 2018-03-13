package com.serialize;

import java.util.ArrayList;
import java.util.HashMap;

public class ProtoStuff {

    private ArrayList<HashMap<String,Integer>> list = new ArrayList<HashMap<String,Integer>>();


    public ArrayList<HashMap<String, Integer>> getList() {
        return list;
    }

    public void setList(ArrayList<HashMap<String, Integer>> list) {
        this.list = list;
    }
}
