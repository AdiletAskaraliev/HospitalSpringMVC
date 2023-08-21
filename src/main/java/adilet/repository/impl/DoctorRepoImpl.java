package adilet.repository.impl;

import adilet.entity.Doctor;
import adilet.repository.DoctorRepo;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
@Transactional
public class DoctorRepoImpl implements DoctorRepo {

    @PersistenceContext
    private final EntityManager entityManager;

    public DoctorRepoImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<Doctor> findAll(Long hospitalId) {
        return entityManager.createQuery(
                "select d from Doctor d where d.hospital.id = :hosId", Doctor.class)
                .setParameter("hosId", hospitalId)
                .getResultList();
    }

    @Override
    public void saveDoctor( Doctor doctor) {
        entityManager.persist(doctor);
    }
}
