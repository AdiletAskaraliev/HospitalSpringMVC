package adilet.repository;

import adilet.entity.Doctor;

import java.util.List;

public interface DoctorRepo {

    List<Doctor> findAll(Long hospitalId);

    void saveDoctor(Doctor doctor);
}
