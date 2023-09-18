package bitlab.finalproject.StayHub.api;

import bitlab.finalproject.StayHub.DTO.UsersDTO;
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
  public List<UsersDTO> users(){
    return userService.getUser();
  }
  @GetMapping(value = "{id}")
  public UsersDTO getUser(@PathVariable(name="id") Long id){
    return userService.getUserByID(id);
  }
  @PostMapping
  public UsersDTO addHotel(@RequestBody UsersDTO users){
    return userService.addUser(users);
  }
  @PutMapping
  public UsersDTO updateHotel(@RequestBody UsersDTO users){
    return userService.updateUser(users);
  }
  @DeleteMapping(value = "{id}")
  public void deleteComment(@PathVariable(name = "id") Long id){
    userService.deleteUser(id);
  }

}

