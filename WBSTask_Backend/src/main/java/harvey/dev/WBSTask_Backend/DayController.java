package harvey.dev.WBSTask_Backend;
import harvey.dev.WBSTask_Backend.Entities.Competition;
import harvey.dev.WBSTask_Backend.Entities.CompetitionData;
import harvey.dev.WBSTask_Backend.Entities.Day;
import harvey.dev.WBSTask_Backend.Services.DayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/days")
public class DayController {

    private final DayService dayService;

    @Autowired
    public DayController(DayService dayService) {
        this.dayService = dayService;
    }

    @PostMapping
    public ResponseEntity<String> createDay(@RequestBody Map<String, List<CompetitionDataDto>> competitionsData) {
        try {
            Day day = dayService.saveDay();
            for (Map.Entry<String, List<CompetitionDataDto>> entry : competitionsData.entrySet()) {
                String competitionName = entry.getKey();
                List<CompetitionDataDto> competitionDataList = entry.getValue();

                Competition competition = new Competition();
                competition.setName(competitionName);
                competition.setDay(day);
                dayService.saveCompetition(competition);

                for (CompetitionDataDto competitionDataDto : competitionDataList) {
                    CompetitionData competitionData = new CompetitionData();
                    competitionData.setValue(competitionDataDto.getValue());
                    competitionData.setTeam(competitionDataDto.getTeam());
                    competitionData.setCompetition(competition);
                    dayService.saveCompetitionData(competitionData);
                }
            }

            return ResponseEntity.ok("Day created successfully");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error creating day: " + e.getMessage());
        }
    }

    @GetMapping
    public List<Day> getAllDays() {
        return dayService.getAllDays();
    }

    @GetMapping("/{id}")
    public Day getDayById(@PathVariable Long id) {
        return dayService.getDayById(id);
    }
}
