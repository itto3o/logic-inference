package pororo.logicinference.common.utils;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.springframework.stereotype.Component;

@Component
public class RandomIntListGenerator {

  public static List<Integer> getUniqueRandomIntList(Integer length, Integer min, Integer max) {
//    List<Integer> list = new ArrayList<>();
//
//    new Random()
//        .ints(min, max + 1)
//        .limit(length)
//        .distinct() // 이렇게 하니까 4개를 뽑고 난 후에 distinct를 해서 list size가 줄음
//        .forEach(list::add);

    Set<Integer> randomSet = new HashSet<>();

    while (randomSet.size() < length) {
      int random = new SecureRandom().nextInt(max + 1) + min;

      randomSet.add(random);
    }

    List<Integer> result = new ArrayList<>(randomSet);

    Collections.shuffle(result);

    return result;
  }
}
