package adilet.repository;

import adilet.entity.Department;
import adilet.entity.Hospital;

import java.util.List;

public interface DepartmentRepo {
    void saveDepartment(Department department);
    List<Department> getAllDepartments(Long id);
    List<Department> findByHospitalId(Long hospitalId);
    Hospital findById(Long id);
    void updateDepartment(Long id, Department department);

    void deleteDepartment(Long id);

    List<Department> findAll(Long hospitalId);
    Department findDepartmentByHospitalIdAndId(Long hospitalId, Long depId);

    void deleteToDepartmentWithIdByHospitalId(Long hospitalId, Long depId);
}
