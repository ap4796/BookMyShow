package com.example.BookMyShow.Converter;

import com.example.BookMyShow.Model.TheatreEntity;
import com.example.BookMyShow.dto.EntryDto.TheatreEntryDto;
import com.example.BookMyShow.dto.ResponseDto.TheatreResponseDto;
import lombok.experimental.UtilityClass;

@UtilityClass
public class TheatreConverter {

    public static TheatreEntity convertDtoToEntity(TheatreEntryDto TheatreEntryDto){

        return TheatreEntity.builder().address(TheatreEntryDto.getAddress())
                .city(TheatreEntryDto.getCity()).name(TheatreEntryDto.getName()).build();


    }

    public static TheatreResponseDto convertEntityToDto(TheatreEntity TheatreEntity){

        return TheatreResponseDto.builder().id(TheatreEntity.getId()).name(TheatreEntity.getName())
                .city(TheatreEntity.getCity()).address(TheatreEntity.getAddress())
                .type(TheatreEntity.getType())
                .build();
    }
}