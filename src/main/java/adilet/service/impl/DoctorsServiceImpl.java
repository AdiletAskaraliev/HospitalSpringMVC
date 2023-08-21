package adilet.service.impl;

import adilet.entity.Department;
import adilet.entity.Doctor;
import adilet.entity.Hospital;
import adilet.repository.DoctorRepo;
import adilet.repository.HospitalRepo;
import adilet.service.DoctorService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
@Transactional
public class DoctorsServiceImpl implements DoctorService {

    private final DoctorRepo doctorRepo;
    private final HospitalRepo hospitalRepo;

    @Override
    public List<Doctor> findAllDoctors(Long hospitalId) {
        return doctorRepo.findAll(hospitalId);
    }

    @Override
    public void saveDoctorByHospitalId(Long hospitalId, Doctor doctor) {
        Hospital hospital = hospitalRepo.findById(hospitalId);
        hospital.addDoctor(doctor);
        doctor.setHospital(hospital);
        doctorRepo.saveDoctor(doctor);
    }
}
