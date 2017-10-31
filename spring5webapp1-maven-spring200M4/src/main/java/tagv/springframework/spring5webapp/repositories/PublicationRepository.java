package tagv.springframework.spring5webapp.repositories;

import org.springframework.data.repository.CrudRepository;
import tagv.springframework.spring5webapp.model.Publication;

public interface PublicationRepository extends CrudRepository<Publication, Long> {
}
