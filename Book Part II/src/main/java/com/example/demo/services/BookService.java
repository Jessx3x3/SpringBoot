package com.example.demo.services;

import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;

import com.example.demo.models.Book;
import com.example.demo.repositories.BookRepository;

@Service
public class BookService {

	//Agregando el book al repositorio como una dependencia
    private final BookRepository bookRepository;
    
    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }
    //Devolviendo todos los libros.
    public List<Book> allBooks() {
        return bookRepository.findAll();
    }
    //Creando un libro.
    public Book createBook(Book b) {
        return bookRepository.save(b);
    }
    //Obteniendo la información de un libro
    public Book findBook(Long id) {
        Optional<Book> optionalBook = bookRepository.findById(id);
        if(optionalBook.isPresent()) {
            return optionalBook.get();
        } else {
            return null;
        }
    }
    
    public Book updateBook(long id, String title, String description, String lang, int pages) {
    	
    	if(bookRepository.findById(id).isPresent()) {
    		Book book = bookRepository.findById(id).get();
    		
    		book.setTitle(title);
    		book.setDescription(description);
    		book.setLanguage(lang);
    		book.setNumberOfPages(pages);

    		return bookRepository.save(book);

    	}
    
    	return null;
    }
    
    public void deleteBook(Long id) {
    
    	bookRepository.deleteById(id);
    }

   
}
