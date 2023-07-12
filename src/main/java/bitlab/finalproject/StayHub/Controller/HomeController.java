package bitlab.finalproject.StayHub.Controller;

import bitlab.finalproject.StayHub.Model.Apartaments;
import bitlab.finalproject.StayHub.Model.Hotels;
import bitlab.finalproject.StayHub.Model.Users;
import bitlab.finalproject.StayHub.Repository.ApartmentsRepository;
import bitlab.finalproject.StayHub.Repository.HotelRepository;
import bitlab.finalproject.StayHub.Service.AparmtentsService;
import bitlab.finalproject.StayHub.Service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.data.jpa.domain.AbstractPersistable_.id;

@Controller
@RequiredArgsConstructor
public class HomeController {
 private final UserService userService;
  private final AparmtentsService aparmtentsService;
  private final HotelRepository hotelRepository;


@GetMapping(value = "/hotel/us")
public String getHotelsPage(Model model){
  List<Hotels> hotels=new
}
  @GetMapping(value = "/sign-in-page")
  public String mainPage(){
    return "sign-in-page";
  }

  @GetMapping(value = "/")
  public String MainPage( Model model){
    model.addAttribute("apartments", aparmtentsService.getApartaments());
    return "MainPage";
  }

  @PostMapping(value = "/to-sign-up")
  public String toSignUp(@RequestParam(name = "user_email") String email,
                         @RequestParam(name = "user_password") String password,
                         @RequestParam(name = "user_repeat_password") String repeatPassword,
                         @RequestParam(name = "user_full_name") String fullName) {
    if (password.equals(repeatPassword)) {
      Users user = new Users();
      user.setEmail(email);
      user.setFullName(fullName);
      user.setPassword(password);
      Users newUser = userService.addUser(user);
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
      Users users = userService.updatePassword(newPassword, oldPassword);
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
  public String updatePage(){
    return "update-password";
  }
}
