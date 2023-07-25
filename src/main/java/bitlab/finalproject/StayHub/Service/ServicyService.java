package bitlab.finalproject.StayHub.Service;

import bitlab.finalproject.StayHub.Repository.ServiceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ServicyService {
  private final ServiceRepository serviceRepository;

public bitlab.finalproject.StayHub.Model.Service getServiceById(Long id){
  return serviceRepository.findById(id).orElse(null);
}
}
