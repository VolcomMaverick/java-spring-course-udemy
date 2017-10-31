package tagv.springframework.spring5webapp.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Copied from jt by vm on 10/13/17
 */
@Entity
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String title;
    private String isbn;

    @OneToOne
    private Publisher publisher;

    @OneToOne
    private Qublisher qublisher;

    @ManyToMany
    @JoinTable(name = "author_book", joinColumns = @JoinColumn(name = "book_id"), inverseJoinColumns = @JoinColumn(name = "author.id"))
    private Set<Author> authors = new HashSet<>();

    @ManyToMany
    @JoinTable(name = "publication_book", joinColumns = @JoinColumn(name = "book_id"), inverseJoinColumns = @JoinColumn(name = "publication.id"))
    private Set<Publication> publications = new HashSet<>();

    public Book() {
    }

    public Book(String title, String isbn, Publisher publisher) {
        this.title = title;
        this.isbn = isbn;
        this.publisher = publisher;
    }

    public Book(String title, String isbn, Publisher publisher, Qublisher qublisher) {
        this.title = title;
        this.isbn = isbn;
        this.publisher = publisher;
        this.qublisher = qublisher;
    }

    public Book(String title, String isbn, Publisher publisher, Qublisher qublisher, Set<Author> authors) {
        this.title = title;
        this.isbn = isbn;
        this.publisher = publisher;
        this.qublisher = qublisher;
        this.authors = authors;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

//    public String getPublisher() {
//        return publisher;
//    }

//    public void setPublisher(String publisher) {
//        this.publisher = publisher;
//    }

    public Set<Author> getAuthors() {
        return authors;
    }

    public void setAuthors(Set<Author> authors) {
        this.authors = authors;
    }

    public Set<Publication> getPublications() { return publications; }

    public void setPublications(Set<Publication> publications) { this.publications = publications; }

    //    public Set<Publisher> getPublishers() { return publishers; }
//
//    public void setPublishers(Set<Publisher> publishers) { this.publishers = publishers; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Book book = (Book) o;

        return id != null ? id.equals(book.id) : book.id == null;
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", isbn='" + isbn + '\'' +
                ", publisher='" + publisher + '\'' +
                ", qublisher='" + qublisher + '\'' +
                ", authors=" + authors +
                ", publications=" + publications +
                '}';
    }
}
