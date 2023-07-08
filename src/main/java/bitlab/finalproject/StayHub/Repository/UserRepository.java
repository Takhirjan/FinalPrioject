package bitlab.finalproject.StayHub.Repository;

import bitlab.finalproject.StayHub.Model.Users;
import jakarta.transaction.Transactional;
import org.apache.catalina.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public interface UserRepository extends JpaRepository< Users,Long> {
  Users findByEmail(String email);




  //Есть готовый метод UserDetailsService. Он принодледит спринг секюрити в котором мы должны реализоватьметоды
 // LoadbyUsernmae этот метод юудет автоматически вызываться когда булу проводить аудентификацию
}
