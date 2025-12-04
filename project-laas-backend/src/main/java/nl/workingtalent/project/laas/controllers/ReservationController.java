package nl.workingtalent.project.laas.controllers;

import nl.workingtalent.project.laas.models.Reservation;
import nl.workingtalent.project.laas.services.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ReservationController {

    @Autowired
    ReservationService reservationService;

    @GetMapping("/show/reservations")
    public List<Reservation> list() {
        return reservationService.getAll();
    }
}