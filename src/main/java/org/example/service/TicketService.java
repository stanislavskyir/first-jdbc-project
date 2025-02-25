package org.example.service;

import org.example.dao.TicketDao;
import org.example.dto.TicketDto;

import java.util.List;
import java.util.stream.Collectors;

public class TicketService {
    private final static TicketService INSTANCE = new TicketService();
    private TicketService() {}

    public static TicketService getInstance() {
        return INSTANCE;
    }

    private final TicketDao ticketDao = TicketDao.getInstance();

    public List<TicketDto> findAllByFlightId(Long flightId) {
        return ticketDao.findAllByFlightId(flightId).stream().map( ticket ->
                new TicketDto(
                        ticket.getId(),
                        ticket.getFlight().getId(),
                        ticket.getSeatNumber())).collect(Collectors.toList());
    }

    /*
        public List<FlightDto> findAll(){
        return flightDao.findAll().stream().map( flight ->
                new FlightDto(flight.getId(), "%s - %s - %s".formatted(
                        flight.getArrivalAirportCode(),
                        flight.getDepartureAirportCode(),
                        flight.getStatus()
                ))).collect(Collectors.toList());
    }
     */
}
