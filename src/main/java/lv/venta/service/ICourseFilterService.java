package lv.venta.service;

import java.util.ArrayList;

import lv.venta.Model.Course;

public interface ICourseFilterService {

	public abstract ArrayList<Course>selectCoursesByCreditPoints(int creditPoints) throws Exception;
	
	
	public abstract Course selectCoursesByProfessorID(int id)throws Exception;
	
	
	public abstract ArrayList<Course>slectCoursesByStudentID(int id)throws Exception;
	
	
	
	
}
