package manytomanyBidirection;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class ToSavetheStudentCources {

	public static void main(String[] args) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("vikas");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		Student student = new Student();
		student.setName("divya");
		student.setAge(22);
		Student student1 = new Student();
		student1.setName("anil");
		student1.setAge(23);

		Student student2 = new Student();
		student2.setName("ravi");
		student2.setAge(25);
		List<Student> students = new ArrayList<Student>();
		students.add(student);
		students.add(student1);
		students.add(student2);

		Courses courses1 = new Courses();
		courses1.setName("html");
		courses1.setDuration(3);
		Courses courses2 = new Courses();
		courses2.setName("java");
		courses2.setDuration(5);

		Courses courses3 = new Courses();
		courses3.setName("css");
		courses3.setDuration(5);
		List<Courses> courses = new ArrayList<Courses>();
		courses.add(courses1);
		courses.add(courses2);
		courses.add(courses3);
		List<Courses> courses11 = new ArrayList<Courses>();
		courses11.add(courses1);
		courses11.add(courses2);
		List<Courses> courses12 = new ArrayList<Courses>();
		courses12.add(courses1);
		courses12.add(courses3);
		student.setCourses(courses);
		student.setCourses(courses11);
		student.setCourses(courses12);

		courses1.setStudent(students);
		courses2.setStudent(students);
		courses3.setStudent(students);

		entityTransaction.begin();
		entityManager.persist(student);
		entityManager.persist(student1);
		entityManager.persist(student2);
		entityManager.persist(courses1);
		entityManager.persist(courses2);
		entityManager.persist(courses3);
		entityTransaction.commit();
	}
}
