package adilet.service.impl;

import adilet.entity.Hospital;
import adilet.repository.HospitalRepo;
import adilet.service.HospitalService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class HospitalServiceImpl implements HospitalService {

    private final HospitalRepo hospitalRepo;

    @Override
    public void saveHospital(Hospital hospital) {
        hospitalRepo.saveHospital(hospital);
    }

    @Override
    public List<Hospital> getAllHospital() {
        return hospitalRepo.getAllHospital();
    }

    @Override
    public Hospital findById(Long id) {
        return hospitalRepo.findById(id);
    }


    @Transactional
    @Override
    public void updateHospital(Long id, Hospital hospital) {
        Hospital hospital1 = findById(id);
        hospital1.setName(hospital.getName());
        hospital1.setAddress(hospital.getAddress());
    }

    @Override
    public void deleteHospital(Long id) {
        hospitalRepo.deleteHospital(id);
    }

}
