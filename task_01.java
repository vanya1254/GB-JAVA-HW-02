// package com.example;

import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

/**
 * Дана строка sql-запроса "select * from students where ". Сформируйте часть
 * WHERE этого запроса, используя StringBuilder. Данные для фильтрации приведены
 * ниже в виде json строки.
 * 
 * Если значение null, то параметр не должен попадать в запрос.
 * 
 * Параметры для фильтрации: {"name":"Ivanov", "country":"Russia",
 * "city":"Moscow", "age":"null"}
 */

public class App {
    public static void main(String[] args) {

        Map<String, String> dictionary = new HashMap<String, String>();

        JSONParser parser = new JSONParser();

        try (FileReader reader = new FileReader("01.json");) {

            JSONObject rootJsonObject = (JSONObject) parser.parse(reader);

            String name = (String) rootJsonObject.get("name");
            String country = (String) rootJsonObject.get("country");
            String city = (String) rootJsonObject.get("city");
            String age = (String) rootJsonObject.get("age");

            dictionary.put("name", name);
            dictionary.put("country", country);
            dictionary.put("city", city);
            dictionary.put("age", age);

            StringBuilder sql = new StringBuilder("SELECT * FROM students WHERE");

            for (Map.Entry<String, String> entry : dictionary.entrySet()) {
                String key = entry.getKey().toString();
                String value = entry.getValue().toString();
                if (value.equals("null"))
                    continue;
                else {
                    if (key.equals("country"))
                        sql.append(" ").append(key).append(" = ").append(value);
                    else
                        sql.append(" AND ").append(key).append(" = ").append(value);
                }
            }

            System.out.println(sql.toString());                                                     // SELECT * FROM students WHERE country = Russia AND city = Moscow AND name = Ivanov

        } catch (Exception e) {
            System.out.println("Parsing error" + e.toString());
        }
    }
}