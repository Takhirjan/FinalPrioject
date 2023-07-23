package bitlab.finalproject.StayHub.Service;
import bitlab.finalproject.StayHub.Model.Booking;
import bitlab.finalproject.StayHub.Repository.BookingRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.awt.print.Book;
import java.util.List;

@Service
@RequiredArgsConstructor
public class BookingService {
  private final BookingRepository bookingRepository;
  public List<Booking> getAllBookings() {
    return bookingRepository.findAll();
  }
  public Booking addBooking(Booking booking){
    return bookingRepository.save(booking);
  }
}
