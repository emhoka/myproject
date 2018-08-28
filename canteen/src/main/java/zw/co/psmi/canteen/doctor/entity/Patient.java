package zw.co.psmi.canteen.doctor.entity;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;
import zw.co.psmi.canteen.admin.entity.Department;
import zw.co.psmi.canteen.admin.entity.Diagnosis;
import zw.co.psmi.canteen.admin.entity.Gender;
import zw.co.psmi.canteen.admin.entity.Nationality;
import zw.co.psmi.canteen.admin.entity.Role;
import zw.co.psmi.canteen.admin.entity.Salutation;
import zw.co.psmi.canteen.basic.BaseEntity;

@Entity
@Data
@Table(name="_patients")
public class Patient extends BaseEntity{
	private String name;
	private String surname;
	private String national_id;
	private String passport;
	private String dob;
	private String phone;
	
	    @ManyToOne
	    private Department department;
	    
	    @ManyToOne
	    private Gender gender;
	    
	    @ManyToOne
	    private Nationality nationality;
	    
	    @ManyToOne
	    private Salutation salutation;
	    
	    @ManyToOne
	    private Diagnosis diagnosis;
	    
	    @ManyToOne
	    private ActiveStatus activeStatus;
	     
	    
	    @Override
	    public String toString() {
	        return "patients{" + "id=" + id + ", name=" + name + ", surname=" + surname + ", national_id=" + national_id + ", passport=" + passport + ", dob = "+ dob +"}";
	    }

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getSurname() {
			return surname;
		}

		public void setSurname(String surname) {
			this.surname = surname;
		}

		public String getNational_id() {
			return national_id;
		}

		public void setNational_id(String national_id) {
			this.national_id = national_id;
		}

		public String getPassport() {
			return passport;
		}

		public void setPassport(String passport) {
			this.passport = passport;
		}


		public Department getDepartment() {
			return department;
		}

		public void setDepartment(Department department) {
			this.department = department;
		}

		public Gender getGender() {
			return gender;
		}

		public void setGender(Gender gender) {
			this.gender = gender;
		}

		public Nationality getNationality() {
			return nationality;
		}

		public void setNationality(Nationality nationality) {
			this.nationality = nationality;
		}

		public Salutation getSalutation() {
			return salutation;
		}

		public void setSalutation(Salutation salutation) {
			this.salutation = salutation;
		}

		public Diagnosis getDiagnosis() {
			return diagnosis;
		}

		public void setDiagnosis(Diagnosis diagnosis) {
			this.diagnosis = diagnosis;
		}

		public String getDob() {
			return dob;
		}

		public void setDob(String dob) {
			this.dob = dob;
		}

		public String getPhone() {
			return phone;
		}

		public void setPhone(String phone) {
			this.phone = phone;
		}

		public ActiveStatus getActiveStatus() {
			return activeStatus;
		}

		public void setActiveStatus(ActiveStatus activeStatus) {
			this.activeStatus = activeStatus;
		}
	
	    

}
