package bitlab.finalproject.StayHub.Mapper;
import bitlab.finalproject.StayHub.DTO.UsersDTO;
import bitlab.finalproject.StayHub.Model.Users;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UsersMapper {
  @Mapping(source = "email", target = "mail")
  UsersDTO toDTo(Users users);
  @Mapping(source = "mail",target = "email")
  Users toModel(UsersDTO usersDTO);

  List<UsersDTO> toDtoList(List<Users> usersList);
  List<Users> toModelList(List<UsersDTO> usersDTOList);

  /*предназначен для преобразования
   списка объектов класса Users в список объектов класса UsersDTO. */

  /*Аннотация @Mapping является частью библиотеки MapStruct,
  которая облегчает преобразование объектов Java из одного типа
  в другой, включая преобразование объектов DTO (Data Transfer Object)
  в сущности (entity) и наоборот. В данном случае,
   метод с аннотацией @Mapping выполняет преобразование
    объекта класса UsersDTO в объект класса Users.*/

  /*
  source = "mail" указывает, что поле mail в
  объекте UsersDTO будет источником данных для преобразования.
target = "email" указывает, что данные из
 поля mail будут присвоены полю email в объекте Users.*/
}
