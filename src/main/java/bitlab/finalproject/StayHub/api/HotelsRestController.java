package bitlab.finalproject.StayHub.api;

import bitlab.finalproject.StayHub.Model.Comment;
import bitlab.finalproject.StayHub.Model.Hotels;
import bitlab.finalproject.StayHub.Service.CommentService;
import bitlab.finalproject.StayHub.Service.HotelService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/hotels")
public class HotelsRestController {
  private final HotelService hotelService;

  @GetMapping
  public List<Hotels> commentList(){
    return hotelService.getHotels();
  }
  @GetMapping(value = "{id}")
  public Hotels getHotel(@PathVariable(name="id") Long id){
    return hotelService.getHotelById(id);
  }
  @PostMapping
  public Hotels addHotel(@RequestBody Hotels hotels){
    return hotelService.addHotel(hotels);
  }
  @PutMapping
  public Hotels updateHotel(@RequestBody Hotels hotels){
    return hotelService.updateHotel(hotels);
  }
  @DeleteMapping(value = "{id}")
  public void deleteComment(@PathVariable(name = "id") Long id){
  hotelService.deleteHotel(id);
  }

}

