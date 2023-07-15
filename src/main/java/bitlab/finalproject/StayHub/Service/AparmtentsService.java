package bitlab.finalproject.StayHub.Service;

import bitlab.finalproject.StayHub.Model.Apartaments;
import bitlab.finalproject.StayHub.Repository.ApartmentsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AparmtentsService {
  private final ApartmentsRepository apartmentsRepository;

  public List<Apartaments> getApartaments() {
    return apartmentsRepository.findAll();
  }


  public Apartaments getApartamentsById(Long id) {
    return apartmentsRepository.findById(id).orElse(null);
  }

public  Apartaments addApartament(Apartaments image){
    return apartmentsRepository.save(image);
}
}
