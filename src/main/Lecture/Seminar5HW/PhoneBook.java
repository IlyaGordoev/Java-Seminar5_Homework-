package Seminar5HW;

import com.sun.jdi.Value;

import java.awt.*;
import java.util.*;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class PhoneBook {
    /*
    Реализуйте структуру телефонной книги с помощью HashMap.
    Программа также должна учитывать, что во входной структуре будут повторяющиеся имена
    с разными телефонами, их необходимо считать, как одного человека с разными телефонами.
    Вывод должен быть отсортирован по убыванию числа телефонов.
    */
    private Map<String, ArrayList<String>> map = new HashMap<>();

    void add(String name, String phoneNum) {

        if (map.containsKey(name)) {
            map.get(name).add(phoneNum);
        } else {
            List<String> arr = new ArrayList<>();
            arr.add(phoneNum);
            map.put(name, (ArrayList<String>) arr);
        }
    }
    String getByName(String name) {
        return name + ":" + map.get(name);
    }

    String getByNum(String phone) {
        StringBuilder stringBuilder = new StringBuilder();
        for (Map.Entry<String, ArrayList<String>> entry : map.entrySet()) {
            for (String value: entry.getValue()) {
                if (value.equals(phone)) {
                    stringBuilder.append(entry.getKey())
                            .append(" : ")
                            .append(entry.getValue())
                            .append("\n");
                }
            }
        }
        return stringBuilder.toString();
    }

    void getAll() {
    List<ArrayList<String>> arr = new ArrayList<>(map.values());
    arr.sort(Comparator.comparingInt(List::size));
    Collections.reverse(arr);
//    System.out.println(arr);
//    System.out.println(map);
        for (ArrayList array: arr) {
            for (Map.Entry<String, ArrayList<String>> entry : map.entrySet()) {
                if (entry.getValue().equals(array)) {
                    System.out.println(entry.getKey() + " " + entry.getValue());
                    }
                }
            }
        }
    }

