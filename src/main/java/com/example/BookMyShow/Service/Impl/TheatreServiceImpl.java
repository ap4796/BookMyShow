package com.example.BookMyShow.Service.Impl;

import com.example.BookMyShow.Converter.TheatreConverter;
import com.example.BookMyShow.Model.TheatreEntity;
import com.example.BookMyShow.Model.TheatreSeatsEntity;
import com.example.BookMyShow.Repository.TheatreRepository;
import com.example.BookMyShow.Repository.TheatreSeatsRepository;
import com.example.BookMyShow.Service.TheatreService;

import com.example.BookMyShow.dto.EntryDto.TheatreEntryDto;
import com.example.BookMyShow.dto.ResponseDto.TheatreResponseDto;
import com.example.BookMyShow.Enums.SeatType;
import com.example.BookMyShow.Enums.TheatreType;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
public class TheatreServiceImpl implements TheatreService {

    @Autowired
    TheatreRepository TheatreRepository;

    @Autowired
    TheatreSeatsRepository TheatreSeatsRepository;

    @Override
    public TheatreResponseDto addTheatre(TheatreEntryDto TheatreEntryDto) {

        TheatreEntity TheatreEntity = TheatreConverter.convertDtoToEntity(TheatreEntryDto);

        //create the Seats
        List<TheatreSeatsEntity> seats = createTheatreSeats();

        TheatreEntity.setSeats(seats);
        //I need to set the TheatreId for all these seats

        TheatreEntity.setShows(null);

        for(TheatreSeatsEntity TheatreSeatsEntity:seats){
            TheatreSeatsEntity.setTheatre(TheatreEntity);
        }

        TheatreEntity.setType(TheatreType.SINGLE);

        log.info("The Theatre entity is "+ TheatreEntity);

        TheatreEntity = TheatreRepository.save(TheatreEntity);

        TheatreSeatsRepository.saveAll(seats);

        TheatreResponseDto TheatreResponseDto = TheatreConverter.convertEntityToDto(TheatreEntity);

        return TheatreResponseDto;

    }

    List<TheatreSeatsEntity> createTheatreSeats(){


        List<TheatreSeatsEntity> seats = new ArrayList<>();

        seats.add(getTheatreSeat("1A",100,SeatType.CLASSIC));
        seats.add(getTheatreSeat("1B",100,SeatType.CLASSIC));
        seats.add(getTheatreSeat("1C",100,SeatType.CLASSIC));
        seats.add(getTheatreSeat("1D",100,SeatType.CLASSIC));
        seats.add(getTheatreSeat("1E",100,SeatType.CLASSIC));

        seats.add(getTheatreSeat("2A",100,SeatType.PREMIUM));
        seats.add(getTheatreSeat("2B",100,SeatType.PREMIUM));
        seats.add(getTheatreSeat("2C",100,SeatType.PREMIUM));
        seats.add(getTheatreSeat("2D",100,SeatType.PREMIUM));
        seats.add(getTheatreSeat("2E",100,SeatType.PREMIUM));

        return seats;
        //Add in this TheatreSeatEntity type

    }

    TheatreSeatsEntity getTheatreSeat(String seatName, int rate, SeatType seatType){

        return TheatreSeatsEntity.builder().seatNumber(seatName).rate(rate).seatType(seatType).build();
    }

    //Separate function will be created...


    @Override
    public TheatreResponseDto getTheatre(int id) {

        TheatreEntity TheatreEntity = TheatreRepository.findById(id).get();

        TheatreResponseDto TheatreResponseDto = TheatreConverter.convertEntityToDto(TheatreEntity);

        return TheatreResponseDto;
    }
}