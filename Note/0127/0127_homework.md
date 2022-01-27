# 0127 Homework



## 1.  Circle 인스턴스 만들기

> 아래와 같은 Circle 클래스가 있을 때, 반지름이 3이고 x, y좌표가 (2, 4)인 Circle 인스턴스를 만들어 넓이와 둘레를 출력하시오.

``` python
class Circle:
    pi = 3.14

    def __init__(self, r, x, y):
        self.r = r
        self.x = x
        self.y = y

    def area(self):
        return self.pi * self.r * self.r

    def circumference(self):
        return 2 * self.pi * self.r

    def center(self):
        return (self.x, self.y)


circle = Circle(3, 2, 4)
print(circle.area())
print(circle.circumference()
```



## 2. Dog과 Bird는 Animal이다

> 다음과 같이 Animal 클래스가 주어질 때, 해당 클래스를 상속 받아 아래의 보기와 같이 동작하는 Dog 클래스와 Bird 클래스를 작성하시오.

```python
class Animal:
    def __init__(self, name):
        self.name = name

    def walk(self):
        print(f'{self.name}! 걷는다!')

    def eat(self):
        print(f'{self.name}! 먹는다!')

class Dog(Animal):
    def __init__(self,name):
        super().__init__(name)

    def walk(self):
        print(f'{self.name}! 달린다!')

    def bark(self):
        print(f'{self.name}! 짖는다!')

class Bird(Animal):
    def __init__(self,name):
        super().__init__(name)

    def fly(self):
        print(f'{self.name}! 푸드덕!')
```



## 3. 오류의 종류

> 아래에 제시된 오류들이 각각 어떠한 경우에 발생하는지 간단하게 작성하시오.

```python
ZeroDivisionError #0으로 나눗셈을 하게되면 발생하는 오류
NameError #변수의 이름을 틀리거나 없는 변수를 사용한 경우
TypeError #자료형이 틀리거나 함수 호출 규약이 틀리면 발생
IndexError #인덱스범위를 벗어나는 경우 발생하는 에러
KeyError #딕셔너리에 없는키를 실행시키는 경우 발생
ModuleNotFoundError #지정된 폴더에 모듈이 없거나 설치되어있지 않은경우 발생
ImportError #import문이 모듈을 로드하는 데 문제가 있을 때 발생.임포트 하려는 이름을 찾을 수 없을 때도 발생
```

