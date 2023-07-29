package bitlab.finalproject.StayHub.Repository;

import bitlab.finalproject.StayHub.Model.Uslugi;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Transactional
public interface ServiceRepository extends JpaRepository<Uslugi,Long> {
  List<Uslugi> findAll();
}
