package com.saddy.mapdemo;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

public class DemoMap {
    public static void main(String[] args) {
        // format: ClassName/Interface objName = new ClassName();
//        HashMap<String, String> hashMap = new HashMap<>();
//        LinkedHashMap<String, String> linkedHashMap = new LinkedHashMap<>();
//        TreeMap<String, String> treeMap = new TreeMap<>();
//        demoHashMap();
//        demoNestedHashMap();
//        demoTreeMap();
//        demoLinkedHashMap();
    }

    static void demoLinkedHashMap() {
        LinkedHashMap<String, String> linkedHashMap = new LinkedHashMap<>();
        linkedHashMap.put("name", "Alice");
        linkedHashMap.put("age", "30");
        linkedHashMap.put("city", "New York");
        System.out.println("LinkedHashMap: " + linkedHashMap);

        // Accessing elements
        System.out.println("Name: " + linkedHashMap.get("name"));
        System.out.println("Age: " + linkedHashMap.getOrDefault("age1", "Unknown"));

        // Iterating through the LinkedHashMap
        for (Map.Entry<String, String> entry : linkedHashMap.entrySet()) {
            System.out.println(entry);
            System.out.println("Key: " + entry.getKey() + ", Value: " + entry.getValue());
        }
    }

    static void demoTreeMap() {
        TreeMap<String, String> treeMap = new TreeMap<>();
        treeMap.put("name", "Alice");
        treeMap.put("age", "30");
        treeMap.put("city", "New York");
        System.out.println("TreeMap: " + treeMap);
    }



    static void demoHashMap() {
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("name", "Alice");
        hashMap.put("age", "30");
        hashMap.put("city", "New York");
        System.out.println("HashMap: " + hashMap);

        // Accessing elements
        System.out.println("Name: " + hashMap.get("name"));
        System.out.println("Name: " + hashMap.getOrDefault("name1", "Unknown"));

        hashMap.put("Job", "Software Engineer"); // Updating value
        hashMap.put("age", "31"); // Updating value

        hashMap.putIfAbsent("age", "32"); // This will not update since "age" already exists
        hashMap.putIfAbsent("country", "USA"); // This will add a new key-value pair

        System.out.println("Updated HashMap: " + hashMap);

        // keys and values
        System.out.println("----------------------------------");
        System.out.println("Sizes: " + hashMap.size());
        System.out.println("----------------------------------");
        System.out.println("Keys: " + hashMap.keySet());
        System.out.println("----------------------------------");
        System.out.println("Values: " + hashMap.values());
        System.out.println("----------------------------------");
        System.out.println("Entries: " + hashMap.entrySet());
        System.out.println("----------------------------------");
        // Iterating through the HashMap
        for (Map.Entry<String, String> entry : hashMap.entrySet()) {
            System.out.println(entry);
            System.out.println("Key: " + entry.getKey() + ", Value: " + entry.getValue());
        }
        System.out.println("----------------------------------");
        // Iterating using keySet()
        for (String key : hashMap.keySet()) {
            System.out.println("Key: " + key + ", Value: " + hashMap.get(key));
        }
        System.out.println("----------------------------------");
        // Iterating using forEach
        hashMap.forEach((key, value) -> {
            System.out.println("Key: " + key + ", Value: " + value);
        });
    }

    static void demoNestedHashMap() {
        HashMap<String, HashMap<String, String>> nestedHashMap = new HashMap<>();

        HashMap<String, String> employee1 = new HashMap<>();
        employee1.put("name", "Bob");
        employee1.put("age", "25");

        nestedHashMap.put("user1", employee1);

        HashMap<String, String> employee2 = new HashMap<>();
        employee2.put("name", "Charlie");
        employee2.put("age", "28");

        nestedHashMap.put("user2", employee2);

        // Displaying the nested HashMap
        System.out.println("Nested HashMap: " + nestedHashMap);
        System.out.println("User1 Name: " + nestedHashMap.get("user1").get("name"));
    }
}
