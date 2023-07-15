package bitlab.finalproject.StayHub.Repository;

import bitlab.finalproject.StayHub.Model.Apartaments;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
@Transactional
public interface ApartmentsRepository extends JpaRepository<Apartaments,Long> {

}
