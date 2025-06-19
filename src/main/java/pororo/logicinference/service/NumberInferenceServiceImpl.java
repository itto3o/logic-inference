package pororo.logicinference.service;

import static pororo.logicinference.common.utils.RandomIntListGenerator.getUniqueRandomIntList;

import java.util.HashMap;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import pororo.logicinference.common.enumerations.LevelEnum;
import pororo.logicinference.common.manager.GameManager;
import pororo.logicinference.dto.request.NumberCheckReq;
import pororo.logicinference.dto.request.StartGameReq;
import pororo.logicinference.dto.response.InferenceResultRes;
import pororo.logicinference.dto.response.InferenceResultRes.InferenceResultResBuilder;

@Service
@RequiredArgsConstructor
public class NumberInferenceServiceImpl implements NumberInferenceService {

  private final GameManager gameManager;

  @Override
  public ResponseEntity<?> initGame(StartGameReq request) {
    gameManager.setTrial(0);
    gameManager.setLevel(LevelEnum.valueOf(request.getLevel()));

    LevelEnum level = gameManager.getLevel();

    gameManager.setAnswerList(getUniqueRandomIntList(level.getSize(), 0, level.getMaxNumber()));

    return ResponseEntity.ok(200);
  }

  @Override
  public ResponseEntity<?> validateNumber(NumberCheckReq requestDto) {
    gameManager.setTrial(gameManager.getTrial() + 1);

    AtomicInteger doubleCheck = new AtomicInteger();
    AtomicInteger check = new AtomicInteger();

    if (requestDto.getQuestion().size() == gameManager.getLevel().getSize()) {
      List<Integer> answers = gameManager.getAnswerList();
      List<Integer> questions = requestDto.getQuestion();

      for (int i = 0; i < questions.size(); i++) {
        if (answers.get(i).equals(questions.get(i))) {
          doubleCheck.getAndIncrement();
        } else if (answers.contains(questions.get(i))) {
          check.getAndIncrement();
        }
      }

//      // 2025-05-20 성재책임님 코드 ㅋㅋ
//      questions.stream()
//          // 먼저 답에 포함되는 애들만 추려서 반복문 돌림
//          .map(question -> ValidateNumberData.builder()
//              .index(questionIndex.getAndIncrement())
//              .question(question)
//              .build())
//          .filter(data -> answers.contains(data.getQuestion()))
//          .map(data -> data.getIndex() == answers.indexOf(data.getQuestion()))
//          .forEach(flag -> {
//            if (flag) {
//              doubleCheck.getAndIncrement();
//            } else {
//              check.getAndIncrement();
//            }
//          });
    }

    InferenceResultResBuilder result = InferenceResultRes.builder()
        .doubleCheck(doubleCheck.get())
        .check(check.get());

    if (gameManager.getTrial() >= gameManager.getLevel().getMaxTrial()
        && doubleCheck.get() != gameManager.getLevel().getSize()) {
      result.right(gameManager.getAnswer());
    }

    return ResponseEntity.ok(new HashMap<String, Object>() {{
      put("answer", result.build());
    }});
  }

  @Override
  public ResponseEntity<?> returnNumber() {
    return ResponseEntity.ok(new HashMap<String, Object>() {{
      put("answer", gameManager.getAnswer());
    }});
  }
}
