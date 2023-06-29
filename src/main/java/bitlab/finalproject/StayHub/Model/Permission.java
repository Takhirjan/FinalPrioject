package bitlab.finalproject.StayHub.Model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;

@Entity
@Getter
@Setter
@Table(name = "t_permission")
public class Permission extends BaseModel implements GrantedAuthority {
  @Column(name = "role")
  private String role;

  @Override
  public String getAuthority() {
    return this.role;
  }
}
