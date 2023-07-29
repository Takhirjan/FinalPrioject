package bitlab.finalproject.StayHub.Controller;
import bitlab.finalproject.StayHub.Model.Booking;
import bitlab.finalproject.StayHub.Model.Hotels;
import bitlab.finalproject.StayHub.Model.Uslugi;
import bitlab.finalproject.StayHub.Service.BookingService;
import bitlab.finalproject.StayHub.Service.HotelService;
import bitlab.finalproject.StayHub.Service.UslugiService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@Controller
@RequiredArgsConstructor
public class BookingController {
  private final BookingService bookingService;
  private final HotelService hotelService;
  private final UslugiService servicyService;

//  @GetMapping(value = "/booking/{bookingId}")
//  public String createBookingPage(@PathVariable(name="bookingId")Long id,Model model){;
//    Hotels hotels=hotelService.getHotelById(id);
//    model.addAttribute("booking",hotels);
//
//    Service service = servicyService.getServiceById(id);
//
//    Booking booking = new Booking();
//    booking.setHotels(hotels);
//    booking.setService(service);
//    bookingRepository.save(booking);
//
//    List<Booking>bookings=bookingService.getBookings();
//    model.addAttribute("bookingModel",bookings);
//    return "ConfirmationPage";
//  }
  @GetMapping(value = "/confirm/{confirmId}")
  public String confirmBooking(@PathVariable(name = "confirmId") Long id,Booking booking, Model model){
    bookingService.save(booking);
    model.addAttribute("booking",booking);

    Uslugi services=servicyService.getServiceById(id);
   model.addAttribute("service",services);

    Booking bookings = bookingService.getBooking(id);
    model.addAttribute("book", bookings);

   Hotels hotels=hotelService.getHotelById(id);
   model.addAttribute("confirmHotel",hotels);



    return "ConfirmationPage";
  }
}
