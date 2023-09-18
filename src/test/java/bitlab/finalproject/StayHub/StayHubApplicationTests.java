package bitlab.finalproject.StayHub;

import bitlab.finalproject.StayHub.DTO.HotelDTO;
import bitlab.finalproject.StayHub.Mapper.HotelMapper;
import bitlab.finalproject.StayHub.Model.Apartaments;
import bitlab.finalproject.StayHub.Model.Hotels;
import bitlab.finalproject.StayHub.Service.HotelService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class StayHubApplicationTests {
	@Autowired
	private HotelMapper hotelMapper;

	@Autowired
	private HotelService hotelService;
	@Test
	void checkHotelDto(){
		Hotels hotels=new Hotels();
		hotels.setId(1L);
		hotels.setName("DoubleTree");
		hotels.setAddress("44th St");
		hotels.setCity("New York");
		hotels.setDescription("qwer");
		hotels.setPrice("455");
		hotels.setRating("8");
		hotels.setText("qwert");   //Мне нужно проверить это сущность точно также передается в DTO

		HotelDTO hotelDTO=hotelMapper.toDTo(hotels);
		Assertions.assertEquals(hotels.getName(),hotelDTO.getHotelName());
		Assertions.assertEquals(hotels.getText(),hotelDTO.getText());
		Assertions.assertEquals(hotels.getPrice(),hotelDTO.getPrice());
		Assertions.assertEquals(hotels.getCity(),hotelDTO.getCity());
		Assertions.assertEquals(hotels.getRating(),hotelDTO.getRating());
		Assertions.assertEquals(hotels.getDescription(),hotelDTO.getDescription());
		Assertions.assertEquals(hotels.getId(),hotelDTO.getId());
	}
	@Test
	void checkInsertIntoDb(){
		Hotels hotels=new Hotels();
		hotels.setName("DoubleTree");
		hotels.setAddress("44th St");
		hotels.setCity("New York");
		hotels.setDescription("qwer");
		hotels.setPrice("455");
		hotels.setRating("8");
		hotels.setText("qwert");

		HotelDTO hotelDTO=hotelService.addHotel(hotelMapper.toDTo(hotels));
		Assertions.assertNotNull(hotelDTO);
		Assertions.assertNotNull(hotelDTO.getId());
		Assertions.assertNotNull(hotels.getName(), hotelDTO.getHotelName());
		Assertions.assertNotNull(hotels.getPrice(),hotelDTO.getPrice());
		Assertions.assertNotNull(hotels.getAddress(),hotelDTO.getAddress());
		Assertions.assertNotNull(hotels.getText(),hotelDTO.getText());
		Assertions.assertNotNull(hotels.getDescription(),hotelDTO.getDescription());
		Assertions.assertNotNull(hotels.getRating(),hotelDTO.getRating());
		Assertions.assertNotNull(hotels.getCity(),hotelDTO.getCity());

		hotelService.deleteHotel(hotels.getId());


	}
}

/*Unit test это проверка каждого метода */
