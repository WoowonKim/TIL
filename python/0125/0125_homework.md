# 0125 Homework



## 1.  Built-in 함수와 메서드

> sorted()와 .sort()의 차이점을 코드의 실행 결과를 활용하여 설명하시오.

``` python
a = [ 4, 3, 2, 5, 7, 8, 3, 6, 5, 8]

print(sorted(a))
print(a)
print(a.sort())
print(a)
```

[2, 3, 3, 4, 5, 5, 6, 7, 8, 8]
[4, 3, 2, 5, 7, 8, 3, 6, 5, 8]
None
[2, 3, 3, 4, 5, 5, 6, 7, 8, 8]

sorted()는 기존 객체에 영향을 주지 않고, .sort는 기존의 객체를 바꾼다.

## 2. .extend()와 .append()

> .extend()와 .append()의 차이점을 코드의 실행 결과를 활용하여 설명하시오.

```python
cafe = ['starbucks', 'tomntoms', 'hollys']
print(cafe)

cafe.extend(['wcafe', '빽다방'])
print(cafe)

cafe.append('coffeenie')
print(cafe)

cafe.append(['wcafe', '빽다방'])
print(cafe)

cafe.extend('coffeenie')
print(cafe)
```

['starbucks', 'tomntoms', 'hollys']
['starbucks', 'tomntoms', 'hollys', 'wcafe', '빽다방']
['starbucks', 'tomntoms', 'hollys', 'wcafe', '빽다방', 'coffeenie']
['starbucks', 'tomntoms', 'hollys', 'wcafe', '빽다방', 'coffeenie', ['wcafe', '빽다방']]
['starbucks', 'tomntoms', 'hollys', 'wcafe', '빽다방', 'coffeenie', ['wcafe', '빽다방'], 'c', 'o', 'f', 'f', 'e', 'e', 'n', 'i', 'e']

extend : 리스트에 iterable(list,range,tuple,string)값을 붙인다.

append : 리스트에 값을 붙인다.



## 3. 복사가 잘 된 건가?

> 아래의 코드를 실행 하였을 때, 변수 a와 b에 담긴 list의 요소가 같은지 혹은 다른지 여부를 판단하고 그 이유를 작성하시오.

```python
a = [1, 2, 3, 4, 5]
b = a

a[2] = 5

print(a)
print(b)

#리스트는 mutable하기 때문에 변수만 복사하여 바라보는 객체는 동일하다.
```

