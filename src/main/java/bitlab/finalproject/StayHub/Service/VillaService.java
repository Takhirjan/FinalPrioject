package bitlab.finalproject.StayHub.Service;

import bitlab.finalproject.StayHub.Model.Hotels;
import bitlab.finalproject.StayHub.Model.Villa;
import bitlab.finalproject.StayHub.Repository.HotelRepository;
import bitlab.finalproject.StayHub.Repository.VillaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class VillaService {
  private final VillaRepository villaRepository;
  public Villa getVillaById(Long id){
    return villaRepository.findById(id).orElse(null);
  }
  public int  getVillaCount(){
    List<Villa> villas=villaRepository.findAll();
    return villas.size();
  }
}
