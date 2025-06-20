package com.tcs.booking.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tcs.booking.dto.ApiResponse;
import com.tcs.booking.model.Ticket;
import com.tcs.booking.service.TicketService;

@RestController
@RequestMapping("/api")
public class TicketController {

    @Autowired
    private TicketService ticketService;

    @GetMapping("/fetch_ticket_details/{ticketId}")
    public ResponseEntity<ApiResponse<Ticket>> getTicket(@PathVariable Long ticketId) {
        return ResponseEntity.ok(ApiResponse.success(ticketService.getTicket(ticketId)));
    }
}
