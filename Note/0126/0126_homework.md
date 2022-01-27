# 0126 Homework



## 1.  Type Class

> Python은 객체 지향 프로그래밍 언어이다. Python에서 기본적으로 정의되어 있는 클래스를 최소 5가지 이상 작성하시오.

``` python
print(type(int)) #<class 'type'>
print(type(str)) #<class 'type'>
print(type(float)) #<class 'type'>
print(type(dict)) #<class 'type'>
print(type(print)) #<class 'builtin_function_or_method'>
```



## 2. Magic Method

> 아래에 제시된 매직 메서드들이 각각 어떠한 역할을 하는지 간단하게 작성하시오.

```python
__init__ #생성자 메서드 : 인스턴스생성시 자동으로 호출
__del__ #소멸자 메서드 : 인스턴스가 소멸되기 직전 호출
__str__ #문자열화 하여 서로 다른 객체간의 정보를 전달하는데 사용
__repr__ #사용자가 이해하도록 표현하는데 사용
```





## 3. Instance Method

> .sort()와 같이 문자열, 리스트, 딕셔너리 등을 조작 할 때 사용하였던 것들은 클래스에 정의된 메서드들이었다. 이처럼 문자열, 리스트, 딕셔너리 등을 조작하는 메서드를 최소 3가지 이상 그 역할과 함께 작성하시오.

``` python
.reverse() # 리스트 요소를 역순으로 배열한다 
.pop(x) #리스트의 x번째 요소를 삭제하고 반환한다.
.clear() #모든 요소를 삭제한다.
```



## 4. Module Import

> 위와 같은 코드가 같은 폴더 안의 fibo.py 파일에 작성되어 있을 때, 아래와 같은 형태로 함수를 실행 할 수 있도록 하는 import 문을 빈칸 (a), (b), (c)를 채워 넣어 완성하시오.

```python
from fibo import fibo_recursion as recursion
```

