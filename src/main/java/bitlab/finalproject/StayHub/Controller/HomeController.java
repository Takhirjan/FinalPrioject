package bitlab.finalproject.StayHub.Controller;
import bitlab.finalproject.StayHub.DTO.HotelDTO;
import bitlab.finalproject.StayHub.DTO.UsersDTO;
import bitlab.finalproject.StayHub.Model.*;
import bitlab.finalproject.StayHub.Repository.ApartmentsRepository;
import bitlab.finalproject.StayHub.Repository.HotelRepository;
import bitlab.finalproject.StayHub.Service.CommentService;
import bitlab.finalproject.StayHub.Service.HotelService;
import bitlab.finalproject.StayHub.Service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;


@Controller
@RequiredArgsConstructor
public class HomeController {
  private final UserService userService;
  private final HotelService hotelService;
  private final ApartmentsRepository apartmentsRepository;
  private final HotelRepository hotelRepository;

  @GetMapping(value = "/hotels/{hotelId}")
  public String getHotelsPage(@PathVariable(name = "hotelId") Long id, Model model) {
    HotelDTO hotels = hotelService.getHotelById(id);
    model.addAttribute("hotel", hotels);
    List<Hotels> hotelsList = hotelRepository.findAll();
    model.addAttribute("hotels", hotelsList);
    return "hotels";
  }

  @GetMapping(value = "/sign-in-page")
  public String mainPage() {
    return "sign-in-page";
  }

  @GetMapping(value = "/")
  public String MainPage(Model model) {
    List<Apartaments> apartaments = apartmentsRepository.findAll();
    model.addAttribute("apartments", apartaments);

    int hotelCount = hotelService.getHotelCount();
    model.addAttribute("hotelCount", hotelCount);


    return "MainPage";
  }

  @PostMapping(value = "/to-sign-up")
  public String toSignUp(@RequestParam(name = "user_email") String email,
                         @RequestParam(name = "user_password") String password,
                         @RequestParam(name = "user_repeat_password") String repeatPassword,
                         @RequestParam(name = "user_full_name") String fullName) {
    if (password.equals(repeatPassword)) {
      UsersDTO user = new UsersDTO();
      user.setMail(email);
      user.setFullName(fullName);
      user.setPassword(password);
      UsersDTO newUser = userService.addUser(user);
      if (newUser != null) {
        return "redirect:/sign-in-page?success";
      } else {
        return "redirect:/sign-in-page?emailerror";
      }
    } else {
      return "redirect:/sign-in-page?passwordError";
    }
  }

  @PostMapping(value = "/to-update-password")
  public String updatePassword(
      @RequestParam(name = "user_old_password") String oldPassword,
      @RequestParam(name = "user_new_password") String newPassword,
      @RequestParam(name = "user_repeat_new_password") String repeatNewPassword) {

    if (newPassword.equals(repeatNewPassword)) {
      UsersDTO users = userService.updatePassword(newPassword, oldPassword);
      if (users != null) {
        return "redirect:/update-password-page?success";
      } else {
        return "redirect:/update-password-page?oldpassworderror";
      }

    } else {
      return "redirect:/update-password-page?passwordmismatch";
    }
  }

  @PreAuthorize("isAuthenticated()")
  @GetMapping(value = "/update-password-page")
  public String updatePage() {
    return "update-password";
  }

  @GetMapping(value = "/403-page")
  public String accessDenied() {
    return "access-denied-page-403";
  }
}



