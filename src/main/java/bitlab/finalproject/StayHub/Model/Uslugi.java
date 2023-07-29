package bitlab.finalproject.StayHub.Model;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "t_service")
@Getter
@Setter
public class Uslugi extends BaseModel{
  @Column(name = "service_name")
  private String ServiceName;

  @Column(name = "HasOptions")
  boolean hasOptions;

  @ManyToOne
  private Booking booking;

}

