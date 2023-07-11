package bitlab.finalproject.StayHub.Model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Lob;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "t_apartaments")
public class Apartaments extends BaseModel{
  @Lob
  @Column(name = "image_data")
  private String images;

  @Column(name = "title")
  private String title;

  @Column(name = "amount")
  private Long amount;

}
