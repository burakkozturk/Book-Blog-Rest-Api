package com.bookblog.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookDto {

    private String name;
    private int rating;
    private String summary;
    private String releaseDate;
    private Long categoryId;
    private Long authorId;

}
