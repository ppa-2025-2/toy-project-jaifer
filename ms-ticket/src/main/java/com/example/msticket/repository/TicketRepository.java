package com.example.msticket.repository;

import org.springframework.data.jpa.repository.JpaRepository;

//import java.util.Optional;

//import org.springframework.data.repository.ListCrudRepository;

import com.example.msticket.repository.entity.Ticket;

public interface TicketRepository extends JpaRepository<Ticket, Long> {
    //Optional<Ticket> findByEmail();

   //Optional<Ticket> findByHandle(String handle);

    //boolean existsByHandle(String handle);
}
