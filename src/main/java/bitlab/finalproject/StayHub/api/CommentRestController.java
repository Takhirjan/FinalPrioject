package bitlab.finalproject.StayHub.api;

import bitlab.finalproject.StayHub.Model.Comment;
import bitlab.finalproject.StayHub.Service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/comments")
public class CommentRestController {
  private final CommentService commentService;

  @GetMapping
  public List<Comment> commentList(){
    return commentService.getAllComments();
  }

  @GetMapping(value = "{id}")
  public Comment getCourse(@PathVariable(name="id") Long id){
    return commentService.getComment(id);
  }
  @PostMapping
  public Comment addComment(@RequestBody Comment comment){
    return commentService.addComment(comment);
  }
  @PutMapping
  public Comment updateComment(@RequestBody Comment comment){
    return commentService.updateComment(comment);
  }
  @DeleteMapping(value = "{id}")
  public void deleteComment(@PathVariable(name = "id") Long id){
  commentService.deleteComment(id);
  }

}

