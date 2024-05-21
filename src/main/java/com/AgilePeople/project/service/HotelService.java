package com.AgilePeople.project.service;

import com.AgilePeople.project.entity.Hotel;

import java.util.List;

public interface HotelService {
    Hotel createHotel(Hotel hotel);

    Hotel getHotelById(Long hotelId);

    List<Hotel> getAllHotel();

    Hotel updateHotel(Hotel hotel);

    void deleteHotel(Long hotelId);
}