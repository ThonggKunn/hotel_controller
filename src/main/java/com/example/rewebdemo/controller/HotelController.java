package com.example.rewebdemo.controller;

import com.example.rewebdemo.Entity.Hotel;
import com.example.rewebdemo.dto.CreateHotelRequest;
import com.example.rewebdemo.dto.Responsedto;
import com.example.rewebdemo.dto.UpdateHotelRequest;
import com.example.rewebdemo.service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class HotelController {

    private static List<Hotel> hotels = new ArrayList<Hotel>();

    @Autowired
    HotelService hotelService;

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

        return hotelService.createHotel(request);
    }
//
    //Lấy danh sách
    @GetMapping("/hotels")
    public List<Hotel> getHotels(@RequestParam(required = false) Integer rate,
                                 @RequestParam(required = false) boolean status)  {
        return hotelService.getAll();
    }

    //Lấy thông tin 1 hotel
    @GetMapping("/hotels/{hotelID}")
    public Hotel getHotel(@PathVariable Long hotelID) {

        return hotelService.getHotelById(hotelID);
    }

    List<Hotel> findHotelByRate(Integer rate) {
        List<Hotel> result = new LinkedList<>();

        for (Hotel hotel: hotels) {
            if (hotel.getRate().equals(rate)) {
                result.add(hotel);
            }
        }
        return result;
    }

    List<Hotel> findHotelByStatusandRate(Integer rate, boolean status) {
        List<Hotel> result = new LinkedList<>();

        for (Hotel hotel: hotels) {
            if (hotel.getRate().equals(rate) && hotel.isStatus() == status) {
                result.add(hotel);
            }
        }
        return result;
    }

    //Cập nhật 1 ksan
    @PutMapping("/hotels/{hotelID}")
    public Hotel updateHotel(@PathVariable Long hotelID,
                             @RequestBody UpdateHotelRequest request) {
        return hotelService.updateHotel(hotelID, request);
    }

     //Vô hiệu hóa 1 khách sạn
    @DeleteMapping("/hotels/{hotelID}")
    public Responsedto disableHotel(@PathVariable Long hotelID) {
        return hotelService.disableHotel(hotelID);
    }

    private Hotel findHotelById(String hotelID) {
        for (Hotel hotel: hotels) {
            if (hotel.getHotelID().equals(hotelID)) {
                return hotel;
            }
        }
        return null;
    }

}



