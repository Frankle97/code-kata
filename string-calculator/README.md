# 문자열 계산기
- 아래 요구사항을 TDD로 구현한다. 

## 요구사항
- 사용자가 입력한 문자를 구분자로 분리한 후 각 숫자의 합을 구해 반환한다.
- 쉼표(`,`) 또는 콜론(`;`)을 구분자로 가지는 문자열의 경우 구분자를 기준으로 분리한 뒤 각 숫자의 합을 반환한다.
  - 예) `" " => 0, "1,2" => 3, "1,2,3" => 6, "1,2:3" => 6`
- 문자열 앞부분의 `"//"`와 `"\n"` 사이에 위치하는 문자를 커스텀 구분자로 지정이 가능하다.
  - 예) `"\\;\n1;2;3"`의 경우 커스텀 구분자는 세미콜론(`;`)이며, 결과 값은 6이 반환되어야 한다.
- 입력 문자열에 음수가 있다면 `RuntimeException`을 예외 처리한다.

## 추가 요구사항
- 메소드가 한 가지 책임만 가지도록 구현한다.
- 인덴트(indent, 들여쓰기) 깊이를 1단계로 유지한다.
  - 만약 `while`문 안에 `if`문이 있다면 인덴트는 2이다.
- `else`를 사용하지 않는다.
- 삼항연산자를 사용하지 않는다.
  