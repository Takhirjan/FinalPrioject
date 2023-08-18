package bitlab.finalproject.StayHub.api;

import bitlab.finalproject.StayHub.DTO.HotelDTO;
import bitlab.finalproject.StayHub.Model.Comment;
import bitlab.finalproject.StayHub.Model.Hotels;
import bitlab.finalproject.StayHub.Service.CommentService;
import bitlab.finalproject.StayHub.Service.HotelService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/add")
@RequiredArgsConstructor
public class HotelsModifyController {
private final HotelService hotelService;

@PostMapping(value = "/hotel")
  public HotelDTO addHotel(@RequestBody HotelDTO hotels) {
   return hotelService.addHotel(hotels);
  }
}
