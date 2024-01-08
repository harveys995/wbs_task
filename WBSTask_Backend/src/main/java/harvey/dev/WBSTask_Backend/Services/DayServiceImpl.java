package harvey.dev.WBSTask_Backend.Services;
import harvey.dev.WBSTask_Backend.Repositories.CompetitionDataRepository;
import harvey.dev.WBSTask_Backend.Repositories.CompetitionRepository;
import harvey.dev.WBSTask_Backend.Repositories.DayRepository;
import harvey.dev.WBSTask_Backend.Entities.Competition;
import harvey.dev.WBSTask_Backend.Entities.CompetitionData;
import harvey.dev.WBSTask_Backend.Entities.Day;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class DayServiceImpl implements DayService{
    private final DayRepository dayRepository;
    private final CompetitionRepository competitionRepository;
    private final CompetitionDataRepository competitionDataRepository;

    @Autowired
    public DayServiceImpl(DayRepository dayRepository, CompetitionRepository competitionRepository, CompetitionDataRepository competitionDataRepository) {
        this.dayRepository = dayRepository;
        this.competitionRepository = competitionRepository;
        this.competitionDataRepository = competitionDataRepository;
    }

    @Override
    public Day saveDay() {
        Day day = new Day();
        return dayRepository.save(day);
    }

    @Override
    public Competition saveCompetition(Competition competition) {
        return competitionRepository.save(competition);
    }

    @Override
    public CompetitionData saveCompetitionData(CompetitionData competitionData) {
        return competitionDataRepository.save(competitionData);
    }

    @Override
    public List<Day> getAllDays() {
        return dayRepository.findAll();
    }

    @Override
    public Day getDayById(Long id) {
        return dayRepository.findById(id).orElse(null);
    }
}
