package bitlab.finalproject.StayHub.Service;

import bitlab.finalproject.StayHub.Model.Apartaments;
import bitlab.finalproject.StayHub.Repository.ApartmentsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AparmtentsService {
private final ApartmentsRepository apartmentsRepository;
public Apartaments getApartaments(Long id){
  return apartmentsRepository.findById(id).orElse(null);
}
}
