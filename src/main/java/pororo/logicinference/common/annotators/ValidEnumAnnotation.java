package pororo.logicinference.common.annotators;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import pororo.logicinference.common.validators.EnumValidator;

// @Constraint: 어느 클래스가 이 어노테이션의 동작을 처리할지 지정(지금은 enumvalidator)
@Constraint(validatedBy = EnumValidator.class)
// Target: 이 어노테이션이 적용될 수 있는 위치, FIELD: 필드에 적용 가능, PARAMETER: 메서드 파라미터에 사용 가능
@Target({ElementType.FIELD, ElementType.PARAMETER})
// Retention: 어노테이션이 유지되는 기간, RUNTIME: 런타임동안 어노테이션 정보 유지
@Retention(RetentionPolicy.RUNTIME)
// @interface: annotation 정의
public @interface ValidEnumAnnotation {
  // 유효성 검사가 실패했을 때 반환할 기본 메시지 정의
  String message()  default "Invalid Value. Allowed values are: {enumClass}";

  // Validation 그룹 지정, 특정 그룹에 속한 검증만 실행되도록, 기본값은 빈 배열
  Class<?>[] groups() default {};

  // 추가 메타데이터를 전달하기 위함, 확장 목적
  Class<? extends Payload>[] payload() default {};

  // 검증 대상이 될 Enum class 지정
  // EX. 호출부에서 KeyEnum.class와 같이 enum class를 전달하여 해당 enum 값만 허용 가능
  Class<? extends Enum<?>> enumClass();
}
