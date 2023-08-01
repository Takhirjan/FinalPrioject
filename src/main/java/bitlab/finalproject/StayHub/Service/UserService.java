package bitlab.finalproject.StayHub.Service;

import bitlab.finalproject.StayHub.Model.Hotels;
import bitlab.finalproject.StayHub.Model.Users;
import bitlab.finalproject.StayHub.Repository.UserRepository;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.List;


public class UserService implements UserDetailsService {

  @Autowired
  private UserRepository userRepository;

  @Autowired
  PasswordEncoder passwordEncoder;
  /*UserDetails возвращает пользователя, то е ть он проверяет он null или нет
   */

  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    Users user = userRepository.findByEmail(username);
    if(user!=null){
      return user;
    }else{
      throw  new UsernameNotFoundException("User Not Found");
    }
  }
  public Users addUser(Users users){
    Users newUser=userRepository.findByEmail(users.getEmail());
    if(newUser==null){  //he is checking if current email is available
      users.setPassword(passwordEncoder.encode(users.getPassword())); // щн превращает его парольв Bcrypt
      return userRepository.save(users);
    }
    return null;
  }
  public Users updatePassword(String newPassword, String oldPassword) {
    Users currentUser = getCurrentSessionUser();
    if(passwordEncoder.matches(oldPassword, currentUser.getPassword())){
      currentUser.setPassword(passwordEncoder.encode(newPassword));
      return userRepository.save(currentUser);
    }
    return null;
  }

  public Users getCurrentSessionUser() {
    Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
    if (!(authentication instanceof AnonymousAuthenticationToken)) {
      Users user = (Users) authentication.getPrincipal();
      if (user != null) {
        return user;
      }
    }
    return null;
  }
  public List<Users> getUser(){
    return userRepository.findAll();
  }
  public Users getUserByID(Long id){
    return userRepository.findById(id).orElse(null);
  }

}


//Есть готовый метод UserDetailsService. Он принодледит спринг секюрити в котором мы должны реализоватьметоды
// LoadbyUsernmae этот метод юудет автоматически вызываться когда булу проводить аудентификацию
