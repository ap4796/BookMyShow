package com.example.BookMyShow.dto;

import lombok.*;

import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TicketDto {

    int id; //ticket id
    Set<String> allottedSeats;
    double amount;

    ShowDto showDto;
    UserDto userDto;
}
