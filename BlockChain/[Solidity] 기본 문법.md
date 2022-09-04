# [Solidity] 기본 문법

```solidity
// SPDX-License-Identifier: GPL-3.0

pragma solidity >=0.7.0 <0.9.0;
```

소스 코드의 라이선스와 소스 코드가 이용하는 컴파일러 버전 명시

```solidity
contract Storage {

    uint256 number;

    function store(uint256 num) public {
        number = num;
    }

    function retrieve() public view returns (uint256){
        return number;
    }
}
```

### 상태 변수

블록 체인에 값이 저장되는 변수

접근 제어자 지정 가능(external, public, private)

기본형, 구조체, 배열 등 다양한 자료형 존재

### 함수

컨트랙트 단위 기능

매개 변수, 제어자, 반환 값 지정 가능

함수 내부에서 상태 변수의 값을 변경하고 읽을 수 있다. 

## 자료형

- 논리형
  - bool : true or false
- 정수형
  - uint : unsigned integer
  - int : signed integer
  - 8 ~ 256 bit를 표현할 수있으며 , uint는 uint256과 같다. 
- 주소형
  - adderss : 이더리움의 주소를 표현함
- 바이트형
  - bytes# or byte[] : 데이터를 바이트로 표현

## 접근 제어자

- private
  - 컨트랙트 내에서만 접근 가능
- interner
  - 현재 컨트랙트와 자식 컨트랙트에서 접근 가능 (함수 only)
- public
  - 현재 자식 외부 컨트랙트 및 주소에서 접근 가능
- external
  - 외부 컨트랙트와 주소에서 접근 가능

## 배열

- 고정 길이와 유동 길이를 가지는 배열 선언 가능
- 인덱스로 접근하기 : arr[i]
- push : 값 추가
- pop: 마지막 값 삭제
- remove : 해당 인덱스 초기화

## Mapping

선언 방법

```solidity
mapping(address => uint)
```

```solidity
// SPDX-License-Identifier: UNLICENSED
pragma solidity >=0.7.0 <0.9.0;

contract Mapping {
    // Mapping from address to uint
    mapping(address => uint) public addrToUint;

    // Access value with key in Mapping.
    // If there is no key, it will return the default value, 0.
    function get(address _addr) public view returns (uint) {
        return addrToUint[_addr];
    }

    // Update the value at the address
    function set(address _addr, uint _i) public {
        addrToUint[_addr] = _i;
    }

    // Reset the value to the default value.
    function reset(address _addr) public {
        delete addrToUint[_addr];
    }
}
```

## Struct

> 여러 자료형을 하나의 관점으로 묶어서 관리하고자 할 때 선언

```solidity
// SPDX-License-Identifier: UNLICENSED
pragma solidity >=0.7.0 <0.9.0;

contract Struct {

    struct MyStruct {
        string text;
        bool boolean;
    }

    // An array of structs
    MyStruct[] public structArray;

    // A mapping from address to Todo
    mapping(address => MyStruct) public addrToStruct;


    // Create a new struct
    // method 1
    function create1(string memory _text) public {
        structArray.push(MyStruct(_text, false));
    }

    // method 2
    function create2(string memory _text) public {
        structArray.push(MyStruct({text: _text, boolean: false}));
    }
  
    // method 3
    function create3(string memory _text) public {
        MyStruct memory s;
        s.text = _text;
        structArray.push(s);
    }

    // Update text
    function updateText(uint _index, string memory _text) public {
        MyStruct storage s = structArray[_index];
        s.text = _text;
    }

    // Switch Boolean
    function updateBoolean(uint _index) public {
        MyStruct storage s = structArray[_index];
        bool current = s.boolean;
        s.boolean = !current;
    }
}

```

## 함수

```solidity
// SPDX-License-Identifier: UNLICENSED
pragma solidity >=0.7.0 <0.9.0;

contract Function {

    uint public num = 1;

    uint public a = 1;
    string public s = "hello solidity";
    bool public b = true;

    // No parameter and return value
    function addOne() public {
        num++;
    }

    // One parameter and a return value
    function addNumber(uint x) public returns (uint) {
        num += x;

        return num;
    }
 
    // view - not to modify the state variable, but read.
    function addAndReturn(uint x) public view returns (uint) {
       return num + x;
    }

    // pure - not to modify or read the state variable.
    function add(uint x, uint y) public pure returns (uint) {
       return x + y;
    }

    // Return many values
    function returnMany() public view returns (uint, string memory, bool) {
        return (a, s, b);
    }

} 
```