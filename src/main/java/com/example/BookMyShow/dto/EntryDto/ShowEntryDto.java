package com.example.BookMyShow.dto.EntryDto;

import com.example.BookMyShow.dto.ResponseDto.MovieResponseDto;
import com.example.BookMyShow.dto.ResponseDto.TheatreResponseDto;

import lombok.Builder;
import lombok.Data;
import org.jetbrains.annotations.NotNull;

import java.time.LocalDate;
import java.time.LocalTime;

@Data
@Builder
public class ShowEntryDto {

    @NotNull
    LocalDate showDate;

    @NotNull
    LocalTime showTime;

    @NotNull
    MovieResponseDto movieResponseDto;

    @NotNull
    TheatreResponseDto TheatreResponseDto;
}