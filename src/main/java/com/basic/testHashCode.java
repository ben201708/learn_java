package com.basic;

import java.util.*;

public class testHashCode {

    public static void main(String[] args) {

        Map u = new HashMap();
        u.put("uid",1);
        u.put("scene","tab_leka");
        u.put("act_id","qixi20170828");

        Map u2 = new HashMap();
        u2.put("uid",2);
        u2.put("scene","tab_lek23");
        u2.put("act_id","q2354i20173421358");

        u.putAll(u2);
        System.out.println(u);


        String targe = null;

        if(targe == null){
            System.out.println("asfdasdf");
        }

        testHashCode testHashCode = new testHashCode();
        testHashCode.getPerson();

        /*
        Map<String, String> map = new HashMap<String, String>();

        System.out.println(map.size());

        map.put("aaa", "aaa");
        map.put("aaa", "aaa");
        map.put("bbb", "bbb2");
        map.put("ccc", "qwew");

        Iterator<Map.Entry<String, String>> entry = map.entrySet().iterator();

        while (entry.hasNext()) {
            Map.Entry<String, String> e = entry.next();
            e.getValue();
            e.getKey();

            System.out.println(e.hashCode());
        }

        System.out.println(map.hashCode());

        Set<String> asc = map.keySet();
        System.out.println(map.entrySet());
        System.out.println(asc);

        */


    }

    private void getPerson() {

        List<Person> list = new ArrayList<Person>();

        Person person = new Person();
        person.setAge(11);
        person.setName("你好为");

        list.add(person);

        person.setAge(11);
        person.setName("我好阿发");

        list.add(person);

        System.out.println(list);
    }

    public class Person {

        private String name;
        private Integer age;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        @Override
        public int hashCode() {
            Integer y = this.age;
            String name = this.name;
            return y + name.hashCode();
        }

        @Override
        public boolean equals(Object o) {
            return super.equals(o);
        }

        @Override
        public String toString() {
            return this.name + "____" + this.age;
        }
    }
}
