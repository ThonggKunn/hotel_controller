package com.example.rewebdemo.repository;

import com.example.rewebdemo.Entity.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoomRepository extends JpaRepository<Room, Long>{

    Room findByRoomName(String RoomName);

    Room findByRoomId(Long Id);

}
