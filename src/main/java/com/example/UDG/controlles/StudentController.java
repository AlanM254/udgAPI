package com.example.UDG.controlles;

import com.example.UDG.Models.StudentModel;
import com.example.UDG.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;

@CrossOrigin
@RestController
@RequestMapping("/students")
public class StudentController {
    @Autowired
    StudentService studentService;

    //get
    @GetMapping()
    public ArrayList<StudentModel> findAllStudents(){
        return studentService.findAllStudents();
    }

    //post
    @PostMapping()
    public String saveStudent(@RequestBody StudentModel student){
        return studentService.saveStudent(student);
    }

    //editar
    @PutMapping()
    public String  updateStudent(@RequestBody StudentModel student){
        return studentService.saveStudent(student);
    }

    //buscar por codigo
    @GetMapping(path ="/find-by-code") //localhost:8080/students/find-by-code?
    public Optional<StudentModel> findByCode(@RequestParam("code")Integer code){
        return studentService.findByCode(code);
    }

    //buscar por nombre
    @GetMapping(path ="/find-by-name") //localhost:8080/students/find-by-name?
    public Optional<ArrayList<StudentModel>> findByName(@RequestParam("name")String name){
        return studentService.findByName(name);
    }

   //eliminar por código
    @DeleteMapping (path ="/delete-by-code") //localhost:8080/students/delete-by-code?
    public String deleteByCode(@RequestParam("code")Integer code){
        return studentService.deleteByCode(code);
    }

}
