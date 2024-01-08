package harvey.dev.WBSTask_Backend.Entities;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
@Entity
@Table(name = "competition_data")
public class CompetitionData {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String value;
    private int team;

    @ManyToOne
    @JoinColumn(name = "competition_id")
    private Competition competition;

}
