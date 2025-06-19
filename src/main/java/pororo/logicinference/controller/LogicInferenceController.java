package pororo.logicinference.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import pororo.logicinference.dto.request.NumberCheckReq;
import pororo.logicinference.dto.request.StartGameReq;
import pororo.logicinference.service.NumberInferenceService;

@RestController
@RequiredArgsConstructor
public class LogicInferenceController {

  private final NumberInferenceService numberInferenceService;

  // game start
  @PostMapping("/start")
  public ResponseEntity<?> startGame(@RequestBody @Valid StartGameReq request) {
    return numberInferenceService.initGame(request);
  }

  // answer check
  @PostMapping("/check")
  public ResponseEntity<?> checkAnswer(@RequestBody NumberCheckReq request) {
    return numberInferenceService.validateNumber(request);
  }

  // return answer
  @GetMapping("/cheat")
  public ResponseEntity<?> getAnswer() {
    return numberInferenceService.returnNumber();
  }
}
