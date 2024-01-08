package harvey.dev.WBSTask_Backend.Entities;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDate;
import java.util.List;
@Getter
@Setter
@Entity
@Table(name = "day")
public class Day {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate date;

    @OneToMany(mappedBy = "day", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Competition> competitions;
    public Day() {
        this.date = LocalDate.parse("2023-06-19");
    }

    public void moveToNextDay() {
        this.date = date.plusDays(1);
    }
}
