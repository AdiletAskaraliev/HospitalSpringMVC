package adilet.repository.impl;

import adilet.entity.Hospital;
import adilet.repository.HospitalRepo;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@Transactional
public class HospitalRepoImpl implements HospitalRepo {
    @PersistenceContext
    private final EntityManager entityManager;

    public HospitalRepoImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public void saveHospital(Hospital hospital) {
        entityManager.persist(hospital);
    }

    @Override
    public List<Hospital> getAllHospital() {
        return entityManager.createQuery(
                "select h from Hospital h", Hospital.class).getResultList();
    }

    @Override
    public Hospital findById(Long id) {
        return entityManager.createQuery(
                        "select h from Hospital h where h.id = :hospitalId", Hospital.class)
                        .setParameter("hospitalId", id)
                        .getSingleResult();
    }



    @Override
    public void updateHospital(Long id, Hospital hospital) {
        Hospital hospital1 = entityManager.find(Hospital.class, id);
        hospital1.setName(hospital.getName());
        hospital1.setAddress(hospital.getAddress());
        entityManager.merge(hospital1);
    }


    @Override
    public void deleteHospital(Long id) {
        entityManager.remove(entityManager.find(Hospital.class, id));
    }


}
