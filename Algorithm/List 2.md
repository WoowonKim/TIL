# List 2

## 2차원 배열

### 2차원 배열의 선언

- 2차원 이상의 배열은 차원에 따라 index를 선언

- 2차원 배열의 선언 : 세로길이(행의 개수), 가로길이(열의 개수)를 필요로 함

``` java
int[][] twoDimArr = new int[2][4]
```

### 2차원 배열 인덱스 접근

``` java
public class List2_01_ArrayTest {
	public static void main(String[] args) {
		int[][] arr = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };

		int N = arr.length; // 행의길이
		int M = arr[0].length; // 열의길이

		// 1. 행우선순회 (for문 하나로 돌수도 있음 : 고것은 각자 해볼것 *언젠가는)
		// i(행의값)를 고정시키고 j(열의값)를 반복
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				System.out.printf("%3d", arr[i][j]);
			}
			System.out.println();
		}
		System.out.println();

		// 2. 행 역우선 순회
		for (int i = 0; i < N; i++) {
			for (int j = M - 1; j >= 0; j--) {
				System.out.printf("%3d", arr[i][j]);
			}
			System.out.println();
		}
		System.out.println();

		// 3. 열 우선 순회
		for (int j = 0; j < M; j++) {
			for (int i = 0; i < N; i++) {
				System.out.printf("%3d", arr[i][j]);
			}
			System.out.println();
		}
		System.out.println();
		// 4. 열 역 우선 순회
		for (int j = 0; j < M; j++) {
			for (int i = N - 1; i >= 0; i--) {
				System.out.printf("%3d", arr[i][j]);
			}
			System.out.println();
		}
		System.out.println();

		// 지그재그 순회 (짝수행은 정방향, 홀수행은 역방향)
		// 1번째.
		for (int i = 0; i < N; i++) {
			// 짝수행 정방향
			if (i % 2 == 0) {
				for (int j = 0; j < M; j++) {
					System.out.printf("%3d", arr[i][j]);
				}
			} else { // 홀수행 역방향
				for (int j = M - 1; j >= 0; j--) {
					System.out.printf("%3d", arr[i][j]);
				}
			}
			System.out.println();

		}
		System.out.println();

		// 2번째.
		for (int i = 0; i < N; i++) {
			// 짝수행 정방향
			if (i % 2 == 0) {
				for (int j = 0; j < M; j++) {
					System.out.printf("%3d", arr[i][j]);
				}
			} else { // 홀수행 역방향
				for (int j = 0; j < M; j++) {
					System.out.printf("%3d", arr[i][M - 1 - j]);
				}
			}
			System.out.println();

		}
		System.out.println();

		// 3번째.
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				//행에 따라 j의 값을 결정하고 싶다. (i%2)를 활용
				System.out.printf("%3d", arr[i][j+(M-1-j)*(i%2)]);
			}
			System.out.println();

		}
		System.out.println();

	}
}
```

### 델타를 이용한 2차 배열 탐색

- 2차 배열의 한 좌표에서 4방향의 인접 배열 요소를 탐색하는 방법

``` java
public class List2_02_Delta {
	static int[][] drc = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };

	public static void main(String[] args) {
		int[][] arr = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
		// N*N 크기
		int N = arr.length;

		// 현재 나의 좌표
		int r = 2;
		int c = 1;

		// 상 하 좌 우
		int[] dr = { -1, 1, 0, 0 };
		int[] dc = { 0, 0, -1, 1 };
		// 4방향 탐색
		for (int d = 0; d < 4; d++) {
			// 다음좌표 = 현재좌표 + 델타
			int nr = r + dr[d];
			int nc = c + dc[d];
			int nr2 = r + drc[d][0]; // 행
			int nc2 = c + drc[d][1]; // 열

			// 배열의 경계를 벗어나지 않았는지를 항상 체크하고 사용해야함.

			// 확인을 하는 2가지 방법
			// 1. 맵(배열) 안에 들어왔으면 해!
			if (nr >= 0 && nr < N && nc >= 0 && nc < N) {
				System.out.println(arr[nr][nc]);
			}

			// 2. 맵(배열)을 벗어났으면 이번에는 넘어가~~
			if (nr < 0 || nr >= N || nc < 0 || nc >= N) {
				continue;
			}
			System.out.println(arr[nr][nc]);
		}
	}
}
```

### 전치행렬

``` java
import java.util.Arrays;

public class List2_03_전치행렬 {
	public static void main(String[] args) {
		int[][] arr = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };

		int N = 3;

		System.out.println("원래의 모습");
		for (int[] a : arr) {
			System.out.println(Arrays.toString(a));
		}
		System.out.println();

		// 전치행렬
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				// 조건을 걸어야한다.
				if (i < j) {
					// swap 해야한다.
					int tmp = arr[i][j];
					arr[i][j] = arr[j][i];
					arr[j][i] = tmp;
				}
			}
		}
		System.out.println("전치행렬 모습");
		for (int[] a : arr) {
			System.out.println(Arrays.toString(a));
		}
		System.out.println();

		// 전치행렬
		for (int i = 0; i < N; i++) {
			for (int j = i + 1; j < N; j++) {
				// swap 해야한다.
				int tmp = arr[i][j];
				arr[i][j] = arr[j][i];
				arr[j][i] = tmp;
			}
		}
		System.out.println("전치행렬 모습");
		for (int[] a : arr) {
			System.out.println(Arrays.toString(a));
		}
		System.out.println();

	}
}
```

## 순차 이진검색과 인덱스

### 순차 검색

> 일렬로 되어 있는 자료를 순서대로 검색하는 방법

- 배열이나 연결 리스트 등 순차구조로 구현된 자료구조에서 원하는 항목을 찾을 때 유용함
- 구현이 쉽지만, 검색 대상의 수가 많은 경우에는 수행시간이 급격히 중가하여 비효율적이다.
-  검색 과정 (정렬이 되어 있지 않은 경우)
  - 첫 번째 원소부터 순서 대로 검색
  - 키 값이 동일한 원소를 찾으면 그 원소의 인덱스 반환
  - 검색 대상을 찾지 못하면 검색 실패
  - 시간 복잡도: O(n)
- 검색 과정(정렬되어 있는 경우)
  - 위와 비슷하나 검색 중 키 값보다 큰값이 나오면 검색을 바로 멈출 수 있음
  - 평균 비교 회수가 반으로 줄어든다.
  - 시간 복잡도: O(n)

### 이진 검색

> 자료의 가운데에 있는 항목의 키 값과 비교하여 다음 검색의 위치를 결정하고 검색을 계속 진행하는 방법

- 검색 범위를 반으로 줄여가면서 보다 빠르게 검색을 수행함
- 이진 검색을 하기 위해서는 자료가 정렬된 상태여야 한다.
- 검색과정
  - 자료의 중앙에 있는 원소를 고른다.
  - 중앙 원소의 값과 찾고자 하는 목표 값을 비교한다.
  - 목표값이 중앙 원소의 값보다 작으면 자료의 원쪽 반, 크다면 오른쪽 반에 대해 검색을 수행한다.
  - 찾고자 하는 값을 찾을 때까지 1~3의 과정을 반복한다.

## 카운팅 정렬

> 항목들의 순서를 결정하기 위해 집합에 각 항목이 몇 개씩 있는지 세는 작업을 하여, 선형 시간에 정렬하는 효율적인 알고리즘

- 제한 사항
  - 정수나 정수로 표현할 수 있는 자료에 대해서만 적용 가능
  - 집합 내의 가장 큰 정수를 알아야 한다.
- 시간 복잡도 : O(n+k)
- 정렬 과정
  - Data에서 각 항목들의 발생 회수를 세고 정수 항목들로 직접 인덱스 되는 카운트 배열에 저장한다.
  - 정렬된 집합에서 각 항목의 앞에 위치할 항목의 개수를 반영하기 위해 카운트 배열의 원소를 조정한다.
  - 카운트 배열을 감소하며 Temp배열에 삽입한다.

``` java
import java.util.Arrays;

public class List2_06_CountingSort {
	public static void main(String[] args) {
		// 배열을 정렬해보자.
		int[] arr = { 5, 2, 4, 1, 2, 3, 3 };

		int N = arr.length; // 배열의 크기
		int K = -1;// 데이터의 최댓값 (모든 데이터가 양수라고 가정)

		for (int i = 0; i < N; i++) {
			if (K < arr[i])
				K = arr[i];
		}

		int[] count = new int[K + 1];
		int[] sorted = new int[N];

		for (int i = 0; i < N; i++) {
			int idx = arr[i];
			count[idx]++;
		}

		for (int i = 1; i < count.length; i++) {
			count[i] += count[i - 1];
		}
		
		for(int i=N-1; i>=0 ; i--) {
			sorted[--count[arr[i]]] = arr[i];
		}
		
		System.out.println(Arrays.toString(sorted));
	}
}
```

