package com.example.MyBookShopApp.repositoryes;

import org.springframework.data.jpa.repository.JpaRepository;
import skbx.example.struct.Author;


public interface AuthorRepository extends JpaRepository<Author,Integer>{

}
