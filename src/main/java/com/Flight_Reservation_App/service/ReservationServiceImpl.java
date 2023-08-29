package com.Flight_Reservation_App.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Flight_Reservation_App.dto.ReservationRequest;
import com.Flight_Reservation_App.entity.Flight;
import com.Flight_Reservation_App.entity.Passenger;
import com.Flight_Reservation_App.entity.Reservation;
import com.Flight_Reservation_App.repository.FlightRepository;
import com.Flight_Reservation_App.repository.PassengerRepository;
import com.Flight_Reservation_App.repository.ReservationRepository;
import com.Flight_Reservation_App.utilities.PdfGenerator;

@Service
public class ReservationServiceImpl implements ReservationService {
	@Autowired
	private ReservationRepository reservationRepo;
   @Autowired
	private PassengerRepository passengerRepo;
	@Autowired
	private FlightRepository flightRepo;
	
	@Autowired
	PdfGenerator pdf;


@Override
public Reservation bookFlight(ReservationRequest request) {
	long flightId = request.getFlightId();
	Optional<Flight> findById = flightRepo.findById(flightId);
	Flight flight = findById.get();
	
	Passenger passenger = new Passenger();
	passenger.setFirstName(request.getFirstName());
	passenger.setLastName(request.getLastName());
	passenger.setEmail(request.getEmail());
	passenger.setPhone(request.getPhone());
	passengerRepo.save(passenger);
	
	
	
	Reservation reservation = new Reservation();
	reservation.setFlight(flight);
	reservation.setPassenger(passenger);
	reservation.setCheckedIn(false);
	reservation.setNumberOfBags(0);
	reservationRepo.save(reservation);
	String filePath="E:\\stscode\\Flight_Reservation_App\\ticket\\reservation"+reservation.getId()+".pdf";
	pdf.generatePDF(filePath, reservation.getPassenger().getFirstName(), reservation.getPassenger().getEmail(), reservation.getPassenger().getPhone(), reservation.getFlight().getOperatingAirlines(), reservation.getFlight().getDateOfDeparture(), reservation.getFlight().getDepartureCity(), reservation.getFlight().getArrivalCity());
	return reservation;
}
  }
