package zw.co.psmi.canteen.doctor.service;

import zw.co.psmi.canteen.basic.BasicService;
import zw.co.psmi.canteen.doctor.entity.Patient;

public interface PatientService extends BasicService<Patient>{
	public Patient findByPhone(String phone);
}
