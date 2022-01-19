# 함수(Function)

> 특정한 기능을 하는 코드의 조각
>
> 필요 시에만 호출하여 간편히 사용



## 함수 기초

### 사용자 함수

- 구현되어 있는 함수가 없는 경우 사용자가 직접 함수를 작성 가능

### 내장 함수

- 구현되어 있는 함수

### 함수의 기본 구조

- keyword, name, parameters, return



## 함수의 결과값

> 반드시 하나의 객체 반환 None, Tuple

### void function

- 명시적인 return 값이 없는 경우, none을 반환하고 종료

### Value returning function

- 함수 실행 후, return문을 통해 값 반환

``` python
a = print('hello') #void function
b = float('3.5') #value returning function

print(a, b)
```

hello

none 3.5

### 주의 사항

- 함수는 return을 만나면 바로 종료된다.



## 함수의 입력

### Parameter와 Argument

- parameter : 함수를 실행할 때, 함수 내부에서 사용되는 식별자

- Argument : 함수를 호출 할 때 , 넣어주는 값

  - 필수 Argument : 반드시 전달되야 하는 argument
  - 선택 Argument : 값을 전달하지 않아도 되는 경우는 기본 값이 전달

- Positional Arguments, keyword Argument

  - 기본적으로 함수 호출 시 위치에 따라 전달됨, 직접 변수의 이름으로 특정 Argument를 전달할 수 있음
  - keyword -> 위치 x 위치 -> keyword 가능

- Default Argument Values

  - 기본값을 지정하여 함수 호출 시 argument 값을 설정하지 않도록 함

- 정해지지 않은 여러 개의 Argument 처리

  - Positional Arguments Packing/Unpacking

    - 여러개의 Position Arguments를 하나의 필수 Arguments로 받는다. 

      ``` python
      def add(*args):
          print(args)
      
      print(add(1, 2, 3))
      print(add(1, 2))
      ```

  - Keyword Arguments Packing/Unpacking

    - 함수가 임의의 개수 Argument를 Keyword Argument로 호출될 수 있도록 지정

      ``` python
      def family(**kwargs):
          print(kwargs)
          
      print(father='고길동', monster='둘리')
      ```

      

### 주의 사항

- 기본 argumet 값을 가지는 argument 다음에 기본값이 없는 argument 정의 x
- keyword argument 다음에 positional argument 사용 x



## 함수의 범위(Scope)

- 함수는 코드 내부에 local scope를 생성하며, 그 외의 공간인 global scope로 구분
  - local : 함수 내부에서만 참조 가능
  - global : 코드 어디서든 참조 가능

### 변수 생명 주기

- 변수는 각자의 수명주가가 존재
  - built-in scope : 파이썬이 실행된 이후부터 영원히 유지
  - global scope : 모듈이 호출된 시점 이후 혹은 인터프리터가 끝날 떄까지 유지
  - local scope : 함수가 호출될 때 생성되고, 함수가 종료될 때까지 유지

### LEGB(이름검색 규칙)

![image-20220119111911205](C:\Users\skycoms\AppData\Roaming\Typora\typora-user-images\image-20220119111911205.png)

- Local, enclosed, global, built-in 순으로 검색

### 주의 사항

- 기본적으로 함수에서 선언된 변수는 Local scope에 생성되며, 함수 종료 시 사라짐
- 해당 scope에 변수가 없는 경우 LEGB rule에 의해 이름을 검색함
  - 접근은 가능하지만,  해당 변수를 수정할 수는 없음
  - 함수 내에서 필요한 상위 scope 변수는 argument로 넘겨서 활용할 것(클로저 제외)
- 상위 scope에 있는 변수를 수정하고 싶다면 global, nonlocal 키워드 활용가능
  - 단, 코드가 복잡해지면서 변수의 변경을 추적하기 어렵고, 예기치 못한 오류가 발생
  - 가급적 사용하지 않는 것을 권장



