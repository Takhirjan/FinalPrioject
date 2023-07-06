package bitlab.finalproject.StayHub.Controller;

import bitlab.finalproject.StayHub.Model.Users;
import bitlab.finalproject.StayHub.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController {
  @Autowired
  UserService userService;
  @GetMapping(value = "/sign-in-page")
  public String mainPage(){
    return "sign-in-page";
  }
  @PreAuthorize("isAuthenticated()")
  @GetMapping(value = "/")
  public String MainPage(){
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
}
