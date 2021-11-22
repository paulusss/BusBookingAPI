package com.periksabus2.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.periksabus2.model.Penumpang;

public interface PenumpangRepository extends JpaRepository<Penumpang, String> {
	List <Penumpang> findByNik(String nik);
}
