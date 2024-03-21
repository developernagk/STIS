/*
    객체 : 키(key)와 값(value)로 구성된 속성들의 집합
    - 메서드를 가질 수 있음
*/

/*
    객체 리터럴 : javascript에서 가장 일반적인 객체 생성 방법
    - {}를 사용하여 객체를 생성
*/
const emptyObject = {};
const hongGildong = {
    name: '홍길동',
    age: 23,
    address: '서울특별시',
    greeting: function() {
        console.log(`안녕 난 ${this.name}이야!`)
    }
};
console.log(hongGildong);
// 출력:
// {
//     name: '홍길동',
//     age: 23,
//     address: '서울특별시',
//     greeting: [Function: greeting]
//   }
console.log(hongGildong.name); // 출력: 홍길동
hongGildong.greeting(); // 출력: 안녕 난 홍길동이야!

const name = '고종';
const age = 40;
const address = '서울특별시';
// 변수가 선언되어 있는 경우 키와 값의 변수명이 같으면 키를 적어주지 않아도 됨
const goJong = {
    name,
    age,
    address
};
console.log(goJong); // 출력: { name: '고종', age: 40, address: '서울특별시' }


console.log('==============================');

/*
    Object 생성자 : Object 클래스의 생성자로 빈 객체 생성 가능
*/
const emptyObjectByConstructor = new Object();
console.log(emptyObjectByConstructor); // 출력: {}


console.log('==============================');

/*
    생성자 함수 : 생성자 함수를 사용하여 클래스처럼 사용 가능
*/
function Person (name, age, address) {
    this.name = name,
    this.age = age,
    this.address = address
};
const goGildong = new Person('고길동', 30, '인천광역시');
console.log(goGildong); // 출력: Person { name: '고길동', age: 30, address: '인천광역시' }
console.log(goGildong.name); // 출력: 고길동


console.log('==============================');

/*
    속성 이름 (속성 키) : 
    - 일반적으로 문자열로 표기함
    - javascript에서 사용 가능한(유효한) 이름 (변수 이름으로 사용 가능한 이름)일 경우에는 따옴표를 생략할 수 있음
    - 유효한 이름이 아니면 반드시 따옴표를 표함해서 작성
*/
const kimNagyeong = {
    'first name': 'nagyeong',
    'last-name': 'kim',
    gender: 'female',
    age: 24
};
console.log(kimNagyeong);
// 출력:
// {
//     'first name': 'nagyeong',
//     'last-name': 'kim',
//     gender: 'female',
//     age: 24
//   }


console.log('==============================');

/*
    속성 값 읽기 : 
    - 
    - 
    - 
    - 
*/



console.log('==============================');

/*
    속성 값 변경 :
    - 
*/



console.log('==============================');

/*
    속성 삭제 :
    - 
*/


console.log('==============================');

/*
    for-in 문 : 
    - 
    - 
*/



console.log('==============================');
