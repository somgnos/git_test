package myFirstSpring.HelloSpring.DTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ChatHistoryDTO {
    private Long id;
    private String question;
    private String answer;
    private LocalDateTime askedAt;
}
