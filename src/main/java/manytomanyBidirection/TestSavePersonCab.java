package manytomanyBidirection;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class TestSavePersonCab {

	public static void main(String[] args) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("vikas");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		Person person = new Person();
		person.setName("venki");
		person.setAge(22);
		person.setEmail("vkvenkates@");

		Person person1 = new Person();
		person1.setName("manu");
		person1.setAge(22);
		person1.setEmail("manu@manu");
		Person person2 = new Person();
		person2.setName("nagu");
		person2.setAge(22);
		person2.setEmail("nagu@manu");
		List<Person> persons = new ArrayList<Person>();
		persons.add(person);
		persons.add(person1);
		persons.add(person2);

		List<Person> persons11 = new ArrayList<Person>();
		persons11.add(person);
		persons11.add(person1);

		List<Person> persons12 = new ArrayList<Person>();
		persons12.add(person);

		// cab
		Cab cab = new Cab();
		cab.setDriverName("manoj");
		cab.setCost(250.0);
		cab.setPersons(persons);
		// cab1
		Cab cab1 = new Cab();
		cab1.setDriverName("raamu");
		cab1.setCost(2500.0);
		cab1.setPersons(persons);
		// cab2
		Cab cab2 = new Cab();
		cab2.setDriverName("raaju");
		cab2.setCost(2810.0);
		cab2.setPersons(persons);

		List<Cab> cabs = new ArrayList<Cab>();
		cabs.add(cab);
		cabs.add(cab1);
		cabs.add(cab2);
		person.setCab(cabs);

		// for cab2 contines 2 person
		cab1.setPersons(persons11);
		// for cab1 contines 3 person
		cab.setPersons(persons);
		// for cab3 contines 1person
		cab2.setPersons(persons12);

		entityTransaction.begin();
		entityManager.persist(person);
		entityManager.persist(person1);
		entityManager.persist(person2);
		entityManager.persist(cab);
		entityManager.persist(cab1);
		entityManager.persist(cab2);
		entityTransaction.commit();
	}

}
