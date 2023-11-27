package com.example.rewebdemo.controller;

import com.example.rewebdemo.Entity.Hotel;
import com.example.rewebdemo.dto.CreateHotelRequest;
import com.example.rewebdemo.dto.DeleteHotelRequest;
import com.example.rewebdemo.dto.UpdateHotelRequest;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class HotelController {

    private static List<Hotel> hotels = new ArrayList<Hotel>();

    private Hotel findHotelbyID(String hotelID) {
        for (Hotel hotel: hotels) {
            if (hotel.getHotelID().equals(hotelID)) {
                return hotel;
            }
        }
        return null;
    }

    //Tạo hotel
    @PostMapping("/hotels")
    public Hotel createHotel(@RequestBody CreateHotelRequest request) {
        Hotel hotel = new Hotel();

        hotel.setHotelID(request.getHotelID());
        hotel.setHotelName(request.getHotelName());

        hotels.add(hotel);

        return hotel;
    }

    //Lấy danh sách
    @GetMapping("/hotels")
    public List<Hotel> getHotels() {
        return hotels;
    }

    //Lấy thông tin 1 hotel
    @GetMapping("/hotels/{hotelID}")
    public Hotel getHotel(@PathVariable String hotelID) {

        for (Hotel hotel: hotels) {
            if (hotel.getHotelID().equals(hotelID)) {
                return hotel;
            }
        }
        return null;
    }

    //Cập nhật 1 ksan
    @PutMapping("/hotels/{hotelID}")
    public Hotel updateHotel(@PathVariable String hotelID,
                             @RequestBody UpdateHotelRequest request) {
        Hotel hotel = findHotelbyID(hotelID);
        if (hotelID == null) {
            return null;
        }

        hotel.setHotelName(request.getHotelName());
        hotel.setStatus(request.isStatus());
        return hotel;
    }

    // Vô hiệu hóa 1 khách sạn
//    @DeleteMapping("/hotels/{hotelID}")
//    public Hotel deleteHotel(@PathVariable String hotelID,
//                             @RequestBody DeleteHotelRequest request) {
//        Hotel hotel = findHotelbyID(hotelID);
//        if (hotelID == null) {
//            return null;
//        }
//
//        hotel.setHotelName(request.getHotelName());
//        hotel.setStatus(request.isStatus());
//        return hotel;
//    }
    }



