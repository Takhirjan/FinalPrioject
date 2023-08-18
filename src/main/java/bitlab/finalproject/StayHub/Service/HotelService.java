package bitlab.finalproject.StayHub.Service;

import bitlab.finalproject.StayHub.DTO.HotelDTO;
import bitlab.finalproject.StayHub.Mapper.HotelMapper;
import bitlab.finalproject.StayHub.Model.Booking;
import bitlab.finalproject.StayHub.Model.Hotels;
import bitlab.finalproject.StayHub.Repository.BookingRepository;
import bitlab.finalproject.StayHub.Repository.HotelRepository;
import bitlab.finalproject.StayHub.Repository.ServiceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class HotelService {
  private final HotelRepository hotelRepository;
  private final BookingRepository bookingRepository;
  private final HotelMapper hotelMapper;

  public List<HotelDTO> getHotels(){
  return hotelMapper.toDtoList(hotelRepository.findAll());
}
  public HotelDTO getHotelById(Long id){
    return hotelMapper.toDTo(hotelRepository.findById(id).orElse(null));
  }

  public Booking getBookingById(Long id){
  return bookingRepository.findById(id).orElse(null);
  }

  public int  getHotelCount(){
    List<Hotels> hotels=hotelRepository.findAll();
    return hotels.size();
  }
  public HotelDTO addHotel(HotelDTO newHotel){
    return hotelMapper.toDTo(hotelRepository.save(hotelMapper.toModel(newHotel)));
  }

  public void deleteHotel(Long id){
  hotelRepository.deleteById(id);
  }
  public  Hotels saveHotel(Hotels hotels){
    return hotelRepository.save(hotels);
  }

  public HotelDTO updateHotel(HotelDTO hotels){
    return hotelMapper.toDTo(hotelRepository.save(hotelMapper.toModel(hotels)));
  }

  }
