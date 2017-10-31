package tagv.springframework.spring5webapp.bootstrap;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;
import tagv.springframework.spring5webapp.model.*;
import tagv.springframework.spring5webapp.repositories.AuthorRepository;
import tagv.springframework.spring5webapp.repositories.BookRepository;
import tagv.springframework.spring5webapp.repositories.PublisherRepository;
import tagv.springframework.spring5webapp.repositories.QublisherRepository;

/**
 * copied by vm on 10/30/17
 */
@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent> {

    private AuthorRepository authorRepository;
    private BookRepository bookRepository;
    private PublisherRepository publisherRepository;
    private QublisherRepository qublisherRepository;

    public DevBootstrap(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository, QublisherRepository qublisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
        this.qublisherRepository = qublisherRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        initData();
    }

    private void initData() {

        //Eric
        Author eric = new Author("Eric", "Evans");
//        Publisher jdk = new Publisher("John Deere K", "Merlin Avenue 10");
        Publication firstPublication = new Publication("New York", "12/22/1987");
        Publication secondPublication = new Publication("New Orleans", "12/22/1989");

        Publisher jdk = new Publisher();
        jdk.setName("John Deere K");
        jdk.setAddress("Merlin Avenue 10");
        publisherRepository.save(jdk);

        Qublisher qdk1 = new Qublisher();
        qdk1.setName("Qublisher1");
        qdk1.setAddress("QAddress1");
        qublisherRepository.save(qdk1);

        Book ddd = new Book("Domain Driven Design", "1234", jdk, qdk1);
        eric.getBooks().add(ddd);
        firstPublication.getBooks().add(ddd);
        secondPublication.getBooks().add(ddd);
        ddd.getAuthors().add(eric);
        ddd.getPublications().add(firstPublication);
        ddd.getPublications().add(secondPublication);

        authorRepository.save(eric);
        bookRepository.save(ddd);

        //Rod
        Author rod = new Author("Rod", "Johnson");
        Publisher jdl = new Publisher("John Deere L", "Merlin Avenue 11");
        publisherRepository.save(jdl);

        Qublisher qdk2 = new Qublisher("Qublisher2", "QAddress2");
        qublisherRepository.save(qdk2);

        Book noEJB = new Book("J2EE Development without EJB", "23444", jdl,qdk2);
        rod.getBooks().add(noEJB);
        secondPublication.getBooks().add(noEJB);
        noEJB.getAuthors().add(rod);
        noEJB.getPublications().add(secondPublication);

        authorRepository.save(rod);
        bookRepository.save(noEJB);
    }
}
