package nl.workingtalent.project.laas.services;

import nl.workingtalent.project.laas.models.Reservation;
import nl.workingtalent.project.laas.repositories.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReservationService {

    @Autowired
    private ReservationRepository reservationRepository;

    public List<Reservation> getAll() {
        return reservationRepository.findAll();
    }
}
