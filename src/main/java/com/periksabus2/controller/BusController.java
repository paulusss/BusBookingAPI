package com.periksabus2.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.periksabus2.model.Booking;
import com.periksabus2.model.KeberangkatanDetail;
import com.periksabus2.model.Penumpang;
import com.periksabus2.repository.BookingRepository;
import com.periksabus2.repository.KeberangkatanRepository;
import com.periksabus2.repository.PenumpangRepository;

@RestController
@RequestMapping("/busbookingsystem")
public class BusController {
	@Autowired
	PenumpangRepository penumpangRepo;
	
	@Autowired
	KeberangkatanRepository keberangkatanRepo;

	@Autowired
	BookingRepository bookingRepo;
	
	@PostMapping("/insertPenumpang")
	public String insertDataPenumpang(@RequestBody Penumpang penumpang) {
		penumpangRepo.save(penumpang);
		return "Data penumpang berhasil ditambahkan";
	}
	
	@GetMapping("/getPenumpang/{nik}")
	public String getPenumpang(@PathVariable String nik) {
		List<Penumpang> anu = penumpangRepo.findByNik(nik);
		String message = "";
		if (anu.isEmpty()) {
			message = "Penumpang belum terdaftar, silakan buat akun.";
		}else {
			message = "Penumpang telah terdaftar";
		}
		return message;
	}
	
	@GetMapping("/findKeberangkatan")
	public List<KeberangkatanDetail> findKeberangkatan(@RequestParam (value = "terminal_awal") String terminal_awal, 
			@RequestParam (value = "tanggal") String tanggal){
		return keberangkatanRepo.getDetail(terminal_awal, tanggal)	;
	}
	
	@PostMapping("/booking")
	public String booking(@RequestBody Booking booking) {
		bookingRepo.save(booking);
		return "Pemesanan bus berhasil";
	}
	
	@DeleteMapping("/cancel")
	public String cancel(@RequestParam (value = "id") Long id) {
		bookingRepo.deleteById(id);
		return "Pemesanan dengan nomor id "+id+" telah dibatalkan";
	}
}
