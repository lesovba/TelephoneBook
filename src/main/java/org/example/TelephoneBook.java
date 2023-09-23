package org.example;

import java.util.*;
import java.util.stream.Collectors;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class TelephoneBook {
    private Map<String, Set<String>> phoneBook;

    public TelephoneBook() {
        phoneBook = new HashMap<>();
    }

    public void addContact(String name, String phoneNumber) {
        phoneBook.computeIfAbsent(name, k -> new HashSet<>()).add(phoneNumber);
    }

    public Set<String> findContact(String name) {
        return phoneBook.getOrDefault(name, new HashSet<>());
    }

    //Изначально добавил метод без сортировки по количеству номеров
    public void printPhoneBook() {
        System.out.println("Телефонная книга");
        for (Map.Entry<String, Set<String>> entry : phoneBook.entrySet()) {
            System.out.println("Имя: " + entry.getKey());
            System.out.println("Номера телефонов:");
            for (String phoneNumber : entry.getValue()) {
                System.out.println(phoneNumber);
            }
            System.out.println();
        }
    }
    public void printPhoneBookSortedByQuantity() {
        // Создаем список с сортировкой по количеству номеров (по убыванию)
        List<Map.Entry<String, Set<String>>> sortedEntries = phoneBook.entrySet()
                .stream()
                .sorted((entry1, entry2) -> Integer.compare(entry2.getValue().size(), entry1.getValue().size()))
                .collect(Collectors.toList());

        System.out.println("Телефонная книга (по убыванию количества номеров:");
        for (Map.Entry<String, Set<String>> entry : sortedEntries) {
            System.out.println("ФИО: " + entry.getKey());
            System.out.println("Телефонные номера (" + entry.getValue().size() + "):");
            for (String phoneNumber : entry.getValue()) {
                System.out.println(phoneNumber);
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        TelephoneBook telephoneBook = new TelephoneBook();
        Scanner scanner = new Scanner(System.in);
        //Добавим изначальные данные
        telephoneBook.addContact ("Голубев Артём Игоревич", "+7937459489");
        telephoneBook.addContact ("Голубев Артём Игоревич", "+13232345466");
        telephoneBook.addContact("Никодимов Амбросий Акакиевич", "+1225265745");
        telephoneBook.addContact("Никодимов Амбросий Акакиевич", "+787885745");
        telephoneBook.addContact("Никодимов Амбросий Акакиевич", "+8225265745");
        telephoneBook.addContact("Тыльбердиева Гульчачак Кважитовна", "+2511212135");
        telephoneBook.addContact("Закиров Фердинанд Шайхиевич", "+41234565486");
        telephoneBook.addContact("Брандонов Марлон Брандонович", "+4554688798");

        while (true) {
            System.out.println("Меню телефонной книги:");
            System.out.println("1. Добавить контакт");
            System.out.println("2. Найти контакт");
            System.out.println("3. Показать все данные");
            System.out.println("4. Выход");
            System.out.print("Выберите пункт меню (1-4): ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Введите ФИО: ");
                    String name = scanner.nextLine();
                    System.out.print("Введите телефон: ");
                    String phoneNumber = scanner.nextLine();
                    telephoneBook.addContact(name, phoneNumber);
                    System.out.println("Контакт добавлен");
                    break;
                case 2:
                    System.out.print("Введите ФИО для поиска (используйте пробелы): ");
                    String searchName = scanner.nextLine();
                    Set<String> results = telephoneBook.findContact(searchName);
                    if (!results.isEmpty()) {
                        System.out.println("Результат поиска" + searchName + ":");
                        for (String result : results) {
                            System.out.println(result);
                        }
                    } else {
                        System.out.println("Контакт не найден");
                    }
                    break;
                case 3:
                    telephoneBook.printPhoneBookSortedByQuantity();
                    break;
                case 4:
                    System.out.println("Выход из телефонной книги");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Неверный выбор. Пожалуйста, повторите выбор");
                    break;
            }
        }
    }
}