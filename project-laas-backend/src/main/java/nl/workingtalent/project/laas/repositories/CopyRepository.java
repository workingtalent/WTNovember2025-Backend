package nl.workingtalent.project.laas.repositories;

import nl.workingtalent.project.laas.models.Copy;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CopyRepository extends JpaRepository<Copy, Long> {

    List<Copy> findByBookId(Integer bookId);
}
