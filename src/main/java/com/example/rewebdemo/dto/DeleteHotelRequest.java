package com.example.rewebdemo.dto;

import lombok.Data;

@Data
public class DeleteHotelRequest {

    private String hotelName;

    private boolean status;
}
