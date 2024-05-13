package lv.venta;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import lv.venta.Model.Course;
import lv.venta.Model.Degree;
import lv.venta.Model.Grade;
import lv.venta.Model.Professor;
import lv.venta.Model.Student;
import lv.venta.repo.ICourseRepo;
import lv.venta.repo.IGradeRepo;
import lv.venta.repo.IProfessorRepo;
import lv.venta.repo.IStudentRepo;

@SpringBootApplication
public class ProginzSeminars2Application {

	public static void main(String[] args) {
		SpringApplication.run(ProginzSeminars2Application.class, args);
	}
	@Bean
	public CommandLineRunner testDB(IStudentRepo studRepo, IProfessorRepo profRepo, IGradeRepo gradeRepo, ICourseRepo courseRepo) {
		
		return new CommandLineRunner() {
			
			@Override
			public void run(String... args) throws Exception{
				Professor p1= new Professor("Karina","Skirmante", Degree.mg);
				Professor p2= new Professor("Vija","Vagale", Degree.phd);
				Professor p3= new Professor("Raita","Rolande", Degree.mg);
				profRepo.save(p1);
				profRepo.save(p2);
				profRepo.save(p3);
				
				Student s1= new Student("Alekss","Grecuhins");
				Student s2= new Student("Vasja","Ahaaa");
				Student s3= new Student("Andris","Zile");
				studRepo.save(s1);
				studRepo.save(s2);
				studRepo.save(s3);
				
				Course c1= new Course("Datu strukturaas", 2, p1);
				Course c2= new Course("Datu bazes", 2, p2);
				Course c3= new Course("Prog Inzenierija", 4, p3);
				courseRepo.save(c1);
				courseRepo.save(c2);
				courseRepo.save(c3);
				
				
				gradeRepo.save(new Grade(5,c1,s1));
				gradeRepo.save(new Grade(7,c2,s1));
				gradeRepo.save(new Grade(9,c3,s1));
				
				gradeRepo.save(new Grade(8,c1,s2));
				gradeRepo.save(new Grade(4,c2,s2));
				gradeRepo.save(new Grade(6,c3,s2));
				
				gradeRepo.save(new Grade(4,c1,s3));
				gradeRepo.save(new Grade(7,c2,s3));
				gradeRepo.save(new Grade(10,c3,s3));
				
				
			}
		};
		
		
		
		
		
	}
	
	
}
