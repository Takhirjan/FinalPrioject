package bitlab.finalproject.StayHub.api;

import bitlab.finalproject.StayHub.Model.Comment;
import bitlab.finalproject.StayHub.Service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/add")
@RequiredArgsConstructor
public class CommentModifyController {
private final CommentService commentService;

@PostMapping(value = "/comment")
  public Comment addComment(@RequestBody Comment comment) {
   return commentService.addComment(comment);
  }
}
