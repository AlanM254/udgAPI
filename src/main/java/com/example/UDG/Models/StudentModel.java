package com.example.UDG.Models;

import jakarta.persistence.*;

@Entity
@Table(name = "students")
public class StudentModel {
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   @Column(nullable = false,unique = true)
   private Long id;
   private Integer code;
   private String name;
   private String email;
   private String degree;
   private Double score;

   public Long getId() {
      return id;
   }

   public void setId(Long id) {
      this.id = id;
   }

   public Integer getCode() {
      return code;
   }

   public void setCode(Integer code) {
      this.code = code;
   }

   public String getName() {
      return name;
   }

   public void setName(String name) {
      this.name = name;
   }

   public String getEmail() {
      return email;
   }

   public void setEmail(String email) {
      this.email = email;
   }

   public String getDegree() {
      return degree;
   }

   public void setDegree(String degree) {
      this.degree = degree;
   }

   public Double getScore() {
      return score;
   }

   public void setScore(Double score) {
      this.score = score;
   }
}
