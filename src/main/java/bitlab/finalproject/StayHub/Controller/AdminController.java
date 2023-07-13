package bitlab.finalproject.StayHub.Controller;

import bitlab.finalproject.StayHub.Model.Hotels;
import bitlab.finalproject.StayHub.Service.HotelService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
@Controller
@RequiredArgsConstructor
public class AdminController {
  private final HotelService hotelService;
  @PreAuthorize("hasAnyRole('ROLE_ADMIN')")
  @GetMapping(value = "/admin-panel")
  public String adminPanel(Model model){
    return "admin";
  }
  @PostMapping(value = "/add-hotel")
  public String addHotel(Hotels hotels){
    hotelService.addHotel(hotels);
    return "redirect:/";
  }
  @GetMapping(value = "/add-hotel")
  public String addHotelPage(Model model){
    return "addHotel";
  }
}
