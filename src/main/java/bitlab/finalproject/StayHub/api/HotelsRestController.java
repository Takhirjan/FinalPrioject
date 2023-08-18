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
@RequestMapping(value = "/hotel")
public class HotelsRestController {
  private final HotelService hotelService;

  @GetMapping
  public List<HotelDTO> commentList(){
    return hotelService.getHotels();
  }
  @GetMapping(value = "{id}")
  public HotelDTO getHotel(@PathVariable(name="id") Long id){
    return hotelService.getHotelById(id);
  }
  @PostMapping
  public HotelDTO addHotel(@RequestBody HotelDTO hotels){
    return hotelService.addHotel(hotels);
  }
  @PutMapping
  public HotelDTO updateHotel(@RequestBody HotelDTO hotels){
    return hotelService.updateHotel(hotels);
  }
  @DeleteMapping(value = "{id}")
  public void deleteComment(@PathVariable(name = "id") Long id){
  hotelService.deleteHotel(id);
  }

}

