package harvey.dev.WBSTask_Backend.Repositories;

import harvey.dev.WBSTask_Backend.Entities.Competition;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompetitionRepository extends JpaRepository<Competition, Long> {
}
