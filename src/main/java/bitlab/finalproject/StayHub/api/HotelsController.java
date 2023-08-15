package bitlab.finalproject.StayHub.api;

import bitlab.finalproject.StayHub.Model.Comment;
import bitlab.finalproject.StayHub.Service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/api/hotel")
public class HotelsController {
  private final CommentService commentService;
  @GetMapping(value = "/get-all-hotels")
  public List<Comment> getComment(){
    return commentService.getAllComments();
  }
  @PostMapping(value = "/add-hotel")
  public Comment addComment(@RequestBody Comment comment) {
    return commentService.addComment(comment);
  }
}
