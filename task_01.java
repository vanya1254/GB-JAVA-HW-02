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

public class task_01 {
    public static void main(String[] args) {
        Object obj = new JSONParser().parse(new FileReader("01.json"));
    }
}