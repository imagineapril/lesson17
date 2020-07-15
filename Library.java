package ru.timokhina.lesson17.serialization;

import java.io.*;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Library {

    public static void main(String[] args) {

        List<Book> books = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        System.out.println("1 - добавить книгу");
        System.out.println("2 - сохранить книгу");
        System.out.println("3 - выход");
        boolean exit = false;
        do {
            switch (sc.nextInt()) {
                case 1: {
                    System.out.println("Введите название книги");
                    String title = sc.next();
                    System.out.println("Введите автора книги");
                    String author = sc.next();
                    System.out.println("Введите год выпуска книги");
                    String year = sc.next();
                    books.add(new Book(title, author, year));
                }
                break;
                case 2: {
                    try (OutputStream os = new FileOutputStream("booksList.dat");
                         ObjectOutputStream oos = new ObjectOutputStream(os)) {
                        oos.writeObject(books);
                    } catch (IOException ex) {

                    }
                }
                break;
                case 3:
                    exit = true;
                    break;
            }
        } while (!exit);

        List<Book> bookList = getBooks("booksList.dat");
        for (Book book : bookList) {
            System.out.println(book);
        }
    }

    private static List<Book> getBooks(String fileName) {
        if (new File(fileName).exists()) {
            try (InputStream is = new FileInputStream(fileName);
                 ObjectInputStream ois = new ObjectInputStream(is)) {
                return (List<Book>) ois.readObject();

            } catch (IOException | ClassNotFoundException ex) {
                System.out.println(ex);
            }
        }
        System.out.println("Библиотека пустая.");
        return new ArrayList<>();
    }
}
