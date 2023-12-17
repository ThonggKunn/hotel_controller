package com.example.rewebdemo.service;

import com.example.rewebdemo.Entity.Hotel;
import com.example.rewebdemo.dto.CreateHotelRequest;
import com.example.rewebdemo.dto.Responsedto;
import com.example.rewebdemo.dto.UpdateHotelRequest;
import com.example.rewebdemo.repository.HotelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HotelService {

    @Autowired
    HotelRepository hotelRepository;

    public Hotel getHotelById(Long Id) {
        return hotelRepository.findByHotelId(Id);
    }

    public Hotel createHotel(CreateHotelRequest request) {
        Hotel hotel = new Hotel();
        hotel.setHotelName(request.getHotelName());
        hotel.setRate(request.getRate());

        hotel = hotelRepository.save(hotel);
        return hotel;
    }

    public List<Hotel> getAll() {
        return hotelRepository.findAll();
    }

    public Hotel updateHotel(Long hotelId, UpdateHotelRequest request) {
        Hotel hotel = hotelRepository.findByHotelId(hotelId);
        if (hotel == null) {
            return null;
        }

        hotel.setHotelName(request.getHotelName());
        hotel = hotelRepository.save(hotel);

        return hotel;
    }

    public Responsedto disableHotel(Long hotelId) {
        Hotel hotel = hotelRepository.findByHotelId(hotelId);
        if (hotel == null) {
            return new Responsedto(false, "Not found");
        }
        hotel.setStatus(false);
        hotel = hotelRepository.save(hotel);
        return new Responsedto(true, "Done");
    }

}
