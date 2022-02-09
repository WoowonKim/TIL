# 0118 Homework



## 1. Mutable & Immutable

> 주어진 컨테이너들을 각각 변경 가능한 것(mutable)과 변경 불가능한 것(immutable)으로 분류하시오.

- mutable
  - List, Dictionary, Set
- Immutable
  - Tuple, Range, string



## 2. 홀수만 담기

> range와 slicing을 활용하여 1부터 50까지의 숫자 중, 홀수로만 이루어진 리스트를 만드시오

```python
a= [i for i in range(1, 51) if i % 2 == 1]
print(a)
```



## 3.  Dictionary 만들기

> 반 학생들의 정보를 이용하여 key는 이름, value는 나이인 dictionary를 만드시오.

``` python
class_3 = {
    '강장호':25, '권다솜':25, '권예슬':24, '권우영':25,
    '김동신':34, '김동완':23, '김민영':23, '김민정':23,
    '김우원':23, '명건화':32, '박다빈':23, '박수근':24,
    '성유지':23, '안용현':23, '이다인':23, '이수랑':32,
    '이정건':42, '이진행':32, '이현태':23, '장진세':23,
    '정아현':32, '조항주':32, '최명권':32, '최수연':43,
    '최준혁':43}
```



## 4. 반복문으로 네모 출력

> 두 개의 정수 n과 m이 주어졌을 때, 가로의 길이가 n, 세로의 길이가 m인 직사각형 형태를 별(*) 문자를 이용하여 출력하시오. 단, 반복문을 사용하여 작성하시오.

``` python
n = 5
m = 9
for i in range(m):
    for j in range(n):
        print("*", end="")
    print()
```



## 5. 조건 표현식

> 주어진 코드의 조건문을 조건 표현식으로 바꾸어 작성하시오.

``` python
temp = 36.5

print('입실 불가') if temp >= 37.5 else print('입실 가능')
```





## 6. 평균 구하기

> 주어진 list에 담긴 숫자들의 평균값을 출력하시오

```python
scores = [80, 89, 99, 83]

mean_scores = sum(scores)/len(scores)

print(mean_scores)
```


