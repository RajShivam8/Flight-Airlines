package com.Flight_Reservation_App.Rest_Controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Flight_Reservation_App.entity.Reservation;
import com.Flight_Reservation_App.repository.ReservationRepository;
import com.Flight_Reservation_App.utilities.ReservationUpdateRequest;

@RestController
public class ReservationRestController {
	@Autowired
	private ReservationRepository reservationRepo;
	
	@GetMapping("/reservation/{id}")
	public Reservation findReservation(@PathVariable ("id") Long  id) {
		Optional<Reservation> findById = reservationRepo.findById(id);
		Reservation reservation = findById.get();
		return reservation;
	}
	
	@RequestMapping("/reservation")
	public Reservation updateReservation(@RequestBody ReservationUpdateRequest request) {
		Optional<Reservation> findById = reservationRepo.findById(request.getId());
		Reservation reservation = findById.get();
		reservation.setCheckedIn(request.isCheckedIn());
		reservation.setNumberOfBags(request.getNumberOfBags());
		return reservationRepo.save(reservation);
		
		
	}

}
