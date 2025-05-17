package com.example.BookMyShow.Converter;

import com.example.BookMyShow.Model.TheatreEntity;
import com.example.BookMyShow.dto.EntryDto.TheatreEntryDto;
import com.example.BookMyShow.dto.ResponseDto.TheatreResponseDto;
import lombok.experimental.UtilityClass;

@UtilityClass
public class TheatreConverter {

    public static TheatreEntity convertDtoToEntity(TheatreEntryDto theaterEntryDto){

        return TheatreEntity.builder().address(theaterEntryDto.getAddress())
                .city(theaterEntryDto.getCity()).name(theaterEntryDto.getName()).build();


    }

    public static TheatreResponseDto convertEntityToDto(TheatreEntity theaterEntity){

        return TheatreResponseDto.builder().id(theaterEntity.getId()).name(theaterEntity.getName())
                .city(theaterEntity.getCity()).address(theaterEntity.getAddress())
                .type(theaterEntity.getType())
                .build();
    }
}