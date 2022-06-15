package restapi.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import restapi.Entity.Student;

@Repository
public interface Studentrepository extends JpaRepository<Student, Long>{
	
}
