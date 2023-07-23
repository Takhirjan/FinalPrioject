package bitlab.finalproject.StayHub.Model;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "t_service")
@Getter
@Setter
public class Service extends BaseModel{
  @Column(name = "service_name")
  private String ServiceName;

  @Column(name = "HasOptions")
  boolean hasOptions;

  @ManyToMany(fetch = FetchType.EAGER)
 private List<Booking> bookings;
}

