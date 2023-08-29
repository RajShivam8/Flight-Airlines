package com.Flight_Reservation_App.service;

import com.Flight_Reservation_App.dto.ReservationRequest;
import com.Flight_Reservation_App.entity.Reservation;

public interface ReservationService {

	Reservation bookFlight(ReservationRequest request);
}
