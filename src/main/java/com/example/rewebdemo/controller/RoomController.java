package com.example.rewebdemo.controller;

import com.example.rewebdemo.Entity.Hotel;
import com.example.rewebdemo.Entity.Room;
import com.example.rewebdemo.dto.CreateRoomRequest;
import com.example.rewebdemo.dto.Responsedto;
import com.example.rewebdemo.dto.UpdateRoomRequest;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
@RestController
@RequestMapping("/api/hotel")
public class RoomController {

    private static List<Room> rooms = new ArrayList<Room>();

    private Room findRoombyId(String roomID) {
        for (Room room: rooms) {
            if (room.getRoomID().equals(roomID)) {
                return room;
            }
        }
        return null;


    }

    //tao Room
    @PostMapping("/room")
    public Room createRoom(@RequestBody CreateRoomRequest request) {
        Room room = new Room();

        room.setRoomID(request.getRoomId());
        room.setRoomType(request.getRoomType());

        rooms.add(room);

        return room;
    }

    //lay danh sach
    @GetMapping("/rooms")
    public static List<Room> getRoom() {
        return rooms;
    }

    //lay 1 room
    @GetMapping("/room/{roomID}")
    public Room getRoom(@PathVariable String roomID) {

        for (Room room : rooms) {
            if (room.getRoomID().equals(roomID)) {
                return room;
            }
        }
        return null;
    }

    @PutMapping("/room/{roomID}")
    public Room updateRoom(@PathVariable String roomID,
                           @RequestBody UpdateRoomRequest request) {

        Room room = findRoombyId(roomID);
        if (roomID == null) {
            return null;
        }

        room.setRoomID(request.getRoomID());
        room.setStatus(request.isStatus());
        return room;
    }


    //xoa 1 phong
    @DeleteMapping("/room/de/{roomID}")
    public Room deleteRoom(@PathVariable String roomID) {

        if (roomID == null) {
            return null;
        }

        for (Room room : rooms) {
            if (room.getRoomID().equals(roomID)) {
                room.setStatus(false);
            }
        }
        return null;
    }


}
