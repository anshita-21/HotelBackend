package com.AgilePeople.project.controller;

import com.AgilePeople.project.entity.Hotel;
import com.AgilePeople.project.pojo.ResponsePojo;
import com.AgilePeople.project.service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin
@RestController
//@AllArgsConstructor
@RequestMapping("api/hotel")
public class HotelController {
    @Autowired
    private HotelService hotelService;

    // build create User REST API
    @PostMapping
    public ResponseEntity<ResponsePojo> createHotel(@RequestBody Hotel hotel){
        String errorMsg = "";
        ResponsePojo responsePojo = null;
        if( hotel!= null)
        {
            if(hotel.getName() == null || hotel.getName().equals("")) {
                errorMsg = "Hotel name is missing!";
                responsePojo = new ResponsePojo();
                responsePojo.setError(true);
                responsePojo.setErrorMessage(errorMsg);
            }
            else {
                Hotel hotelData = hotelService.createHotel(hotel);
                responsePojo = new ResponsePojo();
                responsePojo.setSuccess(true);
                responsePojo.setData(hotelData);
            }
        }
        return new ResponseEntity<>(responsePojo, HttpStatus.CREATED);
    }

    @GetMapping("{id}")
    public ResponseEntity<Hotel> getHotelById(@PathVariable("id") Long hotelId){
        Hotel hotel = hotelService.getHotelById(hotelId);
        return new ResponseEntity<>(hotel, HttpStatus.OK);
    }


    @GetMapping
    public ResponseEntity<List<Hotel>> getAllHotel(){
        List<Hotel> hotel = hotelService.getAllHotel();
        return new ResponseEntity<>(hotel, HttpStatus.OK);
    }


    @PutMapping("{id}")

    public ResponseEntity<Hotel> updateHotel(@PathVariable("id") Long hotelId,
                                           @RequestBody Hotel hotel){
        hotel.setId(hotelId);
        Hotel updatedHotel = hotelService.updateHotel(hotel);
        return new ResponseEntity<>(updatedHotel, HttpStatus.OK);
    }


    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteHotel(@PathVariable("id") Long hotelId){
        hotelService.deleteHotel(hotelId);
        return new ResponseEntity<>("Hotel successfully deleted!", HttpStatus.OK);
    }

    public HotelController(HotelService hotelService) {
        this.hotelService = hotelService;
    }
}