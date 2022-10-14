package kz.areal.springpractice.repositories;

import kz.areal.springpractice.models.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PeopleRepository extends JpaRepository<Person, Integer> {
    Optional<Person> findByUsername(String username);

    @Query("SELECT c FROM Person c WHERE c.email = ?1")
    Person findByEmail(String email);

    Person findByResetPasswordToken(String token);
}
