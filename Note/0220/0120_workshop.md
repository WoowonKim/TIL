# 0120 WORKSHOP



## 1.  숫자의 의미

> 정수로 이루어진 list를 전달 받아, 각 정수에 대응되는 아스키 문자를 이어붙인 문자열을 반환하는 get_secret_word 함수를 작성하시오. 단, list는 65이상 90이하 그리고 97이상 122이하의 정수로만 구성되어 있다.

``` python
def get_secret_word(args):
    for idx in args:
        print(chr(idx),end="")

get_secret_word([83, 89])
```



## 2. 내 이름은 몇일까?

> 문자열을 전달 받아 해당 문자열의 각 문자에 대응되는 아스키 숫자들의 합을 반환하는 get_secret_number 함수를 작성하시오. 단, 문자열은 A~Z, a~z로만 구성되어 있다..

```python
def get_secret_number(args):
    res = 0
    for idx in args:
        res += ord(idx)
    print(res)
    return res

get_secret_number('tom')
```



## 3. 강한 이름

> 문자열 2개를 전달 받아 두 문자열의 각 문자에 대응되는 아스키 숫자들의 합을 비교하 여 더 큰 합을 가진 문자열을 반환하는 get_strong_word 함수를 작성하시오

```python
def get_strong_word(*args):
    res0 = [ord(x) for x in args[0]]
    res1 = [ord(x) for x in args[1]]
    if sum(res0) > sum(res1):
        print(args[0])
        return args[0]
    else:
        print(args[1])
        return args[1]

get_strong_word('z', 'a')
get_strong_word('tom', 'john')
```

