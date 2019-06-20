package sve.project.bookservice.service;


import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sve.project.bookservice.domain.Author;
import sve.project.bookservice.repos.AuthorRepository;

import java.util.Optional;

@Service
@Transactional
public class AuthorService {
    private final AuthorRepository authorRepository;

    public AuthorService(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @Transactional
    public Iterable<Author> getAuthors(){
        return authorRepository.findAll();
    }

    @Transactional
    public Optional<Author> getAuthorById(Long id){
        return authorRepository.findById(id);
    }

    @Transactional
    public Author saveAuthor(Author Author){
        return authorRepository.save(Author);
    }

    @Transactional
    public void deleteAuthor(Long id){
        authorRepository.deleteById(id);
    }
}
