package com.example.rewebdemo.controller;

import com.example.rewebdemo.Entity.Hotel;
import com.example.rewebdemo.Entity.Room;
import com.example.rewebdemo.dto.CreateRoomRequest;
import com.example.rewebdemo.dto.Responsedto;
import com.example.rewebdemo.dto.UpdateRoomRequest;
import com.example.rewebdemo.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
@RestController
@RequestMapping("/api/hotel")
public class RoomController {

    private static List<Room> rooms = new ArrayList<Room>();

    @Autowired
    RoomService roomService;
    private Room findRoombyId(String roomID) {
        for (Room room: rooms) {
            if (room.getRoomID().equals(roomID)) {
                return room;
            }
        }
        return null;


    }

    @PostMapping("/room")
    public Room createRoom(@RequestBody CreateRoomRequest request) {
        return roomService.createRoom(request);
    }


    @GetMapping("/rooms")
    public List<Room> getRoom() {
        return roomService.getAll();
    }


    @GetMapping("/room/{roomID}")
    public Room getRoom(@PathVariable Long roomID) {

        return roomService.getRoomById(roomID);
    }

    @PutMapping("/room/{roomID}")
    public Room updateRoom(@PathVariable Long roomID,
                           @RequestBody UpdateRoomRequest request) {

        return roomService.updateRoom(roomID, request);
    }


    @DeleteMapping("/room/de/{roomID}")
    public Responsedto disableRoom(@PathVariable Long roomID) {
        return roomService.disableRoom(roomID);
    }



}
