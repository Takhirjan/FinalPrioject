package bitlab.finalproject.StayHub.Repository;

import bitlab.finalproject.StayHub.Model.Hotels;
import bitlab.finalproject.StayHub.Model.Villa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VillaRepository extends JpaRepository<Villa,Long> {
List<Villa> findAll();
}
