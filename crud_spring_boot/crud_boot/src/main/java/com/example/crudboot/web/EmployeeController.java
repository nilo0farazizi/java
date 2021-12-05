package com.example.crudboot.web;

import com.example.crudboot.model.EmployeeEntity;
import com.example.crudboot.repository.EmployeeRepository;
import com.example.crudboot.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/employees")
public class EmployeeController
{
    @Autowired
    EmployeeService service;

    @Autowired
    EmployeeRepository employeeRepository;

    @GetMapping
    public String getAllEmployees(Model model) {
        List<EmployeeEntity> list = service.getAllEmployees();
        model.addAttribute("employees", list);
            return "list-employees";
    }

    @GetMapping("/{id}")
    public ResponseEntity<EmployeeEntity> getEmployeeById(@PathVariable("id") Long id)
                                                    {
        EmployeeEntity entity = service.getEmployeeById(id);

        return new ResponseEntity<>(entity, new HttpHeaders(), HttpStatus.OK);
    }

    @GetMapping("/signup")
    public String showSignUpForm(EmployeeEntity employeeEntity) {
        return "add-edit-employee";
    }



    @PostMapping("/adduser")
    public String createEmployee(@Valid EmployeeEntity employeeEntity, BindingResult result, Model model)
                                                    {
                                                        if (result.hasErrors()) {
                                                            return "add-edit-employee";
                                                        }
        EmployeeEntity updated = service.createEmployee(employeeEntity);
        return "redirect:/list-employees";
    }


    @DeleteMapping("delete/{id}")
    public String deleteEmployeeById(@PathVariable("id") Long id){

    EmployeeEntity user = employeeRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid user Id:" + id));
        employeeRepository.delete(user);
        return "redirect:/list-employees";
//                                                   {
//        service.deleteEmployeeById(id);
     //   return HttpStatus.FORBIDDEN;
    }
 
}