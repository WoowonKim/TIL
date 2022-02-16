# Stack 1

> 물건을 쌓아 올리듯 자료를 쌓아 올린 형태의 자료구조

### 특성

- 스택에 저장된 자료는 선형 구조를 갖는다
  - 선형구조 : 자료 간의 관계가 1대1의 관계를 갖는다.
- 스택에 자료를 삽입하거나 스택에서 자료를 꺼낼 수 있다.
- 마지막에 삽입한 자료를 가장 먼저 꺼낸다. 후입선출이라고 부른다.

### 스택의 구현

스택을 프로그럼에서 구현하기 위해서 필요한 자료구조와 연산

- 자료구조 : 자료를 선형으로 저장할 저장소
  - C언어에서는 배열을 사용할 수 있다.
  - 저장소 자체를 스택이라 부르기도 한다.
  - 스택에서 마지막 삽입된 원소의 위치를 top이라 부른다. (초기값 : -1)
- 연산
  - 삽입 : 저장소에 자료를 저장한다. push라고 부른다. top ++
  - 삭제 : 저장소에서 자료를 꺼낸다. 꺼낸 자료는 삽입한 자료의 역순으로 꺼낸다. pop이라고 부른다. 
  - 스택이 공백인지 아닌지를 확인하는 연산. isEmpty
  - 스택의 top에 있는 item을 반환하는 연산. peek
- 고려사항
  - 1차원 배열을 사용할 경우 구현이 용이하지만 스택의 크기를 변경하기 어렵다.
  - 저장소를 동적으로 할당하는 방법이 있다. 구현이 복잡하지만 메모리를 효율적으로 관리한다.

``` java
public class stack_01 {
	static int[] stack = new int[100];
	static int top = -1;
	public static void main(String[] args) {
		push(1);
		push(2);
		push(3);
		
		System.out.println(peek());
		System.out.println(peek());
		while(!isEmpty()) {
			System.out.println(pop());
		}
		
	}
	
	public static boolean isEmpty() {
		return top == -1;
	}
	
	public static boolean isFull() {
		return top == 99;
	}
	
	public static boolean push(int n) {
		if(isFull()) {
			return false;
		} else {
			stack[++top] = n;
			return true;
		}
	}
	
	public static boolean pop() {
		if(isEmpty()) {
			return false;
		}
		else {
			System.out.println(stack[top--]);
			return true;
		}
	}
	
	public static boolean peek() {
		if(isEmpty()) {
			return false;
		}
		else {
			System.out.println(stack[top]);
			return true;
		}
	}
}
```

### 응용1

- 괄호의 종류 : [	] {	} (	)
- 조건
  - 왼쪽 괄호의 개수와 오른쪽 괄호의 개수가 같아야 한다.
  - 같은 괄호에서 왼쪽 괄호는 오른쪽 괄호보다 먼저 나와야한다.
  - 괄호 사이에는 포함 관계만 존재한다.
- 잘못된 예
  - (a(b)
  - a(b)c)
  - a{b(c[d]e}f)
- 스택을 이용한 괄호 검사
  - 여는 괄호 push 
  - 닫는 괄호 pop 
  - 오류! 괄호 수식이 끝났는데 스택에 괄호가 남아있음
  - 오류! pop하는데 요소가 없음! 또는 다름!

``` java

public class Stack_03_bracket {
	public static void main(String[] args) {
//		String bracket = "()()((()))";
		String bracket = "((()((((()()((()())((())))))";
		int numOpen = 0;
		boolean flag = true;
		for (int i = 0; i < bracket.length(); i++) {
			if (bracket.charAt(i) == '(') {
				numOpen++;
			} else {
				if (numOpen > 0) {
					numOpen--;
				} else {
					flag = false;
					break;
				}
			}
		}
		if (numOpen > 0) {
			flag = false;
		} else
			flag = true;
		
		System.out.println(flag);
		// 괄호검사 구현약속
		// 1. 괄호의 개수가 맞아야한다.
		// 2. 오른쪽괄호는 왼쪽괄호보다 먼저 나오면 안된다.
		// 3. 괄호는 포함관계여야만 한다.
	}
}
```

### 응용2

Function call

- 프로그램에서 함수 호출과 복귀에 따른 수행 순서를 관리
  - 가장 마지막에 호출된 함수가 가장 먼저 실행을 완료하고 복귀하는 후입선출 구조(스택 이용)
  - 함수 호출이 발생하면 수행에 필요한 지역변수, 매개변수, 복귀할 주소등을 스택 프레임에 저장
  - 실행이 끝나면 시스템 스택의 top원소(스텍 프레임)를 삭제하면서 프레임에 저장된 복귀주소로 복귀
  - 전체 프로그렘이 종료되면 공백스택이 된다.

### 응용3

실행취소(ctrl + z, ctrl + y)

``` java
import java.util.Scanner;
import java.util.Stack;

public class Stack_05_실행취소 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		Stack<String> ctrlZ = new Stack<>(); // 뒤로
		Stack<String> ctrlY = new Stack<>(); // 앞으로

		String work = "작업1";

		while (true) {
			System.out.println("1. 새로운 작업");
			System.out.println("2. Ctrl+Z");
			System.out.println("3. Ctrl+Y");
			System.out.println("0. 종료(아무숫자를 입력해도 종료됨)");

			// 내가 선택한 메뉴
			int N = sc.nextInt();
			// switch 문을 이용해서 구현해보고싶다.!! (마음의 숙제)
			if (N == 1) { // 새로운 작업을 입력
				// 작업순서는???
				// 1. 현재 작업을 Z 스택에 저장한다.
				// 2. 새로운 작업을 입력받는다.
				// 3. Y스택을 비운다.
				// 3-1. while문을 이용해서 요소가 공백상태가 될때까지 뽑는다.
				// 3-2. new 라는 키워드를 이용해서 새로운 인스턴스를 생성한다.
				// 3-3. clear() 메서드를 이용한다.
				// 4. 입력받은 작업을 출력한다 (선택사항)

				ctrlZ.push(work);
				work = sc.next();
				ctrlY.clear();
				System.out.println(work);
			} else if (N == 2) { // 실행을 취소한다. (뒤로)
				if (ctrlZ.isEmpty()) {
					System.out.println("Z스택이 공백상태 꺼낼 과거 작업이 없어잉");
				} else {
					// 1. 현재작업을 Y에 넣는다.
					// 2. Z에서 작업을 꺼내어 넣는다.
					// 3. 현재 작업 출력. (선택사항)
					ctrlY.push(work);
					work = ctrlZ.pop();
					System.out.println(work);
				}
			} else if (N == 3) { // 실행 취소를 취소한다. (앞으로)
				if(ctrlY.isEmpty()) {
					System.out.println("지금이 최신작업이라 꺼낼께 없다요~~");
				}else {
					// 1. 현재 작업을 Z스택에 넣기
					// 2. Y에서 작업을 꺼내어 넣는다.
					// 3. 현재 작업 출력. (선택사항)
					ctrlZ.push(work);
					work = ctrlY.pop();
					System.out.println(work);
				}
			} else { // 그외의 입력이 주어졌다. (종료)
				System.out.println("종료합니당");
				break;
			}

		}
	}
}
```



### 응용4

계산기

- 문자열로 된 계산식이 주어질 떄, 스택을 이용하여 이 계산식의 값을 계산할 수 있다. 

- 문자열 수식 계산의 일반적인 방법
  - 중위 표기법의 수식을 후위 표기법으로 변경한다. (스택이용)
  - 휘위 표기법의 수식을 스택을 이용하여 계산한다.

- 중위표기식의 후위표기식 변환 방법1

  - 수식의 각 연산자에 대해서 우선순위에 따라 괄호를 사용하여 다시 표현한다.

  - 각 연산자를 그에 대응하는 오른쪽 괄호의 뒤로 이동시킨다.

  - 괄호를 제거한다.

  - 예 : A*B-C/D

    ((A*B)-(C/D))

    ((AB)*(CD)/)-

    AB*CD/-

- 중위표기식의 후위표기식 변환 알고리즘(스택이용)2

  - 입력 받은 중위 표기식에서 토큰을 읽는다.
  - 토큰이 피연산자이면 토근을 출력한다.
  - 토큰이 연산자(괄호포함)일 때, 이 토큰이 스택의 top에 저장되어 있는 연산자보다 우선순위가 높으면 스택에 push하고, 그렇지 않다면 스택 top의 연산자의 우선순위가 토큰의 우선순위보다 작을 때까지 스택에서 pop 한 후 토큰의 연산자를 push한다. 만약 top에 연산자가 없으면 push한다.
  - 토큰이 오른쪽 괄호 ‘)’이면스택 top에 왼쪽 괄호 ‘(‘가 올 때까지 스택에 pop 연산을 수행하고 pop 한 연산자를 출력한다. 왼쪽 괄호를 만나면 pop만 하고 출력하지는 않는다.
  - 중위 표기식에 더 읽을 것이 없다면 중지하고, 더 읽을 것이 있다면 1부터 다시 반복한다.
  - 스택에 남아 있는 연산자를 모두 pop하여 출력한다.
  - 스택 밖의 왼쪽 괄호는 우선 순위가 가장 높으며, 스택 안의 왼쪽 괄호는 우선 순위가 가장 낮다.

- 후위 표기법의 수식을 스택을 이용하여 계산
  1. 피연산자를 만나면 스택에 push한다.
  2. 연산자를 만나면 필요한 만큼의 피연산자를 스택에서 pop하여 연산하고, 연산결과를 다시 스택에 push한다.
  3. 수식이 끝나면, 마지막으로 스택을 pop하여 출력한다

## 재귀함수

> 자기 자신을 호출하여 순환 수행되는 것

함수 호출은 메모리 구조에서 스택을 사용한다.

함수 호출은 메모리 구조에서 스택을 사용한다. (이름만 같은 다른 메서드) 

- 간단한 문제에 대해서는 반복문에 비해 메모리 및 속도에서 성능저하가 발생한다

일반적으로 기본 부분(Base case), 재귀 부분(Recursive case)로 구성된다. 

- Base case : 재귀 호출에서 빠져 나가기 위한 조건 
- Recursive case : 자신을 호출하는 부분 (Base case로 유도한다.)

재귀적 프로그램을 작성하는 것은 반복 구조에 비해 간결하고 이해하기 쉽다.

## 부분집합

> 집합에 포함된 원소들을 선택하는것

다수의 중요 알고리즘들이 원소들의 그룹에서 최적의 부분집합을 찾는 것이다.

부분집합의 수 : 2^n

