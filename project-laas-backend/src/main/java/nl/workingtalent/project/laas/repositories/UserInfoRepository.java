package nl.workingtalent.project.laas.repositories;

import nl.workingtalent.project.laas.models.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserInfoRepository extends JpaRepository<Account, Integer> {
    Optional<Account> findByUsername(String username);
}
