package pororo.logicinference.service;

import org.springframework.http.ResponseEntity;
import pororo.logicinference.dto.request.NumberCheckReq;
import pororo.logicinference.dto.request.StartGameReq;

public interface NumberInferenceService {

  ResponseEntity<?> initGame(StartGameReq request);

  ResponseEntity<?> validateNumber(NumberCheckReq request);

  ResponseEntity<?> returnNumber();
}
