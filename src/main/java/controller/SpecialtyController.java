package controller;

import model.Specialty;
import repository.SpecialtyRepository;
import repository.hibernate.SpecialtyHibernateRepositoryImpl;

import java.util.Set;

public class SpecialtyController {
    SpecialtyRepository specialtyRepository = new SpecialtyHibernateRepositoryImpl();

    public Set<Specialty> saveSpecialties(Set<Specialty> specialties) {
        return specialtyRepository.saveToDB(specialties);
    }

    public Set<Specialty> readSpecialties(Integer specialtiesID) {
        return specialtyRepository.getFromDB(specialtiesID);
    }

    public Set<Specialty> updateSpecialties(Set<Specialty> specialties) {
        return specialtyRepository.updateInDB(specialties);
    }

    public Set<Specialty> deleteSpecialties(Integer specialtiesID) {
        return specialtyRepository.deleteInDB(specialtiesID);
    }
}
