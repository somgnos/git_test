package myFirstSpring.HelloSpring.domain;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "chat_history")
public class ChatHistory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String question;

    @Column(columnDefinition = "TEXT")
    private String answer;
    private LocalDateTime askedAt;

    public ChatHistory() {
        super();
    }

    public ChatHistory(String question, String answer, LocalDateTime askedAt) {
        this.question = question;
        this.answer = answer;
        this.askedAt = askedAt;
    }

}

