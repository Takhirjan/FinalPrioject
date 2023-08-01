package bitlab.finalproject.StayHub.Service;
import bitlab.finalproject.StayHub.Model.Booking;
import bitlab.finalproject.StayHub.Repository.BookingRepository;
import bitlab.finalproject.StayHub.Repository.ServiceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BookingService {
  private final BookingRepository bookingRepository;

  public Booking save(Booking booking){
//    if (bookingRepository.existsByDateTimeAndUslugiModel(booking.getDateTime(), booking.getUslugiModel())) {
//      throw new IllegalArgumentException("Бронирование с такой же датой и услугой уже существует.");
//    }
    return bookingRepository.save(booking);
  }

  public Booking getBooking(Long id){
    return bookingRepository.findById(id).orElse(null);
  }

  public List <Booking> getBook(){
    return bookingRepository.findAll();
  }
}
