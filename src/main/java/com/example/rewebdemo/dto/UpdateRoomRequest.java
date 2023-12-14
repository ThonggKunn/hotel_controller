package com.example.rewebdemo.dto;

import lombok.Data;

@Data
public class UpdateRoomRequest {

    private String roomID;

    private boolean status;
}
