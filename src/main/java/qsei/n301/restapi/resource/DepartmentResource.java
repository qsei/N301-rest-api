package qsei.n301.restapi.resource;

import org.springframework.web.bind.annotation.*;
import qsei.n301.restapi.persistance.Department;
import qsei.n301.restapi.service.DepartmentService;


import java.util.List;
import java.util.Optional;

@RestController
public class DepartmentResource {

  DepartmentResource service;

  public DepartmentResource(DepartmentResource service){
    this.service = service;
  }

  @GetMapping(value = "/departments")
  public List<Department> getAll(){
    return this.service.getAll();
  }

  @GetMapping(value = "/departments/{id}")
  public Department getById(@PathVariable Long id){
    return this.service.getById(id);
  }

  @PostMapping(value = "/departments")
  public Department add(Department department){
    return this.service.add(department);
  }

  @PutMapping(value = "/departments/{id}", consumes = "application/json")
  public Department update(@PathVariable Long id, @RequestBody Department department){
    return this.service.update(id,department);

  }

  @DeleteMapping(value = "/departments/{id}")
  public void delete(@PathVariable Long id){
    this.service.delete(id);
  }




}
