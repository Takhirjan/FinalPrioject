package bitlab.finalproject.StayHub.api;

import bitlab.finalproject.StayHub.Model.Comment;
import bitlab.finalproject.StayHub.Service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import java.util.List;
  @RestController
  @RequiredArgsConstructor
  @RequestMapping(value = "/api/comment")
  public class CommentsController {
  private final CommentService commentService;
  @GetMapping(value = "/get-all-comments")
  public List<Comment> getComment(){
    return commentService.getAllComments();
  }
  @PostMapping(value = "/add-comment")
    public Comment addComment(@RequestBody Comment comment) {
    return commentService.addComment(comment);
  }//это тело запроса который приходит от коиента Он тебе присылает ты его принимешь и пихаешь в базу
}
/* Вся конфигурация хранение базы и паролей то есть все настройки они будут в API
 * они бизнес логику не хранят этотпросто отоброзитили
 *
 * Тестим API с помощью POSTMAN*/