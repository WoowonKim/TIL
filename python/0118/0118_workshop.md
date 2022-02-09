# 0118 workshop



## 1. 간단한 N의 약수

> 입력으로 1개의 정수 N이 주어진다. 정수 N의 약수를 오름차순으로 출력하는 프로그램 을 작성하시오

```python
n = int(input('1이상 1000이하의 정수를 입력하세요 :'))

for i in range(n):
    if n%(i+1) == 0:
        print(i+1)
```



## 2. 중간값 찾기

> 중간값은 통계 집단의 수치를 크기 순으로 배열 했을 때 전체의 중앙에 위치하는 수치를 뜻한다. 리스트 numbers에 입력된 숫자에서 중간값을 출력하라.

```python
numbers = [
    85, 72, 38, 80, 69, 65, 68, 96, 22, 49, 67,
    51, 61, 63, 87, 66, 24, 80, 83, 71, 60, 64,
    52, 90, 60, 49, 31, 23, 99, 94, 11, 25, 24
]

numbers.sort()

print(numbers[len(numbers)//2])
```



## 3. 계단 만들기

> 자연수 number를 입력 받아, 아래와 같이 높이가 number인 내려가는 계단을 출력하시오.

``` python
user_input = int(input())
p = []
for i in range(user_input):
    p.append(i+1)
    for j in p:
        print(f'{j}',end=" ")
    print()
```

