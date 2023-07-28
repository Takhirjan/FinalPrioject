package bitlab.finalproject.StayHub.Controller;
import bitlab.finalproject.StayHub.Model.Booking;
import bitlab.finalproject.StayHub.Model.Hotels;
import bitlab.finalproject.StayHub.Model.Service;
import bitlab.finalproject.StayHub.Repository.BookingRepository;
import bitlab.finalproject.StayHub.Repository.ServiceRepository;
import bitlab.finalproject.StayHub.Service.BookingService;
import bitlab.finalproject.StayHub.Service.HotelService;
import bitlab.finalproject.StayHub.Service.ServicyService;
import bitlab.finalproject.StayHub.Service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDateTime;
import java.util.List;


@Controller
@RequiredArgsConstructor
public class BookingController {
  private final BookingService bookingService;
  private final HotelService hotelService;
  private final ServicyService servicyService;
  private final UserService userService;
  private final BookingRepository bookingRepository;

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
  @PostMapping(value = "/confirm")
  public String confirmBooking(Booking booking,Model model,Long id){
    bookingService.save(booking);
    model.addAttribute("booking",booking);


  List<Service> services=servicyService.getService();
  model.addAttribute("service",services);

    return "ConfirmationPage";
  }
}
