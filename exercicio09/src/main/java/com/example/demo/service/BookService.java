package com.example.demo.service;

import com.example.demo.model.Book;
import com.example.demo.model.BookRequestDTO;
import com.example.demo.model.BookResponseDTO;
import com.example.demo.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BookService {
    @Autowired
    private BookRepository bookRepository;

    public BookResponseDTO createBook(BookRequestDTO bookRequestDTO) {
        Book book = new Book();
        book.setTitle(bookRequestDTO.getTitle());
        book.setAuthor(bookRequestDTO.getAuthor());
        book.setIsbn(bookRequestDTO.getIsbn());
        book = bookRepository.save(book);
        return mapToResponseDTO(book);
    }

    public BookResponseDTO getBookById(Long id) {
        Book book = bookRepository.findById(id).orElseThrow(() -> new RuntimeException("Book not found"));
        return mapToResponseDTO(book);
    }

    public List<BookResponseDTO> getAllBooks() {
        return bookRepository.findAll().stream().map(this::mapToResponseDTO).collect(Collectors.toList());
    }

    public BookResponseDTO updateBook(Long id, BookRequestDTO bookRequestDTO) {
        Book book = bookRepository.findById(id).orElseThrow(() -> new RuntimeException("Book not found"));
        book.setTitle(bookRequestDTO.getTitle());
        book.setAuthor(bookRequestDTO.getAuthor());
        book.setIsbn(bookRequestDTO.getIsbn());
        book = bookRepository.save(book);
        return mapToResponseDTO(book);
    }

    public void deleteBook(Long id) {
        bookRepository.deleteById(id);
    }

    private BookResponseDTO mapToResponseDTO(Book book) {
        BookResponseDTO responseDTO = new BookResponseDTO();
        responseDTO.setId(book.getId());
        responseDTO.setTitle(book.getTitle());
        responseDTO.setAuthor(book.getAuthor());
        responseDTO.setIsbn(book.getIsbn());
        return responseDTO;
    }
}