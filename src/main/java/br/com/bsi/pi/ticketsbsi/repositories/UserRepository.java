package br.com.bsi.pi.ticketsbsi.repositories;

import br.com.bsi.pi.ticketsbsi.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

    public User findByEmail(String email);
}
