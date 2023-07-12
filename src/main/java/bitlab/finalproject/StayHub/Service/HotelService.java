package bitlab.finalproject.StayHub.Service;

import bitlab.finalproject.StayHub.Model.Hotels;
import bitlab.finalproject.StayHub.Repository.HotelRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class HotelService {
private final HotelRepository hotelRepository;
public List<Hotels> getAllHotels(){
  return hotelRepository.findAll();
}
public int  getHotelCount(){
  List<Hotels> hotels=hotelRepository.findAll();
  return hotels.size();
}
}
