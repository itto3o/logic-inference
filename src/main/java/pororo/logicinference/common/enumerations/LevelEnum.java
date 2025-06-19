package pororo.logicinference.common.enumerations;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;

@Getter
@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum LevelEnum {

  EASY("EASY", "쉬움 난이도", 7, 3, 4),
  NORMAL("NORMAL", "보통 난이도", 7, 6, 4),
  HARD("HARD", "어려움 난이도", 7, 9, 4);

  private final String level;
  private final String description;
  private final Integer maxTrial;
  private final Integer maxNumber;
  private final Integer size;

  LevelEnum(String level, String description, Integer maxTrial,  Integer maxNumber, Integer size) {
    this.level = level;
    this.description = description;
    this.maxTrial = maxTrial;
    this.maxNumber = maxNumber;
    this.size = size;
  }

}
