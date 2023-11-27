package com.example.rewebdemo.dto;

import com.example.rewebdemo.Entity.Hotel;
import lombok.Data;

@Data
public class UpdateHotelRequest {


    private String hotelName;

    private boolean status;

    public void deleteHotel(String hotelName, boolean status) {

    }
}
