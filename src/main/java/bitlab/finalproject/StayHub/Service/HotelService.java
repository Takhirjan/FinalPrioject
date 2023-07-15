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
public List<Hotels> getHotels(){
  return hotelRepository.findAll();
}
  public Hotels getHotelById(Long id){
    return hotelRepository.findById(id).orElse(null);
  }

  public int  getHotelCount(){
    List<Hotels> hotels=hotelRepository.findAll();
    return hotels.size();
  }
  public Hotels addHotel(Hotels newHotel){
    return hotelRepository.save(newHotel);
  }
}
