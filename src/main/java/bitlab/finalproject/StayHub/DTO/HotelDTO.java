package bitlab.finalproject.StayHub.DTO;

import bitlab.finalproject.StayHub.Model.Hotels;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class HotelDTO extends Hotels {
  private Long id;
  private String title;
  private String description;
  private String price;
  private String rating;
  private String text;
  private String city;
  private String address;
  //упаковка дял фронта
}
