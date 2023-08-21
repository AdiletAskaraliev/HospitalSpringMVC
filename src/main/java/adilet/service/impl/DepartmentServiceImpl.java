package adilet.service.impl;

import adilet.entity.Department;
import adilet.entity.Hospital;
import adilet.repository.DepartmentRepo;
import adilet.repository.HospitalRepo;
import adilet.service.DepartmentService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class DepartmentServiceImpl implements DepartmentService {

    private final DepartmentRepo departmentRepo;
    private final HospitalRepo hospitalRepo;
    @Override
    public void saveDepartment(Long hospitalId, Department department) {
        Hospital hospital = hospitalRepo.findById(hospitalId);
        hospital.addHospital(department);
        department.setHospital(hospital);
        departmentRepo.saveDepartment(department);
    }
  @Override
    public List<Department> getAllDepartments(Long id) {
        return departmentRepo.findByHospitalId(id);
    }

    @Override
    public List<Department> findByHospitalId(Long hospitalId) {
        return departmentRepo.findByHospitalId(hospitalId);
    }

    @Override
    public Hospital findById(Long id) {
        return departmentRepo.findById(id);
    }

    @Override
    public void updateDepartment(Long id, Department department) {
        departmentRepo.updateDepartment(id, department);
    }

    @Override
    public void deleteDepartment(Long id) {
        departmentRepo.deleteDepartment(id);
    }

    @Override
    public List<Department> findAll(Long hospitalId) {
        return departmentRepo.findAll(hospitalId);
    }

    @Override
    public Department findDepartmentByHospitalId(Long hospitalId, Long depId) {
        return departmentRepo.findDepartmentByHospitalIdAndId(hospitalId, depId);
    }
    @Override
    public void updateToDepartmentByHospitalId(Long hospitalId, Long depId, Department department) {
        Department department1 = departmentRepo.findDepartmentByHospitalIdAndId(hospitalId, depId);

        if (department1 != null) {
            department1.setName(department.getName());
            departmentRepo.saveDepartment(department1);
        }
    }

    @Override
    public void deleteToDepartmentWithIdByHospitalId(Long hospitalId, Long depId) {
        departmentRepo.deleteToDepartmentWithIdByHospitalId(hospitalId, depId);
    }


}
