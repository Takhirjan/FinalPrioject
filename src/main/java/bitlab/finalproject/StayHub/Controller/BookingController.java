package bitlab.finalproject.StayHub.Controller;
import bitlab.finalproject.StayHub.Model.Booking;
import bitlab.finalproject.StayHub.Model.Hotels;
import bitlab.finalproject.StayHub.Model.Uslugi;
import bitlab.finalproject.StayHub.Service.BookingService;
import bitlab.finalproject.StayHub.Service.HotelService;
import bitlab.finalproject.StayHub.Service.UslugiService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class BookingController {
  private final BookingService bookingService;
  private final HotelService hotelService;
  private final UslugiService uslugiService;

  @PreAuthorize("isAuthenticated()")
  @PostMapping(value = "/confirm/{confirmId}")
  public String confirmBooking(@PathVariable(name = "confirmId") Long id,Booking booking, Model model){
    bookingService.save(booking);
    model.addAttribute("booking",booking);

    List<Uslugi> uslugi= uslugiService.getService();
    model.addAttribute("uslugi",uslugi);

    List<Booking> bookingList=bookingService.getBook();
    model.addAttribute("book", bookingList);

   Hotels hotels=hotelService.getHotelById(id);
   model.addAttribute("confirmHotel",hotels);

    return "ConfirmationPage";
  }
}
