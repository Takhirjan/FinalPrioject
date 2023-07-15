package bitlab.finalproject.StayHub.Repository;

import bitlab.finalproject.StayHub.Model.Hotels;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Transactional
public interface HotelRepository extends JpaRepository<Hotels,Long> {
List<Hotels> findAll();

}
