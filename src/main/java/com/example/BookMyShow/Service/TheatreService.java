package com.example.BookMyShow.Service;

import com.example.BookMyShow.dto.EntryDto.TheatreEntryDto;
import com.example.BookMyShow.dto.ResponseDto.TheatreResponseDto;

public interface TheatreService {


    TheatreResponseDto addTheatre(TheatreEntryDto TheatreEntryDto);

    TheatreResponseDto getTheatre(int id);

}