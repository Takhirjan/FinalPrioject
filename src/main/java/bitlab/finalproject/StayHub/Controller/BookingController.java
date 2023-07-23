package bitlab.finalproject.StayHub.Controller;
import bitlab.finalproject.StayHub.Model.Booking;
import bitlab.finalproject.StayHub.Repository.BookingRepository;
import bitlab.finalproject.StayHub.Repository.ServiceRepository;
import bitlab.finalproject.StayHub.Service.BookingService;
import bitlab.finalproject.StayHub.Service.HotelService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
@RequiredArgsConstructor
public class BookingController {
  private final BookingService bookingService;
  private final HotelService hotelService;

  @PostMapping(value = "/booking")
  public String createBooking(Booking booking){
    bookingService.addBooking(booking);
    return "redirect:/";
  }
  @GetMapping(value = "/booking/{bookingId}")
  public String createBookingPage(@PathVariable(name = "bookingId") Model model, Long bookingId){
    Booking booking = hotelService.getBookingById(bookingId);
    model.addAttribute("booking", booking);
    return "ConfirmationPage";
  }
}
