package bitlab.finalproject.StayHub.DTO;
import bitlab.finalproject.StayHub.Model.Permission;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.util.List;

@Getter
@Setter
public class UsersDTO {
  private Long id;
  private String mail;
  private String password;
  private String fullName;

  @ManyToMany(fetch = FetchType.EAGER)
  private List<Permission> permissions;
}
