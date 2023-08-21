package adilet.service;

import adilet.entity.Doctor;

import java.util.List;

public interface DoctorService {
    List<Doctor> findAllDoctors(Long hospitalId);

    void saveDoctorByHospitalId(Long hospitalId, Doctor doctor);
}
