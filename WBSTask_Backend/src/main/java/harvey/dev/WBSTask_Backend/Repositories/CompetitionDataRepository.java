package harvey.dev.WBSTask_Backend.Repositories;

import harvey.dev.WBSTask_Backend.Entities.CompetitionData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompetitionDataRepository extends JpaRepository<CompetitionData, Long> {
}
