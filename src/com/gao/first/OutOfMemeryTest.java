package com.gao.first;

import java.util.HashMap;
import java.util.Map;

/**
 * User: wangchen.gpx
 * Date: 13-5-27
 * Time: 下午6:46
 */
public class OutOfMemeryTest {
    static class MyEntry {
        Integer id;

        MyEntry(Integer id) {
            this.id = id;
        }

        @Override
        public int hashCode() {
            return id.hashCode();
        }

        @Override
        public boolean equals(Object obj) {
            boolean result = false;
            if (obj instanceof MyEntry) {
                MyEntry other = (MyEntry) obj;
                result = (other.id.equals(this.id));
            }
            return result;
        }
    }

    public static void main(String[] args) {
        Map<MyEntry, String> map = new HashMap<MyEntry, String>();
        while (true) {
            for (int i = 0; i < 100; i++) {
                if (!map.containsKey(i)) {
                    map.put(new MyEntry(i), "number" + i);
                    System.out.println(i);
                }
            }
        }

    }
}
