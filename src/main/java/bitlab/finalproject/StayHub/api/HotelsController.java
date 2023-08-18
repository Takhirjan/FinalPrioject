package bitlab.finalproject.StayHub.api;

import bitlab.finalproject.StayHub.DTO.HotelDTO;
import bitlab.finalproject.StayHub.Model.Comment;
import bitlab.finalproject.StayHub.Model.Hotels;
import bitlab.finalproject.StayHub.Service.CommentService;
import bitlab.finalproject.StayHub.Service.HotelService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/api/hotel")
public class HotelsController {
  private final HotelService hotelService;
  @GetMapping(value = "/get-all-hotels")
  public List<HotelDTO> getComment(){
    return hotelService.getHotels();
  }
  @PostMapping(value = "/add-hotel")
  public HotelDTO addComment(@RequestBody HotelDTO hotels) {
    return hotelService.addHotel(hotels);
  }
}
