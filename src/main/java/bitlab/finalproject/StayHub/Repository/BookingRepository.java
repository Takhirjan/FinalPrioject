package bitlab.finalproject.StayHub.Repository;

import bitlab.finalproject.StayHub.Model.Booking;
import bitlab.finalproject.StayHub.Model.Uslugi;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Repository
@Transactional
public interface BookingRepository extends JpaRepository<Booking,Long> {
//  boolean existsByDateTimeAndUslugiModel(LocalDateTime dateTime, Uslugi uslugiModel);
}
