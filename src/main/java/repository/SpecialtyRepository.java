package repository;


import model.Specialty;

import java.util.Set;

public interface SpecialtyRepository extends GenericRepository{

    Set<Specialty> saveToDB(Set<Specialty> specialties);

    Set<Specialty> getFromDB(Integer specialtiesID);

    Set<Specialty> updateInDB(Set<Specialty> specialties);

    Set<Specialty> deleteInDB(Integer specialtiesID);
}
