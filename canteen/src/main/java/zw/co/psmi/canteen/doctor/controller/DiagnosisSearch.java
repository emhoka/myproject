package zw.co.psmi.canteen.doctor.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import zw.co.psmi.canteen.admin.entity.Diagnosis;
import zw.co.psmi.canteen.admin.service.DiagnosisService;

@Controller
public class DiagnosisSearch {

	 @Autowired
	    private DiagnosisService diagnosisService;
	    
	    @RequestMapping(value = "/patient/diagnosissearchlist", method = RequestMethod.GET)
	    @ResponseBody
	    public String diagnosisList(@RequestParam(value = "name", required = true) String name) {
	        String data = "";
	        for(Diagnosis diagnosis :diagnosisService.findBySearch(name))
	            {
	            data += "<tr>"+
	                    "<td><input type=\"radio\" name=\"diagnosisItem\" id=\"diagnosisItem\" value=\"" + diagnosis.getId() + "****"+diagnosis.getCode()+ "****"+diagnosis.getName()+"\" /></td>"+
	                    "<td>"+diagnosis.getCode()+"</td>"+
	                    "<td>"+diagnosis.getName()+"</td>"+
	                    "</tr>";
	            }
	        if(!data.isEmpty())
	            {
	            data = "<table class='table'>"+data+"</table>";
	            }
	        return data;
	    }  
}
