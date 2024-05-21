package com.AgilePeople.project.service.impl;
//import lombok.AllArgsConstructor;
import com.AgilePeople.project.entity.Hotel;
import com.AgilePeople.project.repository.HotelRepository;
import com.AgilePeople.project.service.HotelService;
import org.apache.logging.log4j.util.Strings;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
//@AllArgsConstructor
public class HotelServiceImpl implements HotelService {
    @Autowired
    private HotelRepository hotelRepository;

    @Override
    public Hotel createHotel(Hotel hotel) {
        return hotelRepository.save(hotel);
    }

    @Override
    public Hotel getHotelById(Long hotelId) {
        Optional<Hotel> optionalHotel = hotelRepository.findById(hotelId);
        return optionalHotel.get();
    }

    @Override
    public List<Hotel> getAllHotel() {
        return hotelRepository.findAll();
    }

    @Override
    public Hotel updateHotel(@NotNull Hotel hotel) {
        Hotel existingHotel = hotelRepository.findById(hotel.getId()).get();
        existingHotel.setName(hotel.getName());
        existingHotel.setTagline(hotel.getTagline());
        existingHotel.setCity(hotel.getCity());
        existingHotel.setDescription(hotel.getDescription());
        existingHotel.setAddress(hotel.getAddress());
        existingHotel.setEmail(hotel.getEmail());
        existingHotel.setContact(hotel.getContact());
        existingHotel.setEmail1(hotel.getEmail1());
        existingHotel.setContact1(hotel.getContact1());
        Hotel updatedHotel = hotelRepository.save(existingHotel);
        return updatedHotel;
    }

    @Override
    public void deleteHotel(Long hotelId) {
        hotelRepository.deleteById(hotelId);
    }

    public HotelServiceImpl(HotelRepository hotelRepository) {
        this.hotelRepository = hotelRepository;
    }
}
