package bitlab.finalproject.StayHub.Model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "t_comments")
@Getter
@Setter
public class Comment extends BaseModel{
  @Column(name = "comment")
  private String text;

  @Column(name = "post_date")
  private LocalDateTime dateTime;

  @ManyToOne
  private Hotels hotel;

  @ManyToOne
  private Users users;

}
