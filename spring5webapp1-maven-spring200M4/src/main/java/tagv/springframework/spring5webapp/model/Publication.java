package tagv.springframework.spring5webapp.model;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by vm on 10/31/17
 * Practicing ManyToMany Relationship
 */
@Entity
public class Publication {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String stringDate;
//    private Date formattedDate;

    @ManyToMany(mappedBy = "publications")
    private Set<Book> books = new HashSet<>();

    public Publication() {
    }

    public Publication(String name, String stringDate) {
        this.name = name;
        this.stringDate = stringDate;
    }

    public Publication(String name, String stringDate, Set<Book> books) {
        this.name = name;
        this.stringDate = stringDate;
        this.books = books;
    }

//    public Publication(String name, Date formattedDate) {
//        this.name = name;
//        this.formattedDate = formattedDate;
//    }

//    public Publication(String name, Date formattedDate, Set<Book> books) {
//        this.name = name;
//        this.formattedDate = formattedDate;
//        this.books = books;
//    }

    public Long getId() { return id; }

    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }

    public void setName(String name) { this.name = name; }

    public String getStringDate() { return stringDate; }

    public void setStringDate(String stringDate) { this.stringDate = stringDate; }

//    public Date getFormattedDate() { return formattedDate; }
//
//    public void setFormattedDate(Date formattedDate) { this.formattedDate = formattedDate; }

    public Set<Book> getBooks() { return books; }

    public void setBooks(Set<Book> books) { this.books = books; }

    /**
     * TODO equals and Hash
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Publication publication = (Publication) o;

        return id != null ? id.equals(publication.id) : publication.id == null;
    }

    @Override
    public int hashCode() { return id != null ? id.hashCode() : 0; }

    @Override
    public String toString() {
        return "Publication{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", stringDate='" + stringDate + '\'' +
//                ", formattedDate='" + formattedDate + '\'' +
                ", books='" + books + '\'' +
                '}';
    }
}
