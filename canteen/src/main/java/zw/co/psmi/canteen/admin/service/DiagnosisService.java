package zw.co.psmi.canteen.admin.service;

import zw.co.psmi.canteen.admin.entity.Diagnosis;
import zw.co.psmi.canteen.basic.BasicService;

public interface DiagnosisService extends BasicService<Diagnosis>{
	public	Diagnosis findByCode(String code);

}
