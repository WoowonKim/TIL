# 링크드리스트

## 순차리스트

> 배열을 기반으로 구현된 리스트

구현 방법

- 1차원 배열에 항목들을 순서대로 저장

데이터 접근

- 배열의 인덱스를 이용해 원하는 위치의 데이터에 접근할 수 있다.

삽입 연산

- 삽입 위치 다음의 항목들을 이동해야 한다.

삭제 연산

- 삭제 위치 다음의 항목들을 이동해야한다.

문제점

- 단순 배열을 이용해 순차리스트를 구현해 사용하는 경우, 자료의 삽입/삭제 연산 과정에서 연속적인 메모리 배열을 위해 원소들을 이동시키는 작업이 필요하다
- 원소의 개수가 많고 삽입/삭제 연산이 빈번하게 일어날수록 작업에 소요되는 시간이 크게 증가한다.
- 배열의 크기가 정해져 있는 경우, 실제로 사용될 메모리보다 크게 할당하여 메모리의 낭비를 초래할 수도 있고, 반대로 할당된 메모리보다 많은 자료를 사용하여 새롭게 배열을 만들어 작업을 해야 하는 경우가 발생할 수도 있다.

## 연결리스트

> 메모리의 동적할당을 기반으로 구현된 리스트

특성 

- 자료의 논리적인 순서와 메모리 상의 물리적인 순서가 일치하지 않고, 개별적으로 위치하고 있는 원소의 주소를 연결하여 하나의 전체적인 자료구조를 이룬다.
- 링크를 통해 원소에 접근하므로, 순차 리스트에서처럼 물리적인 순서를 맞추기 위한 작업이 필요하지 않다
- 자료구조의 크기를 동적으로 조정할 수 있어, 메모리의 효율적인 사용이 가능하다

노드

- 연결 리스트에서 하나의 원소에 필요한 데이터를 갖고 있는 자료단위
- 구성 요소
  - 데이터 필드 : 원소의 값을 저장
  - 링크필드 : 다음 노드의 주소를 저장

헤드

- 리스트의 처음 노드를 가리키는 레퍼런스

## Singly Linked List

연결 구조

- 노드가 하나의 링크 필드에 의해 다음 노드와 연결되는 구조를 가진다.
- 헤드가 가장 앞의 노드를 가리키고, 링크 필드가 연속적으로 다음 노드를 가리킨다.
- 최종적으로 NULL을 가리키는 노드가 리스트의 가장 마지막 노드이다.

## Double Linked List

특성

- 양쪽 방향으로 순회할 수 있도록 노드를 연결한 리스트
- 두 개의 링크 필드와 한 개의 데이터 필드로 구성

## 연결 스택/ 연결 큐

### 연결 스택

스택 내의 순서는 리스트의 링크를 통해 연결됨

- 리스트의마지막에노드삽입
- 리스트의마지막노드반환/삭제

### 연결 큐

큐의 원소 : 단순 연결 리스트의 노드 

큐의 원소 순서 : 노드의 연결 순서. 링크로 연결되어 있음 

front : 첫 번째 노드를 가리키는 링크 

 rear : 마지막 노드를 가리키는 링크

## 요세푸스

## 삽입 정렬

정렬 과정

- 정렬할 자료를 두 개의 부분집합 S와 U로 가정 
  - 부분집합 S : 정렬된 앞부분의 원소들
  - 부분집합 U : 아직 정렬되지 않은 나머지 원소들
- 정렬되지 않은 부분집합 U의 원소를 하나씩 꺼내서 이미 정렬 되어있는 부분집합 S의 마지막 원소부터 비교하면서 위치를 찾아 삽입한다.
- 삽입 정렬을 반복하면서 부분집합 S의 원소는 하나씩 늘리고 부분집합 U의 원소는 하나씩 감소하게 한다. 부분집합 U가 공집합이 되면 삽입정렬이 완성된다.

