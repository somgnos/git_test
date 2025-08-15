package myFirstSpring.HelloSpring.controller;
import myFirstSpring.HelloSpring.domain.ChatHistory;
import myFirstSpring.HelloSpring.service.ChatHistoryService;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/history")
public class ChatHistoryController {

    private final ChatHistoryService chatHistoryService;

    public ChatHistoryController(ChatHistoryService chatHistoryService) {
        this.chatHistoryService = chatHistoryService;
    }

    /**
     * 1. 가장 최근 대화 순 조회
     * 예: GET /api/history/recent?limit=5
     */
    @GetMapping("/recent")
    public List<ChatHistory> getRecentChats(@RequestParam(defaultValue = "10") int limit) {
        return chatHistoryService.getRecentChats(limit);
    }

    /**
     * 2. 특정 기간 대화 조회
     * 예: GET /api/history/period?start=2025-08-01T00:00:00&end=2025-08-13T23:59:59
     */
    @GetMapping("/period")
    public List<ChatHistory> getChatsByPeriod(@RequestParam String start,
                                              @RequestParam String end) {
        return chatHistoryService.getChatsByPeriod(
                LocalDateTime.parse(start),
                LocalDateTime.parse(end)
        );
    }

    /**
     * 3. 질문에 특정 키워드가 포함된 대화 조회
     * 예: GET /api/history/question?keyword=카페
     */
    @GetMapping("/question")
    public List<ChatHistory> getChatsByQuestionKeyword(@RequestParam String keyword) {
        return chatHistoryService.getChatsByQuestionKeyword(keyword);
    }

    /**
     * 4. 답변에 특정 단어가 포함된 대화 조회
     * 예: GET /api/history/answer?keyword=부가세
     */
    @GetMapping("/answer")
    public List<ChatHistory> getChatsByAnswerKeyword(@RequestParam String keyword) {
        return chatHistoryService.getChatsByAnswerKeyword(keyword);
    }

    /**
     * 5. 특정 키워드 필터 후 최신 순 조회
     * 예: GET /api/history/latest?keyword=카페&limit=3
     */
    @GetMapping("/latest")
    public List<ChatHistory> getLatestChatsByKeyword(@RequestParam String keyword,
                                                     @RequestParam(defaultValue = "5") int limit) {
        return chatHistoryService.getLatestChatsByKeyword(keyword, limit);
    }
}

