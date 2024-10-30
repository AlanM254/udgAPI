package com.example.UDG.repositories;

import com.example.UDG.Models.StudentModel;
import com.fasterxml.jackson.databind.introspect.TypeResolutionContext;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Optional;

@Repository

public interface StudentRepository extends CrudRepository<StudentModel,Long>{

    //editar
    //buscar por código
    public  abstract Optional<StudentModel> findByCode(Integer code);

    //buscar por  nombre
    public abstract Optional<ArrayList<StudentModel>> findByName(String name);

    //eliminar por código
    public abstract String deleteByCode(Integer code);

}

