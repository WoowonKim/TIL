# List 1

## 알고리즘

> 유한한 단계를 통해 문제를 해결하기 위한 절차나 방법

APS(Algorithm Problem Solving)의 목표 : 좋은 알고리즘을 이해하고 활용하기!

- 정확성 : 현재 제일 중요!
- 작업량 : 많은 문제에서 성능 분석의 기준으로 사용 (시간 복잡도)
  - 시간복잡도(빅-o 표기법) : 시간 복잡도 함수 중에서 가장 큰 영향력을 주는 n에 대한 항만을 표시
- 메모리 사용량
- 단순성
- 최적성

SW 문제를 완벽하게 풀기위한 5단계

1. 지문을 읽는다.
2. 문제를 이해한다.
3. 문제를 손으로 푼다.
4. 푼 걸 코딩한다.
5. 디버깅하고 검증한다.

## 배열

> 일정한 자료형의 변수들을 하나의 이름으로 열거하여 사용하는 자료구조

1차원 배열의 선언 

``` java
int[] nums = new int[6];
//or
int[] nums = {0, 1, 2, 3, 4, 5};
nums[idx] = 10; //배열 nums의 idx번째 원소에 10을 저장
```



1. 정방향 순회

``` java
// 1. 일반적인 for 반복문
for(int i=0; i<nums.length; i++) {
    System.out.println(nums[i]);
}
// 1-2. foreach : 단점 배열의 요소값을 지금은 수정할 수 없음
for(int i : nums) {
    System.out.println(i);
}
```



2. 역방향 순회

``` java
// 2-1. 일반적인 반복문
for(int i=nums.length -1; i>=0; i--) {
    System.out.println(nums[i]);
}
// 2-2. 반복문은 기존 그대로, 인덱스 변경
for(int i=0; i<nums.length; i++) {
    System.out.println(nums[nums.length -1 -i]);
}
```



## 정렬

> 2개 이상의 자료를 특정 기준에 의해 오름차또는 내림차순으로 재배열하는 것

- 버블 정렬
- 선택 정렬
- 카운팅 정렬
- 삽입 정렬
- 병합 정렬
- 퀵 정렬

### 버블 정렬(Bubble sort)

> 인접한 두 개의 원소를 비교하며 자리를 계속 교환하는 방식

- 한단계가 끝나면 가장 큰 원소가 마지막 자리로 정렬된다.

- 교환하며 자리를 이동하는 모습이 물 위에 올라오는 거품 모양과 같다고 하여 버블 정렬이라고 한다.

- 시간 복잡도 : O(n^2)

``` java
int[] nums = { 55, 7, 78, 12, 42 };
int N = nums.length;
// 오름차순
// 교재의 내용
// 몇번 돌건지 + 정렬될 위치
for (int i = N - 1; i > 0; i--) {
    // 시작 부터 인접한 값을 비교해야하므로 등호가 생략
    for (int j = 0; j < i; j++) {
        // 인접한 두개의 수 중 앞의 친구가 더 크다면
        if (nums[j] > nums[j + 1]) {
            int tmp = nums[j];
            nums[j] = nums[j + 1];
            nums[j + 1] = tmp;
        }
    }
}
System.out.println(Arrays.toString(nums));

// 오름차순 (N이든 N-1이든 어차피 밑에 반복문을 수행하지 않게 할수있음.
for (int i = 0; i < N; i++) {
    for(int j = 1; j < N-i; j++) {
        if(nums[j-1] > nums[j]) {
            int tmp = nums[j];
            nums[j] = nums[j-1];
            nums[j-1] = tmp;
        }
    }
}
System.out.println(Arrays.toString(nums));
```







### 선택 정렬(selection sort)

> 주어진 자료들 중 가장 작은 값의 원소부터 차례대로 선택하여 위치를 교환하는 방식

- 주어진 리스트 중에서 최소값을 찾는다.
- 그 값을 리스트의 맨 앞에 위치한 값과 교환한다.
- 맨 처음 위치를 제와한 나머지 리스트를 대상으로 위의 과정을 반복한다.
- 시간 복잡도 : O(n^2)

``` java
int[] nums = { 64, 25, 10, 22, 11 };
int N = nums.length;
// 몇번 반복해야 할까요?????
// i번째 자리를 정렬 하려고 함. //마지막 자리는 정렬할 필요가 없음.
for (int i = 0; i < N - 1; i++) {
    // 인덱스 값만 저장한다.
    int minIdx = i;
    // i번째 이후의 값들 중 더 작은 값이 있다면 minIdx 갱신한다.
    for (int j = i + 1; j < N; j++) {
        // 현재 보고있는 j번째 값이 내가 가장 작다고 믿고 있는 값보다 더작다면.....
        if (nums[j] < nums[minIdx])
            minIdx = j;
    }
    // 여기까지 왔으면 무엇을 해야 할까요??
    // 교환을 할껀데 검사를 매번 해서 교환을 할 수 도 있지만 
    // 케이스바이케이스로 손해 일수도 있고 좋을 수도 있음.
    int tmp = nums[i];
    nums[i] = nums[minIdx];
    nums[minIdx] = tmp;
}
```



## 완전 검색

## 그리디(Greedy Algorithm)

