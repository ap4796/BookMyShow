package com.example.BookMyShow.dto;

import lombok.*;
import java.time.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ShowDto {

    private int id;
    private LocalDate showDate;
    private LocalTime showTime;
    private MovieDto movieDto;
    private TheatreDto theatreDto;
}
