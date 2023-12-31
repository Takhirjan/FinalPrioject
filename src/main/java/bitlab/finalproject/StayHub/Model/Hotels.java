package bitlab.finalproject.StayHub.Model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "t_hotels")
@Getter
@Setter
public class Hotels extends BaseModel {
  @Column(name = "name")
  private String name;

  @Column(name = "description", columnDefinition = "TEXT")
  private String description;

  @Column(name = "price")
  private String price;

  @Column(name = "rating")
  private String rating;

  @Column(name = "text", columnDefinition = "TEXT", length = 500)
  private String text;

  @Column(name = "city")
  private String city;

  @Column(name = "address")
  private String address;



}


