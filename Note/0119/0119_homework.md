# 0119 WORKSHOP



## 1.  Built-in 함수

> Python에서 기본으로 사용할 수 있는 built-in 함수를 최소 5가지 이상 작성하시오.

1. print()
2. type()
3. sum()
4. max()
5. len()
6. range()

## 2. 정중앙 문자

> 문자열을 전달 받아 해당 문자열의 정중앙 문자를 반환하는 get_middle_char 함수를 작성하시오. 단, 문자열의 길이가 짝수일 경우에는 정중앙 문자 2개를 반환한다.

```python
def get_middle_char(arg):
    a = len(arg)//2
    if len(arg)%2:
        print(arg[int(len(arg)/2)])
    else:
        print(arg[a-1:a+1])

get_middle_char('ssafy')
get_middle_char('coding')
```



## 3. 위치 인자와 키워드 인자

> 다음과 같이 함수가 선언되어 있을 때, 보기 (1)~(4) 중에서 실행 시 오류가 발생하는 코드를 고르시오

(4) 키워드 인자 다음에 위치 인자 x



## 4. 나의 반환값은

> 다음과 같이 함수를 선언하고 호출하였을 때, 변수 result에 저장된 값을 작성하시오.

none



## 5. 가변 인자 리스트

> 가변 인자 리스트를 사용하여, 갯수가 정해지지 않은 여러 정수들을 전달 받아 해당 정 수들의 평균 값을 반환하는 my_avg 함수를 작성하시오

```python
def my_avg(*args):
    total = sum(args)
    avg = total/len(args)
    print(avg)
    return avg

my_avg(77, 83, 95, 80, 70)
```

