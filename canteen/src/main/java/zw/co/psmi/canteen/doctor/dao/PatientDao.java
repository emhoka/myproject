package zw.co.psmi.canteen.doctor.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import zw.co.psmi.canteen.doctor.entity.Patient;


public interface PatientDao extends JpaRepository<Patient, Long> {
	public Patient findByPhone(String phone);
}
