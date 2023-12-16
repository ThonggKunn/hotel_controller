package com.example.rewebdemo.repository;

import com.example.rewebdemo.Entity.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HotelRepository extends JpaRepository<Hotel, Long> {

    Hotel findByHotelName(String hotelName);

    Hotel findByHotelId(Long Id);

}
