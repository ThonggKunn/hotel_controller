package com.example.rewebdemo.service;

import com.example.rewebdemo.Entity.Room;
import com.example.rewebdemo.dto.CreateRoomRequest;
import com.example.rewebdemo.dto.Responsedto;
import com.example.rewebdemo.dto.UpdateRoomRequest;
import com.example.rewebdemo.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoomService {

    @Autowired
    RoomRepository roomRepository;

    public Room getRoomById(Long Id) {
        return roomRepository.findByRoomId(Id);
    }

    public Room createRoom(CreateRoomRequest request) {
        Room room = new Room();
        room.setRoomType(request.getRoomType());
        room.setRoomType(request.getRoomType());

        room = roomRepository.save(room);
        return room;
    }

    public List<Room> getAll() {
        return roomRepository.findAll();
    }

    public Room updateRoom(Long roomId, UpdateRoomRequest request) {
        Room room = roomRepository.findByRoomId(roomId);
        if (room == null) {
            return null;
        }

        room.setRoomID(request.getRoomID());
        return room;
    }

    public Responsedto disableRoom(Long roomId) {
        Room room = roomRepository.findByRoomId(roomId);
        if (room == null) {
            return new Responsedto(false, "Not Found");
        }
        room.setStatus(false);
        room = roomRepository.save(room);
        return new Responsedto(true,"Done");
    }
}
