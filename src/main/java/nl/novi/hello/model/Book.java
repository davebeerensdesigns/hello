package nl.novi.hello.model;

import javax.persistence.*; // JPA

@Entity
@Table(name = "books")
public class Book {

    // attributes

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String title;
    private String author;
    private String isbn;

    // constructor is not necessary when using springboot (JPA)

//    public Book() {
//    }
//
//    public Book(String title, String author, String isbn) {
//        this.title = title;
//        this.author = author;
//        this.isbn = isbn;
//    }
//    public Book(int id, String title, String author, String isbn) {
//        this.id = id;
//        this.title = title;
//        this.author = author;
//        this.isbn = isbn;
//    }


    // setters and getters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }
}
