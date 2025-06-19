package pororo.logicinference.common.validators;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import java.util.Arrays;
import pororo.logicinference.common.annotators.ValidEnumAnnotation;

// ConstraintValidator: 유효성 검사 위함, ValidEnum: 어노테이션 타입, String: 검증 대상 필드 타입
public class EnumValidator implements ConstraintValidator<ValidEnumAnnotation, String> {
  private Class<? extends Enum<?>> enumClass;

  // 검증할 enum class 타입 저장, 어노테이션에서 전달된 값을 가져옴
  @Override
  public void initialize(ValidEnumAnnotation constraintAnnotation) {
    this.enumClass = constraintAnnotation.enumClass();
  }

  // 입력값 value가 enumClass에 포함되어있는지 확인
  @Override
  public boolean isValid(String value, ConstraintValidatorContext context) {
    // null 허용, 필수 여부는 @NotNull로 처리
    if (value == null) {
      return true;
    }

    // Arrays.stream: 배열 -> 스트림
    // enumClass.getEnumConstants(): 지정된 enumClass의 모든 Enum 값을 배열로 반환
    // .anyMatch: 요소 중 하나라도 value와 동일한 이름을 가진 상수가 있는지 확인
    return Arrays.stream(enumClass.getEnumConstants()).anyMatch(e -> e.name().equals(value));
  }
}
