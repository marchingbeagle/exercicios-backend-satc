package com.example.demo.model;

import lombok.Data;

@Data
public class BookRequestDTO {
    private String title;
    private String author;
    private String isbn;
}