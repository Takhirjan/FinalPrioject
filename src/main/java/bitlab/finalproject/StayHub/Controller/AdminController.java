package bitlab.finalproject.StayHub.Controller;

import bitlab.finalproject.StayHub.Model.Apartaments;
import bitlab.finalproject.StayHub.Model.Hotels;
import bitlab.finalproject.StayHub.Repository.ApartmentsRepository;
import bitlab.finalproject.StayHub.Repository.HotelRepository;
import bitlab.finalproject.StayHub.Service.AparmtentsService;
import bitlab.finalproject.StayHub.Service.HotelService;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.apache.tomcat.util.http.fileupload.FileUpload;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.thymeleaf.util.StringUtils;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.SQLException;
import java.util.List;

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
  return "details";
}
}
