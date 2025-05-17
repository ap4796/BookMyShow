package com.example.BookMyShow.Service.Impl;

import com.example.BookMyShow.Converter.MovieConverter;
import com.example.BookMyShow.Converter.ShowConverter;
import com.example.BookMyShow.Converter.TheatreConverter;
import com.example.BookMyShow.Model.*;
import com.example.BookMyShow.Repository.*;
import com.example.BookMyShow.Service.ShowService;

import com.example.BookMyShow.dto.EntryDto.ShowEntryDto;
import com.example.BookMyShow.dto.ResponseDto.MovieResponseDto;
import com.example.BookMyShow.dto.ResponseDto.ShowResponseDto;
import com.example.BookMyShow.dto.ResponseDto.TheatreResponseDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Slf4j //Helps
@Service
public class ShowServiceImpl implements ShowService {

    @Autowired
    MovieRepository movieRepository;

    @Autowired
    TheatreRepository TheatreRepository;

    @Autowired
    ShowSeatsRepository showSeatsRepository;

    @Autowired
    ShowRepository showRepository;

    @Override
    public ShowResponseDto addShow(ShowEntryDto showEntryDto) {

        ShowEntity showEntity = ShowConverter.convertDtoToEntity(showEntryDto);

        //MovieEntity
        MovieEntity movieEntity = movieRepository.findById(showEntryDto.getMovieResponseDto().getId()).get();

        TheatreEntity TheatreEntity = TheatreRepository.findById(showEntryDto.getTheatreResponseDto().getId()).get();


        showEntity.setMovie(movieEntity); //Why are we setting these variables
        showEntity.setTheatre(TheatreEntity);

        showEntity = showRepository.save(showEntity);

        //We need to pass the list of the Theatre seats
        List<ShowSeatsEntity> l=generateShowEntitySeats(TheatreEntity.getSeats(),showEntity);

        showSeatsRepository.saveAll(l);

        //We need to create Response Show Dto.
        ShowResponseDto showResponseDto = ShowConverter.convertEntityToDto(showEntity,showEntryDto);

        return showResponseDto;
    }

    public List<ShowSeatsEntity> generateShowEntitySeats(List<TheatreSeatsEntity> TheatreSeatsEntityList,ShowEntity showEntity){

        List<ShowSeatsEntity> showSeatsEntityList = new ArrayList<>();

        //log.info(String.valueOf(TheatreSeatsEntityList));
//        log.info("The list of TheatreEntity Seats");
//        for(TheatreSeatsEntity tse: TheatreSeatsEntityList){
//            log.info(tse.toString());
//        }

        for(TheatreSeatsEntity tse : TheatreSeatsEntityList){
            ShowSeatsEntity showSeatsEntity = ShowSeatsEntity.builder().seatNumber(tse.getSeatNumber())
                    .seatType(tse.getSeatType()).rate(tse.getRate()).build();

            showSeatsEntityList.add(showSeatsEntity);
        }

        //We need to set the show Entity for each of the ShowSeat....
        for(ShowSeatsEntity showSeatsEntity:showSeatsEntityList){
            showSeatsEntity.setShow(showEntity);
        }

        showEntity.setSeats(showSeatsEntityList);

        return showSeatsEntityList;
    }

    @Override
    public ShowResponseDto getShow(int id) {
        ShowEntity showEntity=showRepository.findById(id).get();
        MovieEntity movieEntity=movieRepository.findById(showEntity.getMovie().getId()).get();
        TheatreEntity TheatreEntity=TheatreRepository.findById(showEntity.getTheatre().getId()).get();
        MovieResponseDto movieResponseDto= MovieConverter.convertEntityToDto(movieEntity);
        TheatreResponseDto TheatreResponseDto= TheatreConverter.convertEntityToDto(TheatreEntity);
        ShowEntryDto showEntryDto=ShowEntryDto.builder().showDate(showEntity.getShowDate()).showTime(showEntity.getShowTime())
                .movieResponseDto(movieResponseDto).TheatreResponseDto(TheatreResponseDto).build();
        return ShowConverter.convertEntityToDto(showEntity, showEntryDto);
    }

}