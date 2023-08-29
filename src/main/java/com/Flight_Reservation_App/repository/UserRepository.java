package com.Flight_Reservation_App.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Flight_Reservation_App.entity.User;

public interface UserRepository extends JpaRepository<User,Long> {

	User findByEmail(String emailId);

}
