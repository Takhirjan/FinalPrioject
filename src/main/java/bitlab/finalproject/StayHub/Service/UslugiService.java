package bitlab.finalproject.StayHub.Service;

import bitlab.finalproject.StayHub.Model.Uslugi;
import bitlab.finalproject.StayHub.Repository.ServiceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UslugiService {
  private final ServiceRepository serviceRepository;

public List<Uslugi> getService(){
return serviceRepository.findAll();
  }

  public Uslugi getServiceById(Long id){
  return serviceRepository.findById(id).orElse(null);
  }

}


