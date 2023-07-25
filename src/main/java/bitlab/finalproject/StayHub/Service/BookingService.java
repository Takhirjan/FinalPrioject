package bitlab.finalproject.StayHub.Service;
import bitlab.finalproject.StayHub.Model.Booking;
import bitlab.finalproject.StayHub.Repository.BookingRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BookingService {
  private final BookingRepository bookingRepository;
  public Booking addBooking(Booking booking){
    return bookingRepository.save(booking);
  }
public List<Booking>getBookings(){
return bookingRepository.findAll();
}

}
