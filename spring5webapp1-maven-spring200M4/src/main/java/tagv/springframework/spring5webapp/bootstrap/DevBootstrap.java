package tagv.springframework.spring5webapp.bootstrap;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;
import tagv.springframework.spring5webapp.model.Author;
import tagv.springframework.spring5webapp.model.Book;
import tagv.springframework.spring5webapp.model.Publisher;
import tagv.springframework.spring5webapp.repositories.AuthorRepository;
import tagv.springframework.spring5webapp.repositories.BookRepository;
import tagv.springframework.spring5webapp.repositories.PublisherRepository;

/**
 * copied by vm on 10/30/17
 */
@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent> {

    private AuthorRepository authorRepository;
    private BookRepository bookRepository;
    private PublisherRepository publisherRepository;

    public DevBootstrap(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        initData();
    }

    private void initData() {
        //Eric
        Author eric = new Author("Eric", "Evans");
        Book ddd = new Book("Domain Driven Design", "1234", "Harper Collins");
        Publisher jdk = new Publisher("John Deere K", "Merlin Avenue 10");
        eric.getBooks().add(ddd);
        ddd.getAuthors().add(eric);
        jdk.getPublishers().add(jdk);

        authorRepository.save(eric);
        bookRepository.save(ddd);
        publisherRepository.save(jdk);

        //Rod
        Author rod = new Author("Rod", "Johnson");
        Book noEJB = new Book("J2EE Development without EJB", "23444", "Worx");
        Publisher jdl = new Publisher("John Deere L", "Merlin Avenue 11");
        rod.getBooks().add(noEJB);
        noEJB.getAuthors().add(rod);
        jdl.getPublishers().add(jdl);

        authorRepository.save(rod);
        bookRepository.save(noEJB);
        publisherRepository.save(jdl);
    }
}
