package manytomanyBidirection;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
@Entity
public class Person {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
		private int id;
		private String name;
		private int age;
		private String email;
		@ManyToMany
		@JoinTable(name="my_person_cab",joinColumns=@JoinColumn(name="my_person_id"),
		inverseJoinColumns=@JoinColumn(name="My_cab_id"))
		private List<Cab> cab;
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public List<Cab> getCab() {
			return cab;
		}
		public void setCab(List<Cab> cab) {
			this.cab = cab;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public int getAge() {
			return age;
		}
		public void setAge(int age) {
			this.age = age;
		}
		public String getEmail() {
			return email;
		}
		public void setEmail(String email) {
			this.email = email;
		}

	}


