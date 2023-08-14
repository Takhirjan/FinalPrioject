package bitlab.finalproject.StayHub.Service;

import bitlab.finalproject.StayHub.Model.Comment;
import bitlab.finalproject.StayHub.Repository.CommentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CommentService {
  private final CommentRepository commentRepository;


  public Comment addComment(Comment comment){
    return commentRepository.save(comment);
 }
  public List<Comment> getAllComments(){
    return commentRepository.findAll();
  }

public Comment getComment(Long id){
    return commentRepository.findById(id).orElse(null);
}
public Comment updateComment(Comment comment){
    return commentRepository.save(comment);
}
public void deleteComment(Long id){
commentRepository.deleteById(id);
}
}
