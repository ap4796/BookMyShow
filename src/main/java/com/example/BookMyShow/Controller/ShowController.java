package com.example.BookMyShow.Controller;



import com.example.BookMyShow.Service.Impl.ShowServiceImpl;
import com.example.BookMyShow.dto.EntryDto.ShowEntryDto;
import com.example.BookMyShow.dto.ResponseDto.ShowResponseDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
@RequestMapping("show")
public class ShowController {


    @Autowired
    ShowServiceImpl showService;


    @PostMapping("/add")
    public ShowResponseDto addShow(@RequestBody() ShowEntryDto showEntryDto){

        log.info("Here we are");

        return showService.addShow(showEntryDto);
    }

    @GetMapping("/get-user/{id}")
    public ShowResponseDto getShow(@PathVariable("id") int showId){
        return showService.getShow(showId);
    }

}