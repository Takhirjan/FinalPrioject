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
    return bookingRepository.save(booking);
  }

}
