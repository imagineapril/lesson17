package ru.timokhina.lesson17.serialization;

import java.io.Serializable;

public class Book implements Serializable {
    public static final long serialVersionUID = 1L;
    String title;
    String author;
    String year;
    public Book(String title, String author, String year)   {
        this.title = title;
        this.author = author;
        this.year = year;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getYear() {
        return year;
    }

    @Override
    public String toString() {
        return "Book{" +
                "title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", year='" + year + '\'' +
                '}';
    }
}
