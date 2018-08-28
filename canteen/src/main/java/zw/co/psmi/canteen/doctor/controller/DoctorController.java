package zw.co.psmi.canteen.doctor.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import zw.co.psmi.canteen.admin.entity.Department;
import zw.co.psmi.canteen.admin.entity.Diagnosis;
import zw.co.psmi.canteen.admin.entity.Gender;
import zw.co.psmi.canteen.admin.entity.Nationality;
import zw.co.psmi.canteen.admin.entity.Salutation;
import zw.co.psmi.canteen.admin.service.DepartmentService;
import zw.co.psmi.canteen.admin.service.DiagnosisService;
import zw.co.psmi.canteen.admin.service.GenderService;
import zw.co.psmi.canteen.admin.service.NationalityService;
import zw.co.psmi.canteen.admin.service.SalutationService;
import zw.co.psmi.canteen.auth.entity.Login;
import zw.co.psmi.canteen.doctor.entity.ActiveStatus;
import zw.co.psmi.canteen.doctor.entity.Patient;
import zw.co.psmi.canteen.doctor.service.ActiveStatusService;
import zw.co.psmi.canteen.doctor.service.PatientService;

@Controller
public class DoctorController {

	private PatientService patientService;
	private DepartmentService departmentService;
	private GenderService genderService;
	private SalutationService salutationService;
	private NationalityService nationalityService;
	private DiagnosisService diagnosisService;
	private ActiveStatusService activeStatusService;
    //Create user
    @Autowired
    public DoctorController(PatientService patientService, DepartmentService departmentService, GenderService genderService, SalutationService salutationService, NationalityService nationalityService, DiagnosisService diagnosisService, ActiveStatusService activeStatusService) {
        this.genderService = genderService;
        this.departmentService = departmentService;
        this.salutationService = salutationService;
        this.nationalityService = nationalityService;
        this.diagnosisService = diagnosisService;
        this.patientService = patientService;
        this.activeStatusService = activeStatusService;
    } 
	

	 @RequestMapping(value = "/doctor/docview", method = RequestMethod.GET)
		public String docview() {
			return "/doctor/docview";
		}
	 @RequestMapping(value = "/doctor/userprofile", method = RequestMethod.GET)
		public String userprofile() {
			return "/doctor/userprofile";
		}
	 @RequestMapping(value = "/doctor/ordering", method = RequestMethod.GET)
		public String ordering() {
			return "/doctor/ordering";
		} 
	
	 
	 //add Patient

	 @RequestMapping(value = "/doctor/patients", method = RequestMethod.GET) 
	 public String patients(@AuthenticationPrincipal Login login, Model model) {
	        model.addAttribute("patientss", this.patientService.findAll());	
			return "/doctor/patients";
		}
	 
	 
	 @RequestMapping(value = "/doctor/addpatient", method = RequestMethod.GET)
		public String addpatient(@ModelAttribute Patient patient,   @ModelAttribute Department department, @ModelAttribute Gender gender, @ModelAttribute Salutation salutation,  @ModelAttribute Nationality nationality,  @ModelAttribute Diagnosis diagnosis, @ModelAttribute ActiveStatus activeStatus, Model model) {       
		 //user.setDepartment(departmentService.getAll());
		 model.addAttribute("patients", patient);
		 model.addAttribute("departments", departmentService.findAll());
		 model.addAttribute("genders", genderService.findAll());
		 model.addAttribute("salutations", salutationService.findAll());
		 model.addAttribute("nationalitys", nationalityService.findAll());
		 model.addAttribute("diagnosiss", diagnosisService.findAll());
		 model.addAttribute("activeStatuss", activeStatusService.findAll());
		 return "/doctor/addpatient";
		}
	 
	 
	  @RequestMapping(value = "/doctor/addpatientform", method = RequestMethod.POST)
	    public String addpatientform(  @ModelAttribute Patient patient, Model model, RedirectAttributes redirectAttributes) {
		  String msg = this.patientService.save(patient);
	      redirectAttributes.addFlashAttribute("msg", "setMsg('" + msg + "')");
	          return "redirect:/doctor/patients";
	    }
	
	

}
