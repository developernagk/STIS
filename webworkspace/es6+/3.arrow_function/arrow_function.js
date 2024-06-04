/*
    화살표 함수 : 
    - function 키워드 대신 화살표(=>)를 사용하여 함수를 생성하는 방법(기본적으로 1회성, 익명 함수)
*/
let func1 = function (arg1, arg2) {

}
func = (arg1, arg2) => {

}

/* 
    매개변수 지정 방법 
*/

// 매개변수가 없을 경우
func = () => {  };

// 매개변수가 하나일 경우, 매개변수 위치의 소괄호를 제거할 수 있음
func = (arg) => {  };
func = arg => {  };

// 매개변수가 여러 개일 경우, 매개변수 위치의 소괄호를 제거할 수 없음
func = (arg1, arg2) => {  };
// func = arg1, arg2 => {  }; 1. func = arg1 / 2. arg => {  } 라는 2개의 식이 생김

/*
    구현부 지정 방법
*/

// single line block
func = (arg) => {
    return arg * arg;
};

// 구현부가 한 줄이면 중괄호를 생략할 수 있으며, 해당 구문의 결과를 return
func = (arg) => arg * arg;

// 구현부가 한 줄이면서 객체 리터럴을 반환할 때 함수의 중괄호를 제거하면 객체 리터럴을 소괄호로 묶어야 함
func = (name, tombName) => {
    return {
        name,
        tombName
    };
};

// 객체를 선언하는 중괄호인지 함수의 중괄호인지 알 수 없으므로 소괄호로 묶어줌
func = (name, tombName) => ({
    name,
    tombName
});

/*
    화살표 함수의 호출 : 
    - 화살표 함수는 익명 함수로만 사용할 수 있기 때문에 함수 표현식 형태로 변수에 저장하여 사용
    - 콜백 함수에 많이 사용됨
*/
const pow = (x) => {
    return x * x;
};

console.log( pow(10) ); // 출력: 100

const numbers = [1, 2, 3, 4, 5];
numbers.forEach(function (value, index) {
    console.log(`index : ${index} / value : ${value}`);
})
// 출력
// index : 0 / value : 1
// index : 1 / value : 2
// index : 2 / value : 3
// index : 3 / value : 4
// index : 4 / value : 5

console.log("====================")

numbers.forEach((value, index) => {
    console.log(`index : ${index} / value : ${value}`);
})
// 출력
// index : 0 / value : 1
// index : 1 / value : 2
// index : 2 / value : 3
// index : 3 / value : 4
// index : 4 / value : 5