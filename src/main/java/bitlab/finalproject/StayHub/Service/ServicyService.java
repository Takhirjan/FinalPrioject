package bitlab.finalproject.StayHub.Service;

import bitlab.finalproject.StayHub.Repository.ServiceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ServicyService {
  private final ServiceRepository serviceRepository;
  public List<bitlab.finalproject.StayHub.Model.Service> getAllService() {
    return serviceRepository.findAll();
  }
}