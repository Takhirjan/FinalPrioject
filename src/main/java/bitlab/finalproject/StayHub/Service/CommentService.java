package bitlab.finalproject.StayHub.Service;

import bitlab.finalproject.StayHub.Model.Comment;
import bitlab.finalproject.StayHub.Model.Hotels;
import bitlab.finalproject.StayHub.Repository.CommentRepository;
import bitlab.finalproject.StayHub.Repository.HotelRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CommentService {
  private final CommentRepository commentRepository;
  private final UserService userService;
  private final HotelRepository hotelRepository;

  public void addComment(Comment comment){
    commentRepository.save(comment);
 }
  public List<Comment> getAllComments(){
    return commentRepository.findAll();
  }
}
