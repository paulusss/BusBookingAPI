package com.periksabus2.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.periksabus2.model.Booking;

public interface BookingRepository extends JpaRepository<Booking, Long> {

}
