package bitlab.finalproject.StayHub.DTO;

import bitlab.finalproject.StayHub.Model.Hotels;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class HotelDTO{
  private Long id;
  private String hotelName;
  private String description;
  private String price;
  private String rating;
  private String text;
  private String city;
  private String address;
  //упаковка дял фронта

  // Если фронтендер говорит давай изменим target in CourseMapper то мы берем и изменям его в CourseDTO а там у же все что
// горит красным изменяем
}
