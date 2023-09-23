package org.example;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
    TelephoneBook telBook = new TelephoneBook();
        telBook.addContact ("Голубев Артём Игоревич", "+7937459489");
        telBook.addContact("Никодимов Амбросий Акакиевич", "+1225265745");
        telBook.addContact("Никодимов Амбросий Акакиевич", "+78979765745");
        telBook.addContact("Никодимов Амбросий Акакиевич", "+129889265745");
        telBook.addContact("Тыльбердиева Гульчачак Кважитовна", "+2511212135");
        telBook.addContact("Закиров Фердинанд Шайхиевич", "+41234565486");
        telBook.addContact("Брандонов Марлон Брандонович", "+4554688798");
        telBook.printPhoneBookSortedByQuantity();
        }
    }