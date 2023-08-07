package bitlab.finalproject.StayHub.Controller;
import bitlab.finalproject.StayHub.Model.Hotels;
import bitlab.finalproject.StayHub.Model.Uslugi;
import bitlab.finalproject.StayHub.Repository.ServiceRepository;
import bitlab.finalproject.StayHub.Service.HotelService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@Controller
@RequiredArgsConstructor
public class AdminController {
  private final HotelService hotelService;
  private final ServiceRepository serviceRepository;


  @PreAuthorize("hasAnyRole('ROLE_ADMIN')")
  @GetMapping(value = "/admin-panel")
  public String adminPanel(Model model){
    return "admin";
  }
  @PreAuthorize("hasAnyRole('ROLE_ADMIN')")
  @PostMapping(value = "/add-hotel")
  public String addHotel( Hotels hotels) {
    hotelService.addHotel(hotels);
    return "redirect:/";
  }
  @GetMapping(value = "/details/{hotelId}")
  public String hotelsDetails(@PathVariable(name = "hotelId")Long id, Model model){

    Hotels hotels=hotelService.getHotelById(id);
    model.addAttribute("otel", hotels);

    List<Hotels> hotelsList=hotelService.getHotels();
    model.addAttribute("hotel",hotelsList);

    List<Uslugi> services=serviceRepository.findAll();
    model.addAttribute("service",services);

    return "details";
  }
  @PreAuthorize("hasAnyRole('ROLE_ADMIN')")
  @PostMapping(value = "/delete-hotel")
  public String deleteHotel(@RequestParam(name = "id") Long id){
    hotelService.deleteHotel(id);
    return "redirect:/hotels/"+id;
  }
  @PreAuthorize("hasAnyRole('ROLE_ADMIN')")
  @PostMapping(value = "/edit-hotel-data")
  public String saveHotel(Hotels hotels) {
    hotelService.saveHotel(hotels);
    return "redirect:/details/" + hotels.getId();
  }
  @PreAuthorize("hasAnyRole('ROLE_ADMIN')")
  @GetMapping(value = "/edit-hotel-data")
  public String editHotelPage(Model model){
    model.addAttribute("otel",hotelService.getHotels());
    return "redirect:/details";
  }
  @PreAuthorize("hasAnyRole('ROLE_ADMIN')")
  @GetMapping(value = "/editHotel/{id}")
  public String EditPage(@PathVariable(name = "id")Long id,Model model){
    Hotels hotels=hotelService.getHotelById(id);
    model.addAttribute("otel",hotels);
    return "EditPage";
  }


}
