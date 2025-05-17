package com.example.BookMyShow.dto.EntryDto;


import lombok.Builder;
import lombok.Getter;
import org.jetbrains.annotations.NotNull;


import java.time.LocalDate;

@Getter
@Builder
public class MovieEntryDto { //Dtos are built to avoid heavy api calling bcz they contain only required parameters

    String name;

    @NotNull
    LocalDate releaseDate;
}
