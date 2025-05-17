package com.example.BookMyShow.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MovieDto {
    private int id;
    private String name;
    private LocalDate releaseDate;
    private List<ShowDto> movieShow;
}
