package bitlab.finalproject.StayHub.Service;

import bitlab.finalproject.StayHub.Model.Apartaments;
import bitlab.finalproject.StayHub.Repository.ApartmentsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AparmtentsService {
private final ApartmentsRepository apartmentsRepository;
public List<Apartaments> getApartaments(){
return apartmentsRepository.findAll();
}

}
