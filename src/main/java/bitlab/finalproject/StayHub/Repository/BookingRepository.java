package bitlab.finalproject.StayHub.Repository;

import bitlab.finalproject.StayHub.Model.Booking;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
@Transactional
public interface BookingRepository extends JpaRepository<Booking,Long> {
}
