package myFirstSpring.HelloSpring.service;

import myFirstSpring.HelloSpring.domain.ChatHistory;
import myFirstSpring.HelloSpring.repository.ChatHistoryRepository;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
@Transactional
public class ChatHistoryService {

    private final ChatHistoryRepository chatHistoryRepository;

    public ChatHistoryService(ChatHistoryRepository chatHistoryRepository) {
        this.chatHistoryRepository = chatHistoryRepository;
    }

    // 1. 가장 최근 대화 순으로 조회 (limit 개수만큼)
    public List<ChatHistory> findAllOrderByAskedAtDesc(int limit) {
        return chatHistoryRepository.findAllOrderByAskedAtDesc(PageRequest.of(0, limit));
    }

    // 2. 특정 기간 대화 조회
    public List<ChatHistory> findByPeriod(LocalDateTime start, LocalDateTime end) {
        return chatHistoryRepository.findByAskedAtBetweenOrderByAskedAtDesc(start, end);
    }

    // 3. 질문에 특정 키워드가 포함된 대화 조회
    public List<ChatHistory> getChatsByQuestionKeyword(String keyword) {
        return chatHistoryRepository.findByQuestionKeyword(keyword);
    }

    // 4. 답변에 특정 단어가 포함된 대화 조회
    public List<ChatHistory> getChatsByAnswerKeyword(String keyword) {
        return chatHistoryRepository.findByAnswer(keyword);
    }

    // 5. 특정 키워드 필터 후 최신 순 조회 (limit 개수만큼)
    public List<ChatHistory> getLatestChatsByKeyword(String keyword, int limit) {
        return chatHistoryRepository.searchQuestionKeyword(keyword, PageRequest.of(0, limit));
    }
}
