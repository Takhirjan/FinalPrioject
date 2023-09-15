package bitlab.finalproject.StayHub.Mapper;
import bitlab.finalproject.StayHub.DTO.HotelDTO;
import bitlab.finalproject.StayHub.Model.Hotels;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import java.util.List;

@Mapper(componentModel = "spring")
public interface HotelMapper {
  @Mapping(source = "name", target = "hotelName")
  HotelDTO toDTo(Hotels hotels);

  @Mapping(source = "hotelName", target = "name")
  Hotels toModel(HotelDTO hotelDTO);

  List<HotelDTO> toDtoList(List<Hotels> hotelsList);
  List<Hotels> toModelList(List<HotelDTO> hotelList);
}
