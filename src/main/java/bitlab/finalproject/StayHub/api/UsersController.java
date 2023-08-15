package bitlab.finalproject.StayHub.api;

import bitlab.finalproject.StayHub.Model.Comment;
import bitlab.finalproject.StayHub.Model.Users;
import bitlab.finalproject.StayHub.Service.CommentService;
import bitlab.finalproject.StayHub.Service.UserService;
import lombok.RequiredArgsConstructor;
import org.apache.catalina.User;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/api/users")
public class UsersController {
  private final UserService userService;
  @GetMapping(value = "/get-all-users")
  public List<Users> getUser(){
    return userService.getUser();
  }
  @PostMapping(value = "/add-user")
  public Users addUser(@RequestBody Users users) {
    return userService.addUser(users);
  }
  @DeleteMapping(value = "{id}")
  public void deleteUser(@PathVariable(name = "id") Long id){
    userService.deleteUser(id);
  }
  @PutMapping
  public Users updateUser(@RequestBody Users users){
    return userService.updateUser(users);
  }
}
