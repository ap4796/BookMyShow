package com.example.BookMyShow.Controller;

import com.example.BookMyShow.Service.Impl.TheatreServiceImpl;
import com.example.BookMyShow.dto.EntryDto.TheatreEntryDto;
import com.example.BookMyShow.dto.ResponseDto.TheatreResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("Theatre")
public class TheatreController {

    @Autowired
    TheatreServiceImpl TheatreService;


    @PostMapping("/add")
    public TheatreResponseDto addTheatre(@RequestBody() TheatreEntryDto TheatreEntryDto){

        return TheatreService.addTheatre(TheatreEntryDto);

    }

    @GetMapping("/getTheatreDetails/{id}")
    public TheatreResponseDto getTheatreDetails(@PathVariable("id") int TheatreId){
        return TheatreService.getTheatre(TheatreId);
    }

}