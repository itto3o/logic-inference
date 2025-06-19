package pororo.logicinference.common.manager;

import java.util.List;
import java.util.stream.Collectors;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;
import pororo.logicinference.common.enumerations.LevelEnum;

@Data
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Component
public class GameManager {

  private List<Integer> answerList;

  private Integer trial;

  private LevelEnum level;

  public String getAnswer() {

    // ForEach Example Start
//    List<Integer> ansList = new ArrayList<>();
//    List<String> ansStringList = new ArrayList<>();
//
////    answerList.forEach(answer -> {
////      ansList.add(String.valueOf(answer));
////    });
//    // ↓
//    answerList.forEach(ansList::add);
//    // ForEach Example End
//
//    @Getter
//    class Dto {
//      String id;
//      Integer answer;
//      LocalDateTime createAt;
//
//      public Dto(String id, Integer answer, LocalDateTime createAt) {
//        this.id = id;
//        this.answer = answer;
//        this.createAt = createAt;
//      }
//    }
//    List<Dto> originList = new ArrayList<>();
//    LocalDateTime now = LocalDateTime.now();
//
//    for (int i = 1; i <= 10; i++) {
//      originList.add(new Dto(String.valueOf(i), i, now.plusDays(i)));
//    }

//    String ans = originList.stream()
//        .map(Dto::getAnswer) // .map(item -> item.getAnswer())
//        .map(String::valueOf)
//        .collect(Collectors.joining(""));
//
//    String ans = originList.stream()
//        .map(item -> {
//          return String.valueOf(item.getAnswer());
//        })
//        .collect(Collectors.joining(""));
//
//    // Step 1 Start
//    StringBuilder ansBuilder = new StringBuilder();
//
//    for (Integer answer : answerList) {
//      ansBuilder.append(answer);
//    }
//
//    String ans = ansBuilder.toString();
//    // Step 1 End
//
//    // Step 2 Start
//    List<String> ansList = new ArrayList<>();
//
//    for (Integer answer : answerList) {
//      ansList.add(String.valueOf(answer));
//    }
//
//    String ans = String.join("", ansList);
//    // Step 2 End
//
//    // Step 3 Start
//    List<String> ansList = new ArrayList<>();
//
////    answerList.forEach(answer -> {
////      ansList.add(String.valueOf(answer));
////    });
//    // ↓
//    answerList.forEach(answer -> ansList.add(String.valueOf(answer)));
//
//    String ans = String.join("", ansList);
//    // Step 3 End
//
//    // Step 4 Start
//    // Step 4 End
//    List<String> answerStringList = answerList.stream()
////        .map(answer -> {// list 의 item 요소를 하나씩 조회하여 원하는 값을 반환하는 method. 반환은 Stream<반환 데이터> 로 되기 때문에 array, list, map 등의 형태로 변환하는 추가 작업이 필요
////          return String.valueOf(answer);
////        })
//        // ↓
////        .map(answer -> String.valueOf(answer))
//        // ↓
//        .map(String::valueOf) // lambda 식을 쓰면 String.valueOf 라는 method 가 실행되며 해당 method 의 parameter 로는 item 자체가 들어가게 됩니다.
//        .collect(Collectors.toList()); // Stream<?> 을 List<?> 로 반환하는 method
//
//    String ans = String.join("", answerStringList);

    // Step 5 Start
//    String ans = answerList.stream().map(String::valueOf)
//        .collect(Collectors.joining("")); // map 으로 반환된 Stream<?> 을 Collectors 의 joining 을 사용하여 문자로 반환하는 method
//    // Step 5 End

    return answerList.stream().map(String::valueOf)
        .collect(Collectors.joining(""));
  }

  public Integer getAnswerElement(int index) {
    return answerList.get(index);
  }

}
