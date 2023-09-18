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


  /*Здесь метод toDtoList используется для преобразования списка моделей Hotels в список DTO HotelDTO при получении
  данных из базы данных, а метод toModel используется для преобразования DTO HotelDTO
  в модель Hotels при создании новой записи в базе данных.*/


  /*Метод toModelList (или аналогичные методы для преобразования) полезен в следующих случаях:

Преобразование данных для работы с базой данных: Когда вы получаете данные от клиента, они могут быть в формате
 DTO (Data Transfer Object), но для сохранения в базе данных, вам нужно преобразовать их в модели (сущности) данных.
  Этот метод помогает вам выполнить это преобразование.

Обратное преобразование для отображения данных: После того как данные были извлечены из
 базы данных в виде моделей, вы можете использовать подобный метод для преобразования их
 обратно в DTO для передачи клиенту. Это позволяет изолировать слой доступа к данным от
 слоя представления и обеспечивает более чистый и гибкий код.*/
}
