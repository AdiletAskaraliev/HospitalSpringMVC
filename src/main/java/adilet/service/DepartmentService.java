package adilet.service;

import adilet.entity.Department;
import adilet.entity.Hospital;

import java.util.List;

public interface DepartmentService {
    void saveDepartment(Long hospitalId, Department department);
    List<Department> getAllDepartments(Long id);
    List<Department> findByHospitalId(Long hospitalId);
    Hospital findById(Long id);
    void updateDepartment(Long id, Department department);
    void deleteDepartment(Long id);
    List<Department> findAll(Long hospitalId);
    Department findDepartmentByHospitalId(Long hospitalId, Long depId);
    void updateToDepartmentByHospitalId(Long hospitalId, Long depId, Department department);

    void deleteToDepartmentWithIdByHospitalId(Long hospitalId, Long depId);
}
