package com.example.BookMyShow.Repository;

import com.example.BookMyShow.Model.TheatreSeatsEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TheatreSeatsRepository extends JpaRepository<TheatreSeatsEntity, Integer> {
}
