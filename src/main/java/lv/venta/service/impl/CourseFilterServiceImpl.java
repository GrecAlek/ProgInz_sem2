package lv.venta.service.impl;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lv.venta.Model.Course;
import lv.venta.repo.ICourseRepo;
import lv.venta.repo.IProfessorRepo;
import lv.venta.repo.IStudentRepo;
import lv.venta.service.ICourseFilterService;

@Service
public class CourseFilterServiceImpl implements ICourseFilterService{
	
	@Autowired
	private ICourseRepo courseRepo;
	
	private IProfessorRepo profRepo;
	
	private IStudentRepo studentRepo;

	@Override
	public ArrayList<Course> selectCoursesByCreditPoints(int creditPoints) throws Exception {
		if(creditPoints<1 || creditPoints>20)throw new Exception("Problem with input");
		
		ArrayList<Course> result =courseRepo.findByCreditpoints(creditPoints);
		
		if(result.isEmpty()) throw new Exception("Empty");
		
		return result;
	}

	@Override
	public Course selectCourseByProfessorID(int id) throws Exception {
		
		if(id<1)throw new Exception("It has to be positive!");
		
		if(profRepo.existsById(id))throw new Exception("Professor with this ID doesnt exist");
		
		
		Course result=courseRepo.findByProfessorIdp(id);
		
		if(result==null)throw new Exception("There is no course for this professor!");
		
		return result;
	}

	@Override
	public ArrayList<Course> slectCoursesByStudentID(int id) throws Exception {
	
		if(id<1)throw new Exception("ID has to be positive!");
		
		if(studentRepo.existsById(id))throw new Exception("Student with bthis ID doesnt exists!");
		
		ArrayList<Course> result = courseRepo.findByStudentIds(id);
		
		if(result.isEmpty()) throw new Exception("Empty");
		
		return result;
	}
	

}
