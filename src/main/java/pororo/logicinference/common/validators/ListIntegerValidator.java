package pororo.logicinference.common.validators;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import java.util.List;
import lombok.RequiredArgsConstructor;
import pororo.logicinference.common.annotators.ValidListInteger;
import pororo.logicinference.common.enumerations.LevelEnum;
import pororo.logicinference.common.manager.GameManager;

@RequiredArgsConstructor
public class ListIntegerValidator implements ConstraintValidator<ValidListInteger, List<Integer>> {

  private final GameManager gameManager;

  @Override
  public boolean isValid(List<Integer> list, ConstraintValidatorContext context) {
    if (list == null || list.isEmpty()) {
      return true;
    }

    LevelEnum level = gameManager.getLevel();

    return list.stream().allMatch(integer -> integer >= 0 && integer <= level.getMaxNumber());
  }

}
