package com.example.UDG.services;

import com.example.UDG.Models.StudentModel;
import com.example.UDG.repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;


@Service
public class StudentService {
    @Autowired
    StudentRepository studentRepository;

    // obtener estudiantes registrados
    public ArrayList<StudentModel> findAllStudents(){
        return (ArrayList<StudentModel>) studentRepository.findAll();
    }

    //guardar un estudiante
    public String saveStudent(StudentModel student){
        String response;
        if(isStudentCodeUnique(student.getCode())){
            studentRepository.save(student);
            response="Student saved successfully";
        }else {
            response = "No save Student\n This student code already exists";
        }
        return response;
    }

    //buscar por nombre
    public Optional<ArrayList<StudentModel>> findByName(String name){
        return studentRepository.findByName(name);
    }
    //buscar por código
    public Optional<StudentModel> findByCode(Integer code){
        return studentRepository.findByCode(code);
    }

    //eliminar por código
     public String deleteByCode(Integer code){
        String response;
         Optional<StudentModel> foundStudent = findByCode(code);
        if(foundStudent.isPresent()) {
            studentRepository.delete(foundStudent.get());
            response = "Student deleted successfully";
        }else {
            response = "Student not found";
        }
        return response;
     }

     /*/actualizar
    public StudentModel updateStudent(Integer code,StudentModel student){
        return !isStudentCodeUnique(code) ? studentRepository.save(student) : new StudentModel();
    }*/
    private boolean isStudentCodeUnique(Integer code){
        return !findByCode(code).isPresent();
    }
}
