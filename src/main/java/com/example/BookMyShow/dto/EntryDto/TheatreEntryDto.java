package com.example.BookMyShow.dto.EntryDto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class TheatreEntryDto {

    String name;
    String address;
    String city;

}