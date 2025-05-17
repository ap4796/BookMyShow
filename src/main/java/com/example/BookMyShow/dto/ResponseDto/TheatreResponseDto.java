package com.example.BookMyShow.dto.ResponseDto;

import com.example.BookMyShow.Enums.TheatreType;

import lombok.Builder;
import lombok.Data;
import org.jetbrains.annotations.NotNull;

@Data
@Builder
public class TheatreResponseDto {

    @NotNull
    int id;

    String name;
    String address;
    String city;
    TheatreType type;
    //Show Entity
}