package com.Flight_Reservation_App.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.Flight_Reservation_App.dto.ReservationRequest;
import com.Flight_Reservation_App.entity.Flight;
import com.Flight_Reservation_App.entity.Reservation;
import com.Flight_Reservation_App.repository.FlightRepository;
import com.Flight_Reservation_App.service.ReservationService;
import com.Flight_Reservation_App.utilities.PdfGenerator;

@Controller
public class ReservationController {
	
	@Autowired
	private FlightRepository flightRepo;
	@Autowired
	private ReservationService reservationService;
	
	@RequestMapping("/showCompleteReservation")
    public String showCompleteReservation(@RequestParam("flightId") Long flightId,ModelMap modelMap) {
		Optional<Flight> flightById  = flightRepo.findById(flightId);
    	Flight flight= flightById.get();
    	modelMap.addAttribute("flight",flight);
    	return "showReservation";
    }
	
	@RequestMapping("/confirmRegistration")
	public String confirmRegistration(ReservationRequest request,ModelMap modelMap) {
		Reservation reservationId = reservationService.bookFlight(request);
		modelMap.addAttribute("reservationId",reservationId.getId());
		return "confirmRegistration";
		
	}

}
