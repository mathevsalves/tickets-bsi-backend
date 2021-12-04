package br.com.bsi.pi.ticketsbsi.resources;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.bsi.pi.ticketsbsi.services.DashboardService;

@RestController
@RequestMapping(value = "/dashboard")
@CrossOrigin(origins = "*")
public class DashboardResource {

    final private DashboardService service;

    public DashboardResource(DashboardService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<Object> findDashboard() {
        return ResponseEntity.ok().body(this.service.findDashboard());
    }

    @GetMapping(value = "address")
    public ResponseEntity<Object> findDashboardAddress() {
        return ResponseEntity.ok().body(this.service.findDashboardAddress());
    }

}
