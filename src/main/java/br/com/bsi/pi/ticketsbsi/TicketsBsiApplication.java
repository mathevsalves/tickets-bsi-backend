package br.com.bsi.pi.ticketsbsi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication
public class TicketsBsiApplication {

	public static void main(String[] args) {
		SpringApplication.run(TicketsBsiApplication.class, args);
	}

}
