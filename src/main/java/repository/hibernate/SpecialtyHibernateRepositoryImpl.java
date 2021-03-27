package repository.hibernate;

import model.Specialty;
import org.hibernate.Session;
import repository.SpecialtyRepository;

import java.util.LinkedHashSet;
import java.util.Set;

public class SpecialtyHibernateRepositoryImpl implements SpecialtyRepository {

    @Override
    public Set<Specialty> saveToDB(Set<Specialty> specialties) {
        try (Session session = SessionCreator.getSession()) {
            session.beginTransaction();
            for (Specialty specialty : specialties
            ) {
                session.save(specialty);
            }

            session.getTransaction().commit();
        }
        return specialties;
    }

    @Override
    public Set<Specialty> getFromDB(Integer specialtiesID) {
        Set<Specialty> specialties = new LinkedHashSet<>();
        try (Session session = SessionCreator.getSession()) {
            session.beginTransaction();
            specialties.add(session.get(Specialty.class, specialtiesID));
            session.getTransaction().commit();

        } catch (IllegalArgumentException e) {
            System.out.println("Specialties not found!");
            e.printStackTrace();
        }
        return specialties;
    }

    @Override
    public Set<Specialty> updateInDB(Set<Specialty> specialties) {
        try (Session session = SessionCreator.getSession()) {
            session.beginTransaction();
            for (Specialty specialty : specialties
            ) {
                session.update(specialty);
            }
            session.getTransaction().commit();

        } catch (IllegalArgumentException e) {
            System.out.println("Specialties not found!");
            e.printStackTrace();
        }
        return specialties;
    }

    @Override
    public Set<Specialty> deleteInDB(Integer specialtiesID) {
        Set<Specialty> specialties = new LinkedHashSet<>();
        try (Session session = SessionCreator.getSession()) {
            session.beginTransaction();
            Specialty specialty=session.get(Specialty.class, specialtiesID);
            session.delete(specialty);
            session.getTransaction().commit();

        } catch (IllegalArgumentException e) {
            System.out.println("Customer not found!");
            e.printStackTrace();
        }
        return specialties;
    }

}
