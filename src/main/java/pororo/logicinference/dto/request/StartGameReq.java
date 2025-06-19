package pororo.logicinference.dto.request;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import pororo.logicinference.common.annotators.ValidEnumAnnotation;
import pororo.logicinference.common.enumerations.LevelEnum;

@Getter
public class StartGameReq {

  @ValidEnumAnnotation(enumClass = LevelEnum.class)
  @Value("HARD")
  private String level;

}
