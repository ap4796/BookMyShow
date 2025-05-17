package com.example.BookMyShow.dto.ResponseDto;


import lombok.Builder;
import lombok.Data;
import org.jetbrains.annotations.NotNull;

import java.time.LocalDate;
import java.util.List;

@Data
@Builder
public class MovieResponseDto {

    @NotNull
    int id;
    String name;
    LocalDate releaseDate;

    //Optional
    List<ShowResponseDto> showDtoList;
}