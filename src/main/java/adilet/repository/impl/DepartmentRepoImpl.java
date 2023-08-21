package adilet.repository.impl;

import adilet.entity.Department;
import adilet.entity.Hospital;
import adilet.repository.DepartmentRepo;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
@Transactional
public class DepartmentRepoImpl implements DepartmentRepo {
    @PersistenceContext
    private final EntityManager entityManager;

    public DepartmentRepoImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public void saveDepartment(Department department) {
        entityManager.persist(department);
    }

    @Override
    public List<Department> getAllDepartments(Long id) {
        return entityManager.createQuery(
                "select d From Department d where d.id = :id", Department.class)
                .setParameter("id", id)
                .getResultList();
    }



    @Override
    public List<Department> findByHospitalId(Long hospitalId) {
        return entityManager.createQuery("SELECT d FROM Department d WHERE d.hospital.id = :hospitalId", Department.class)
                .setParameter("hospitalId", hospitalId)
                .getResultList();
    }


    @Override
    public Hospital findById(Long id) {
        return entityManager.find(Hospital.class, id);
    }

    @Override
    public void updateDepartment(Long id, Department department) {
        Department department1 = entityManager.find(Department.class, id);
        department1.setName(department.getName());
    }

    @Override
    public void deleteDepartment(Long id) {
        entityManager.remove(entityManager.find(Department.class, id));
    }

    @Override
    public List<Department> findAll(Long hospitalId) {
        return entityManager.createQuery(
                        "SELECT d FROM Department d WHERE d.hospital.id = :id ", Department.class)
                .setParameter("id", hospitalId)
                .getResultList();
    }

    @Override
    public Department findDepartmentByHospitalIdAndId(Long hospitalId, Long depId) {
        return entityManager.createQuery(
                        "select d from Department d where d.hospital.id = :hospitalId and d.id = :depId", Department.class)
                .setParameter("hospitalId", hospitalId)
                .setParameter("depId", depId)
                .getSingleResult();
    }

    @Override
    public void deleteToDepartmentWithIdByHospitalId(Long hospitalId, Long depId) {
        entityManager.remove(findDepartmentByHospitalIdAndId(hospitalId, depId));
    }
}
