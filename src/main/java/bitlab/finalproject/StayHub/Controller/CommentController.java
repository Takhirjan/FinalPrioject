package bitlab.finalproject.StayHub.Controller;

import bitlab.finalproject.StayHub.DTO.HotelDTO;
import bitlab.finalproject.StayHub.Model.Comment;
import bitlab.finalproject.StayHub.Model.Hotels;
import bitlab.finalproject.StayHub.Model.Users;
import bitlab.finalproject.StayHub.Service.CommentService;
import bitlab.finalproject.StayHub.Service.HotelService;
import bitlab.finalproject.StayHub.Service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDateTime;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class CommentController {
  private final CommentService commentService;
  private final HotelService hotelService;
  private final UserService userService;

/* этот метод обрабатывает запрос на добавление комментария
 к определенному отелю. Он извлекает информацию об отеле
 по его идентификатору, создает объект комментария с
 указанными данными (текстом, датой и временем) и
 связывает его с отелем, а затем передает его
 в сервис для дальнейшей обработки.

 */
@PreAuthorize("isAuthenticated()")
@PostMapping(value = "/add-comment")
  public String addComment(@ModelAttribute Comment comment,
                           @RequestParam("hotel.id") Long hotelId){

  HotelDTO hotel = hotelService.getHotelById(hotelId);
  comment.setHotel(hotel);
  comment.setDateTime(LocalDateTime.now()); // Устанавливаем текущую дату и время
  commentService.addComment(comment);

  return "redirect:/details/"+hotelId;
  }
  @GetMapping(value = "/addComment")
  public String addCommentPage( Model model){
    return "details";
  }
}
