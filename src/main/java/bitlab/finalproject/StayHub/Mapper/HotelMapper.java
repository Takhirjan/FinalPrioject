package bitlab.finalproject.StayHub.Mapper;

import bitlab.finalproject.StayHub.DTO.HotelDTO;
import bitlab.finalproject.StayHub.Model.Hotels;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring") //Когда мы пишем componentModel он HotelMapper превращает в бин и модно спокойно его автоварить
public interface HotelMapper {
  @Mapping(source = "name", target = "title")
  HotelDTO toDTo(Hotels hotels);
  @Mapping(source="title",target="name")
  Hotels toModel(HotelDTO hotelDTO);
  List<HotelDTO>  toDtoList(List<Hotels> hotelsList);
  List<Hotels> toModelList(List<HotelDTO> hotelDTOList);
}
