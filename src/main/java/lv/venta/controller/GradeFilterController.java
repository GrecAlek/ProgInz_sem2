package lv.venta.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import lv.venta.Model.Grade;
import lv.venta.service.IGradeFilterService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
@RequestMapping("/grade/filter")

public class GradeFilterController {

	@Autowired
	private IGradeFilterService gradeFilterService;
	
	@GetMapping("/failed")
	
	public String getFailedGrades(Model model) {
		

		try {
			ArrayList<Grade> failedGrades;
			failedGrades = gradeFilterService.selectFailedGrades();
			model.addAttribute("mydata",failedGrades);
			
			model.addAttribute("msg", "Failed grades!");
			return "grade-show-all-page";
			
		} catch (Exception e) {
			model.addAttribute("mydata",e.getMessage());
			return "error-page";
		}
		
	}
	
		
		
	@GetMapping("/student/{id}")//localhost:8080/grade/filter/student/1
	public String getGradeFilterByStudentId(@PathVariable("id") int id, Model model) {
		try
		{
			ArrayList<Grade> selectGrades = gradeFilterService.selectGradesbyStudentId(id);
			model.addAttribute("mydata", selectGrades);//padodam datus uz grade-show-all-page.html lapu
			model.addAttribute("msg", "Filtered grades by student");
			return "grade-show-all-page";//tiks parādīt grade-show-all-page.html lapa interneta pārlūka
		}
		catch (Exception e) {
			model.addAttribute("mydata", e.getMessage());//padod kļudas ziņu uz error-page.html lapu
			return "error-page";//parādām pašu error-page.html lapu interneta pārlūkā

		}
	}
	
	
	@GetMapping("/avg/course/{id}")//localhost:8080/grade/filter/avg/course/1
	public String getGradeFilterAVGByCourseId(@PathVariable("id") int id, Model model) {
		try
		{
			float avgGrades = gradeFilterService.calculateAVGGradeInCourseId(id);
			model.addAttribute("msg", "Avg grade: " + avgGrades);
			return "grade-show-all-page";//tiks parādīt grade-show-all-page.html lapa interneta pārlūka
		}
		catch (Exception e) {
			model.addAttribute("mydata", e.getMessage());//padod kļudas ziņu uz error-page.html lapu
			return "error-page";//parādām pašu error-page.html lapu interneta pārlūkā

		}
	}
	
}
