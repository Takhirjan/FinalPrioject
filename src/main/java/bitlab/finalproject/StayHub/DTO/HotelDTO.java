package bitlab.finalproject.StayHub.DTO;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class HotelDTO {
  private String name;
  private String description;
  private String price;
  private String rating;
  private String text;
  private String city;
  private String address;
  //упаковка дял фронта
}
