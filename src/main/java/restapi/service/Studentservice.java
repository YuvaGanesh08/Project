package restapi.service;

import java.util.List;

import restapi.Entity.Student;

public interface Studentservice {

	 Student saveStudent(Student student);
	 List<Student> getallStudents();
	 Student getstudentbyId(Long id);
	 Student updatestudent(Student student,Long id);
	 Student deletestudent(Long id);
}
