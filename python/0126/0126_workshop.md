# 0126 WORKSHOP



## 1.  pip

> 아래 명령어는 (1) 무엇을 위한 명령인지 (2) 실행은 어디에서 해야하는지 작성 하시오.
>
> pip install faker

1. faker라는 파이썬 패키지를 다운 받기위한 명령이고, 터미널창에서 실행을 한다.



## 2.  Basic Usages(https://github.com/joke2k/faker#basic-usage)

> Faker는 다양한 메서드를 통해 임의의 결과값을 반환해준다. 임의의 영문 이름을 반환하는 아래 코드에서 라인별 의미를 주석을 참고하여 작성하시오.

```python
from faker import Faker #faker라는 패키지로부터 Faker모듈을 사용하기위한 코드이다.
fake = Faker() #Faker는 클래스, fake는 인스턴스이다.
fake.name() #name()은 fake의 인스턴스메서드이다.
```



## 3.  Localization(https://github.com/joke2k/faker#localization)

> 직접 해당하는 기능을 구현한다고 하였을 때, 빈칸 (a), (b), (c)에 들어갈 코드로 적절한 것을 작성하시오. (힌트: 생성자 메서드와 함수의 개념)

```python
class Faker():

    def __init__(self, Locale = 'en_US'):
        pass
```



## 4. Seeding the Generator(https://github.com/joke2k/faker#seeding-the-generator)

> 아래의 코드를 실행 했을 때, #1과 #2에서 출력되는 결과를 각각 작성하고, seed()는 어떤 종류의 메서드인지 작성하시오.

```python
from faker import Faker #faker라는 패키지로부터 Faker모듈을 사용하기위한 코드이다.

fake = Faker('ko_KR')
Faker.seed(4321)

print(fake.name()) #이도윤

fake2 = Faker('ko_KR')
print(fake2.name()) #이지후
```

seed()는 클래스 매서드로 클래스 내부의 random의 seed값을 설정하는 메서드이다.

> 아래의 코드를 실행 했을 때, #1과 #2에서 출력되는 결과를 각각 작성하고, seed_instance()는 어떤 종류의 메서드인지 작성하시오.

``` python
fake = Faker('ko_KR')
fake.seed_instance(4321)

print(fake.name()) #이도윤

fake2 = Faker('ko_KR')
print(fake2.name()) #random
```

seed_instance는 인스턴스 메서드로 해당 인스턴스에만 시드를 부여한다. seed()는 한번 설정하면 모든 인스턴스의 이름이 코드를 실행할때마다 동일하고, seed_instance는 해당 인스턴스만 같은 이름이 나온다.
