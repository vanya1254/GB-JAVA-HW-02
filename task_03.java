// package com.example;

import java.io.FileReader;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

/**
 * Дана json строка (можно сохранить в файл и читать из файла)
 * 
 * [{"фамилия":"Иванов","оценка":"5","предмет":"Математика"},{"фамилия":"Петрова","оценка":"4","предмет":"Информатика"},{"фамилия":"Краснов","оценка":"5","предмет":"Физика"}]
 * 
 * Написать метод(ы), который распарсит json и, используя StringBuilder, создаст
 * строки вида: Студент [фамилия] получил [оценка] по предмету [предмет].
 * 
 * Пример вывода:
 * 
 * Студент Иванов получил 5 по предмету Математика.
 * 
 * Студент Петрова получил 4 по предмету Информатика.
 * 
 * Студент Краснов получил 5 по предмету Физика.
 */

public class App {
    public static void main(String[] args) {

        JSONParser parser = new JSONParser();

        try (FileReader reader = new FileReader("03.json")) {

            JSONArray jsonArray = (JSONArray) parser.parse(reader);

            for (int i = 0; i < jsonArray.size(); i++) {
                JSONObject jsonObject = (JSONObject) jsonArray.get(i);

                String surname = (String) jsonObject.get("фамилия");
                String mark = (String) jsonObject.get("оценка");
                String lesson = (String) jsonObject.get("предмет");

                StringBuilder pString = new StringBuilder();
                pString.append("Студент ").append(surname).append(" получил ").append(mark).append(" по предмету ")
                        .append(lesson).append(".");
                System.out.println(pString.toString());                   // Студент Иванов получил 5 по предмету Математика.
                                                                          // Студент Петрова получил 4 по предмету Информатика.
                                                                          // Студент Краснов получил 5 по предмету Физика.

            }

        } catch (Exception e) {
            System.out.println("Parsing error" + e.toString());
        }
    }
}