package bitlab.finalproject.StayHub.Repository;

import bitlab.finalproject.StayHub.Model.Apartaments;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface ApartmentsRepository extends JpaRepository<Apartaments,Long> {

}
