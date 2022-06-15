package restapi.service.serviceimpl;

import java.util.List;


import org.springframework.stereotype.Service;

import restapi.Entity.Student;
import restapi.exception.StudentException;
import restapi.repository.Studentrepository;
import restapi.service.Studentservice;

@Service
public class Studentserviceimpl implements Studentservice{

	private Studentrepository studentrepository;
	public Studentserviceimpl(Studentrepository studentrepository) {
		super();
		this.studentrepository = studentrepository;
	}
	@Override
	public Student saveStudent(Student student) {
		return studentrepository.save(student);
		
	}
	@Override
	public List<Student> getallStudents() {
		return studentrepository.findAll();
	}
	@Override
	public Student getstudentbyId(Long id) {
		return studentrepository.findById(id).orElseThrow(()-> new StudentException(null));
	}
	@Override
	public Student updatestudent(Student student, Long id) {
		Student existingStudent=studentrepository.findById(id).orElseThrow(()-> new StudentException(null));
		existingStudent.setUserName(student.getUserName());
		existingStudent.setPassword(student.getPassword());
		existingStudent.setName(student.getName());
		existingStudent.setEmail(student.getEmail());
		studentrepository.save(existingStudent);
		return existingStudent;
	}
	@Override
	public Student deletestudent(Long id) {
		studentrepository.findById(id).orElseThrow(()-> new StudentException(null));
		studentrepository.deleteById(id);
		return null;
	}
	

	
}
