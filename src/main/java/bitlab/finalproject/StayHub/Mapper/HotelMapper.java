package bitlab.finalproject.StayHub.Mapper;

import bitlab.finalproject.StayHub.DTO.HotelDTO;
import bitlab.finalproject.StayHub.Model.Hotels;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring") //Когда мы пишем componentModel он HotelMapper превращает в бин и модно спокойно его автоварить
public interface HotelMapper {
  HotelDTO toDTo(Hotels hotels);
  Hotels toDTO(HotelDTO hotelDTO);
  List<HotelDTO>  toDtoList(List<Hotels> hotelsList);
  List<Hotels> toModelList(List<HotelDTO> hotelDTOListe);
}
