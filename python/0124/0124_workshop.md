# 0124 WORKSHOP



## 1.  평균 점수 구하기

> key 값으로 과목명, value 값으로 점수를 가지는 dictionary를 전달 받아, 전체 과목의 평균 점수를 반환하는 함수 get_dict_avg 함수를 작성하시오.

``` python
def get_dict_avg(scores):
    score = scores.values()
    return sum(score)/len(score)

get_dict_avg({
    'python' : 80,
    'algorithm' : 90,
    'django' : 89,
    'web' : 83,
})
```



## 2. 혈액형 분류하기

> 여러 사람의 혈액형(A, B, AB, O)에 대한 정보가 담긴 list를 전달 받아, key는 혈액형의 종류, value는 사람 수인 dictionary를 반환하는 count_blood 함수를 작성하시오.

```python
def count_blood(blood):
    dict_blood = {
        'A' : blood.count('A'), 
        'B' : blood.count('B'), 
        'O' : blood.count('O'), 
        'AB' : blood.count('AB')}
    return dict_blood


count_blood([
    'A', 'B', 'A', 'O', 'AB', 'AB',
    'O', 'A', 'B', 'O', 'B', 'AB',
])
```

