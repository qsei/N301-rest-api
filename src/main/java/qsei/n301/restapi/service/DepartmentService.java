package qsei.n301.restapi.service;

import org.springframework.stereotype.Service;
import qsei.n301.restapi.persistance.Department;
import qsei.n301.restapi.persistance.DepartmentRepository;

import java.util.List;
import java.util.Optional;

@Service
public class DepartmentService {

  DepartmentRepository repository;

  public DepartmentService(DepartmentRepository repository) {
    this.repository = repository;
  }

  public List<Department> getAll(){
    return this.repository.findAll();
  }

  public Department getById(Long id){
    return this.repository.findById(id).get();
  }

  public Department add(Department department){
    return this.repository.save(department);
  }


  public Department update(Long id, Department department){
    Optional<Department> dept = this.repository.findById(id);
    if(dept.isPresent()){
      dept.get().setName(department.getName());
      return this.repository.save(dept.get());
    }
    throw new RuntimeException();
  }

  public void delete(Long id){
    this.repository.deleteById(id);
  }

}
