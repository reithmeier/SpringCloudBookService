package sve.project.bookservice.service;


import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;
import sve.project.bookservice.domain.Publisher;
import sve.project.bookservice.repos.PublisherRepository;

import java.util.Optional;

@Service
@Transactional
public class PublisherService {
    private final PublisherRepository publisherRepository;

    public PublisherService(PublisherRepository publisherRepository) {
        this.publisherRepository = publisherRepository;
    }

    @Transactional
    public Iterable<Publisher> getPublishers(){
        return publisherRepository.findAll();
    }

    @Transactional
    public Optional<Publisher> getPublisherById(Long id){
        return publisherRepository.findById(id);
    }

    @Transactional
    public Publisher savePublisher(Publisher Publisher){
        return publisherRepository.save(Publisher);
    }

    @Transactional
    public void deletePublisher(Long id){
        publisherRepository.deleteById(id);
    }
}
