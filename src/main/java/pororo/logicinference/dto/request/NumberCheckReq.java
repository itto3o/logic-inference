package pororo.logicinference.dto.request;

import java.util.List;
import lombok.Getter;
import pororo.logicinference.common.annotators.ValidListInteger;

@Getter
public class NumberCheckReq {

  @ValidListInteger
  List<Integer> question;
}
