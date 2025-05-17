package com.example.BookMyShow.dto;

import com.example.BookMyShow.Enums.TheatreType;
import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TheatreDto {

    private int id;
    private String name;
    private String city;
    private String address;
    private TheatreType type;

    ShowDto showDto;
}
