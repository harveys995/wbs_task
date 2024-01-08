package harvey.dev.WBSTask_Backend.Services;

import harvey.dev.WBSTask_Backend.Entities.Competition;
import harvey.dev.WBSTask_Backend.Entities.CompetitionData;
import harvey.dev.WBSTask_Backend.Entities.Day;

import java.util.List;

public interface DayService {
    Day saveDay();
    Competition saveCompetition(Competition competition);
    CompetitionData saveCompetitionData(CompetitionData competitionData);
    List<Day> getAllDays();
    Day getDayById(Long id);
}
