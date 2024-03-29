/*
    매개변수 기본값 : 
    - 함수 호출 시 인수를 전달하지 않았으면 사용할 기본값을 지정할 수 있음
*/
const add = (a = 10, b = 20) => { return a + b };
console.log(add()); // 출력: NaN(a와 b에 값을 전달해주지 않고 실행하면 undefinde 2개를 더해준 것이라 생각해 NaN 출력)
console.log(add(30, 90));

console.log('========================================');

/*
    rest 매개변수 : 
    - 매개변수 앞에 ...을 붙여서 정의한 매개변수
    - 함수에 전달받은 인수의 목록을 배열로 전달 받음
    - rest 매개변수는 반드시 제일 마지막에 선언되어야 함
*/
const restFunction1 = (...args) => {
    console.log(args);
};
restFunction1(1, 2, 3, 4, 5); // 출력: [ 1, 2, 3, 4, 5 ]

const restFunction2 = (arg1, ...args) => {
    console.log(arg1);
    console.log(args);
};
restFunction2(1, 2, 3, 4, 5); // 출력: 1 / [ 2, 3, 4, 5 ]

console.log('========================================');

/*
    spread 연산자 : 
    - ...을 사용하여 대상을 개별 요소로 분리
    - 반드시 피연산자는 반복 가능한 객체(배열, 객체, 문자열, ...)여야 함
*/
const numbers = [1, 2, 3, 4, 5];
console.log(numbers); // 출력: [ 1, 2, 3, 4, 5 ]

console.log(...numbers); // 출력: 1 2 3 4 5
console.log(1, 2, 3, 4, 5); // 출력: 1 2 3 4 5

// 배열 복사에 사용
const copyNumbers = [...numbers];
console.log(copyNumbers); // 출력: [ 1, 2, 3, 4, 5 ]

copyNumbers[0] = 10;
console.log(numbers); // 출력: [ 1, 2, 3, 4, 5 ]
console.log(copyNumbers); // 출력: [ 10, 2, 3, 4, 5 ]

console.log('========================================');

// 배열 연결에 사용
const numbers2 = [6, 7, 8, 9, 10];
let newNumbers = [...numbers, ...numbers2];
console.log(newNumbers);
// 출력
// [
//     1, 2, 3, 4,  5,
//     6, 7, 8, 9, 10
// ]

console.log('========================================');

// 배열 요소 추가에 사용
newNumbers = [...numbers, 0, -1, -2];
console.log(newNumbers);
// 출력
// [
//     1, 2,  3,  4,
//     5, 0, -1, -2
// ]

console.log('========================================');

// 객체 복사, 연결, 요소 추가에 사용
const king = {
    name: '이성계',
    tombName: '태조'
};

let newKing = {...king};
newKing.name = '이방과'; // 출력: { name: '이방과', tombName: '태조' }
console.log(newKing); // 출력: { name: '이성계', tombName: '태조' }
console.log(king);

const kingInfo = {
    address: '서울특별시',
    country: '고려'
};

newKing = {...king, ...kingInfo};
console.log(newKing); // 출력: { name: '이성계', tombName: '태조', address: '서울특별시', country: '고려' }

newKing = {...king, birth: '1335.11.04'};
console.log(newKing); // 출력: { name: '이성계', tombName: '태조', birth: '1335.11.04' }

// 키 값을 다시 선언하여 추가하면 값 변경이 이루어짐
newKing = {...king, name: '이단', birth: '1335.11.04'};
console.log(newKing); // 출력: { name: '이단', tombName: '태조', birth: '1335.11.04' }