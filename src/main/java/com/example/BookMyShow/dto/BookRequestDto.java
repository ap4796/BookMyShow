package com.example.BookMyShow.dto;

import com.example.BookMyShow.Enums.SeatType;
import lombok.*;

import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BookRequestDto {

    int id; //user id
    int showId;
    SeatType seatType;
    Set<String> requestedSeats;
}
