package ru.timokhina.lesson17.serialization;

import java.io.*;

public class BookProgramm {
    public static void main(String[] args) {
        Book book = new Book("The Fountainhead", "Ayn Rand", "1943");
        System.out.println(book);
        try (OutputStream os = new FileOutputStream("books.dat");
             ObjectOutputStream oos = new ObjectOutputStream(os)) {
            oos.writeObject(book);

        } catch (IOException ex) {

        }
        try (InputStream is = new FileInputStream("books.dat");
             ObjectInputStream ois = new ObjectInputStream(is)) {

            while (is.available() > 0) {
                Book object = (Book) ois.readObject();
                System.out.println(object);
//                System.out.println(object.getTitle());
//                System.out.println(object.getAuthor());
//                System.out.println(object.getYear());
              }
        } catch (IOException | ClassNotFoundException ex) {
            System.out.println(ex);
        }
    }
}
