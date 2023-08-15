package bitlab.finalproject.StayHub.api;

import bitlab.finalproject.StayHub.Model.Hotels;
import bitlab.finalproject.StayHub.Model.Users;
import bitlab.finalproject.StayHub.Service.HotelService;
import bitlab.finalproject.StayHub.Service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/users")
public class UsersRestController {
  private final UserService userService;

  @GetMapping
  public List<Users> users(){
    return userService.getUser();
  }
  @GetMapping(value = "{id}")
  public Users getUser(@PathVariable(name="id") Long id){
    return userService.getUserByID(id);
  }
  @PostMapping
  public Users addHotel(@RequestBody Users users){
    return userService.addUser(users);
  }
  @PutMapping
  public Users updateHotel(@RequestBody Users users){
    return userService.updateUser(users);
  }
  @DeleteMapping(value = "{id}")
  public void deleteComment(@PathVariable(name = "id") Long id){
    userService.deleteUser(id);
  }

}

