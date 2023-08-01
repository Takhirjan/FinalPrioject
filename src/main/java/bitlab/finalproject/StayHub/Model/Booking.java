package bitlab.finalproject.StayHub.Model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;


@Entity
@Table(name = "t_bookings")
@Getter
@Setter
public class Booking extends BaseModel{

  @Column(name = "time")
  private LocalDateTime dateTime;
}
