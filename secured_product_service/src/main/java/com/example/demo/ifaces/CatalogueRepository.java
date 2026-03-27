package com.example.demo.ifaces;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.dtos.ResponseDto;
import com.example.demo.entity.Catalogue;
import com.example.demo.entity.Product;

public interface CatalogueRepository extends JpaRepository<Catalogue, Integer> {

		
}
