# 논리 추론

## Rule

1. 정수는 0-9 까지의 네 가지 정수만 사용한다.
2. 임의의 겹치지 않는 4 자리 정수를 설정한다. (경우의 수 10*9*8*7)
3. 4 정수를 입력하여 설정한 정수와 맞는지 판단한다.
4. 자리와 정수가 맞으면 더블 체크 아이콘으로 표현한다.
5. 정수만 맞으면 체크 아이콘으로 표현한다.
6. 7 번의 기회가 주어진다.

## 1 차 개발 범위

### Front-end

- 작업자: `류성재`
- 작업 영역: `html5` & `css3` & `javascript`

### Back-end

- 작업자: `김서지`
- 작업 영역: `Spring`

### 공통 또는 필수 구현 TASK

- 시작하기

    1. Front-End 에서 Back-End 로 시작 요청
    1. 시작하면 규칙에 맞도록 임의의 네 자리 정수를 생성하여 저장
    1. Back-end 에서 Front-End 성공 메시지 전달

- 검증하기

    1. Front-End 에서 Back-End 로 검증 요청
        - Request

           ```json
           {
               "question": [1, 2, 3, 4]
           }
           ```

        - Response

            - 정답이 아닐 경우

                 ```json
                 {
                     "answer": {
                         "doubleCheck": 1,
                         "check": 1
                     }
                 }
                 ```

            - 정답이 아닌데 시도를 모두 사용한 경우

                 ```json
                 {
                     "answer": {
                         "doubleCheck": 4,
                         "check": 1,
                         "right": 1234
                     }
                 }
                 ```

- 정답 확인

    - Response

      ```json
      {
          "answer": 1234
      }
      ```


## Back-End 구조
Front-End -> Api Controller -> Service

### 필요한 기능
1. Game Start
2. 정답이 맞는지 검증
    1. 틀리면 trial +1
    2. 맞으면 맞다고 res
3. 7회 다 쓰면 Game Over

### Entity - GameManager
```java
    Class GameManager {
      List<Num> answer;
      Integer trialCount;
    }
```