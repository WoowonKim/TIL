global cnt1, cnt0
cnt1 = 0

def fibo(N):
    global cnt0
    global cnt1
    if N == 1:
        return 1
    elif N == 0:
        cnt0 += 1
        return 0
    else:
        return fibo(N-1) + fibo(N-2)
    

T = int(input())
for i in range(T):
    N = int(input())
    cnt0 = 0
    cnt1 = 0
    a = fibo(N)
    print(cnt0,a)