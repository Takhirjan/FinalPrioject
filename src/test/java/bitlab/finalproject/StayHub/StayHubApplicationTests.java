package bitlab.finalproject.StayHub;

import bitlab.finalproject.StayHub.DTO.HotelDTO;
import bitlab.finalproject.StayHub.Mapper.HotelMapper;
import bitlab.finalproject.StayHub.Model.Apartaments;
import bitlab.finalproject.StayHub.Model.Hotels;
import bitlab.finalproject.StayHub.Repository.HotelRepository;
import bitlab.finalproject.StayHub.Service.HotelService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class StayHubApplicationTests {
	@Autowired
	private HotelMapper hotelMapper;

	@Autowired
	private HotelService hotelService;

	@Autowired
	private HotelRepository hotelRepository;

	@Test
	void checkHotelDto(){

		hotelRepository.deleteAll();

		Hotels hotels=new Hotels();
		hotels.setId(3L);
		hotels.setName("DoubleTree");
		hotels.setAddress("44th St");
		hotels.setCity("New York");
		hotels.setDescription("qwer");
		hotels.setPrice("455");
		hotels.setRating("8");
		hotels.setText("qwert");   //Мне нужно проверить это сущность точно также передается в DTO

		HotelDTO hotelDTO=hotelMapper.toDTo(hotels);

		assertEquals(hotels.getName(),hotelDTO.getHotelName());
		assertEquals(hotels.getText(),hotelDTO.getText());
		assertEquals(hotels.getPrice(),hotelDTO.getPrice());
		assertEquals(hotels.getCity(),hotelDTO.getCity());
		assertEquals(hotels.getRating(),hotelDTO.getRating());
		assertEquals(hotels.getDescription(),hotelDTO.getDescription());
		assertEquals(hotels.getId(),hotelDTO.getId());
	}
	@Test
	void checkInsertIntoDb(){
		Hotels hotels=new Hotels();
		hotels.setName("DoubleTree");
		hotels.setDescription("qwer");
		hotels.setPrice("455");
		hotels.setRating("8");
		hotels.setText("qwert");
		hotels.setCity("New York");
		hotels.setAddress("44th St");

		HotelDTO newhotel=hotelService.addHotel(hotelMapper.toDTo(hotels));

		Assertions.assertNotNull(newhotel);
		Assertions.assertNotNull(newhotel.getId());
		assertEquals(hotels.getName(), newhotel.getHotelName());
		assertEquals(hotels.getDescription(),newhotel.getDescription());
		assertEquals(hotels.getPrice(),newhotel.getPrice());
		assertEquals(hotels.getRating(),newhotel.getRating());
		assertEquals(hotels.getText(),newhotel.getText());
		assertEquals(hotels.getCity(),newhotel.getCity());
		assertEquals(hotels.getAddress(),newhotel.getAddress());

		hotelService.deleteHotel(newhotel.getId());
	}
	@Test
	public void checkSaveMethod(){

		Hotels hotels=new Hotels();
		hotels.setName("Test");
		hotels.setCity("Test");

		HotelDTO hotelDTO= hotelService.saveHotel(hotelMapper.toDTo(hotels));
		Assertions.assertNotNull(hotelDTO);
		Assertions.assertNotNull(hotelDTO.getId());
		assertEquals(hotels.getName(),hotelDTO.getHotelName());
		assertEquals(hotels.getCity(),hotelDTO.getCity());
	}
	@Test
	public void CheckUpdateMethod(){
		Hotels hotels=new Hotels();
		hotels.setId(2L);
		hotels.setName("Hilton Seward Hotel");

		HotelDTO hotelDTO= hotelService.updateHotel(hotelMapper.toDTo(hotels));

		Assertions.assertNotNull(hotelDTO);
		Assertions.assertNotNull(hotelDTO.getId());
		assertEquals(hotels.getName(),hotelDTO.getHotelName());
	}

}

/*Unit test это проверка каждого метода */
