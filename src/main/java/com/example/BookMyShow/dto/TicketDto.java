package com.example.BookMyShow.dto;

import com.example.BookMyShow.dto.ResponseDto.ShowResponseDto;
import com.example.BookMyShow.dto.ResponseDto.UserResponseDto;

import lombok.Builder;
import lombok.Data;
import org.jetbrains.annotations.NotNull;

import java.util.Set;

@Data
@Builder
public class TicketDto {

    int id;

    String alloted_seats;

    double amount;

    ShowResponseDto showDto;

    @NotNull
    UserResponseDto userDto; //Mandatory for me to fill this userDto Value
}