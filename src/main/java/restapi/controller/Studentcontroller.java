package restapi.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import restapi.Entity.Student;
import restapi.service.Studentservice;

@RestController
@RequestMapping("/api/students") //like base url, foll all api requests
public class Studentcontroller {

	private Studentservice studentservice;

	public Studentcontroller(Studentservice studentservice) {
		super();
		this.studentservice = studentservice;
	}
	
	@PostMapping() //if base url is not given, url has to be specified here 
	public ResponseEntity<Student> saveStudent(@RequestBody Student student) { 
	//responseentity returns all the details incl http status, header ,body etc.
	//responsebody gets the body of the request i.e(json where we give details and converts into java object)
		return new ResponseEntity<Student>(studentservice.saveStudent(student), HttpStatus.CREATED);
		//returning object of responseentity along with body,httpstatus
	}
		
	@GetMapping()
	public List<Student> getallStudents(){
		return studentservice.getallStudents();
	}
	
	@GetMapping("{id}")
	public ResponseEntity<Student> getstudentbyId(@PathVariable("id") Long id){
		return new ResponseEntity<Student>(studentservice.getstudentbyId(id), HttpStatus.OK);
		
	}
	
	
	@PutMapping("{id}")
	public ResponseEntity<Student> updatestudent(@PathVariable("id") Long id,@RequestBody Student student){
		return new ResponseEntity<Student>(studentservice.updatestudent(student,id), HttpStatus.OK);
		
	}
	
	@DeleteMapping("{id}")
	public ResponseEntity<String> deletestudent(@PathVariable("id") Long id){
		studentservice.deletestudent(id);
		return new ResponseEntity<String>("Deleted Successfully",HttpStatus.OK);
		
	}
}
