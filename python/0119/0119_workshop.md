# 0119 WORKSHOP



## 1.  List의 합 구하기

> 정수로만 이루어진 list를 전달 받아 해당 list의 모든 요소들의 합을 반환하는 list_sum 함수를 built-in 함수인 sum() 함수를 사용하지 않고 작성하시오

``` python
def list_sum (args):
    total = 0
    for i in args:
        total += i
    return total

print(list_sum([1, 2, 3, 4, 5]))
```



## 2. Dictionary로 이루어진 List의 합 구하기

> Dictionary로 이루어진 list를 전달 받아 모든 dictionary의 'age' key에 해당하는 value 들의 합을 반환하는 dict_list_sum 함수를 built-in 함수인 sum() 함수를 사용하지 않고 작성하시오.

```python
def dict_list_sum (kwargs):
    total = 0
    for i in kwargs:
        total += i['age']
    return total

print(dict_list_sum([{'name': 'Kim', 'age': 12},{'name': 'lee', 'age': 4}]))
```



## 3. 2차원 List의 전체 합 구하기

> 정수로만 이루어진 2차원 list를 전달 받아 해당 list의 모든 요소들의 합을 반환하는 all_list_sum 함수를 built-in 함수인 sum() 함수를 사용하지 않고 작성하시오

```python
def all_list_sum (args):
    total = 0
    for i in args:
        for j in i:
            total += j
    return total

print(all_list_sum([[1], [2, 3], [4, 5, 6], [7, 8, 9, 10]]))
```

