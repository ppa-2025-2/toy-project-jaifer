/*package com.example.msticket.controller;

import com.example.msticket.controller.dto.UserCreatedEventDTO;
import com.example.msticket.domain.TicketBusiness;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Controller responsável pelos endpoints do ms-ticket.
 * Aqui ficam:
 * - endpoints de CRUD de tickets (se você quiser)
 * - endpoint chamado pelo ms-user quando um novo usuário é criado
 */
/*@RestController
@RequestMapping("/tickets")
public class TicketController {

    private final TicketBusiness ticketBusiness;

    public TicketController(TicketBusiness ticketBusiness) {
        this.ticketBusiness = ticketBusiness;
    }

    /**
     * Endpoint chamado pelo ms-user quando um novo usuário é criado.
     *
     * Espera um JSON como:
     * {
     * "userId": 1,
     * "name": "Fulano",
     * "email": "fulano@empresa.com",
     * "role": "DEV"
     * }
     *
     * A partir disso, o ms-ticket deve criar:
     * - 1 ticket de onboarding
     * - 1 ticket para alocação de estação de trabalho
     */
   /* @PostMapping("/user-created")
    public ResponseEntity<Void> onUserCreated(@Valid @RequestBody UserCreatedEventDTO dto) {
        ticketBusiness.createOnboardingAndWorkstationTickets(dto);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    // Se quiser, você pode expor um GET simples para teste:
    // curl -i http://localhost:8080/tickets/ping
    @GetMapping("/ping")
    public ResponseEntity<String> ping() {
        return ResponseEntity.ok("ms-ticket OK");
    }

    // Aqui você pode futuramente colocar endpoints de CRUD de ticket, por exemplo:
    //
    // @GetMapping
    // public ResponseEntity<List<TicketDTO>> listAll() { ... }
    //
    // @PostMapping
    // public ResponseEntity<TicketDTO> createTicket(@RequestBody TicketDTO dto) {
    // ... }
}*/



   package com.example.msticket.controller;

   import com.example.msticket.controller.dto.UserCreatedEventDTO;
   import com.example.msticket.domain.TicketBusiness;
   import org.springframework.http.HttpStatus;
   import org.springframework.http.ResponseEntity;
   import org.springframework.web.bind.annotation.*;

   @RestController
   @RequestMapping("/tickets")
   public class TicketController {

       private final TicketBusiness ticketBusiness;

       public TicketController(TicketBusiness ticketBusiness) {
           this.ticketBusiness = ticketBusiness;
       }

       // chamado pelo ms-user quando um novo usuário é criado
       @PostMapping("/user-created")
       public ResponseEntity<Void> onUserCreated(@RequestBody UserCreatedEventDTO dto) {
           ticketBusiness.createOnboardingAndWorkstationTickets(dto);
           return ResponseEntity.status(HttpStatus.CREATED).build();
       }

       // endpoint só para teste rápido
       @GetMapping("/ping")
       public ResponseEntity<String> ping() {
           return ResponseEntity.ok("ms-ticket OK");
       }
   }
