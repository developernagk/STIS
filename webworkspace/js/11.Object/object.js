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
    - . 표기법과 [] 표기법으로 접근 가능
    - . 표기법은 유효한 이름일 때 사용
    - [] 표기법은 유효한 이름이 아닐 때와 접근할 속성이 동적으로 변할 때 사용([] 안에 반드시 문자열로 지정)
    - 객체에 존재하지 않는 속성에 접근하면 undefined를 반환
*/
console.log(kimNagyeong.age); // 출력: 24
console.log(kimNagyeong["last-name"]); // 출력: kim
let property = 'first name';
console.log(kimNagyeong[property]); // 출력: nagyeong


console.log('==============================');

/*
    속성 값 변경 :
    - 객체 속성에 접근하여 새로운 값을 할당하여 변경 가능
    - 만약 존재하지 않는 속성에 값을 할당하면 새로운 속성이 생성
*/
goJong.name = '이형';
goJong.birth = '1852-09-08';
console.log(goJong); // 출력: { name: '이형', age: 40, address: '서울특별시', birth: '1852-09-08' }


console.log('==============================');

/*
    속성 삭제 :
    - delete 연산자를 사용하여 객체 속성 제거 가능
*/
delete goJong.birth;
console.log(goJong); // 출력:{ name: '이형', age: 40, address: '서울특별시' }


console.log('==============================');

/*
    for-in 문 : 
    - for-in문으로 객체에 포함되어 있는 키를 순회해서 접근 가능
    - 반환되는 값은 문자열 타입의 키가 반환
*/
for (const key in goJong) {
    console.log(`${key}:${goJong[key]}`);
}
// 출력:
// name:이형
// age:40
// address:서울특별시


console.log('==============================');

let sunJong  = goJong; // 변수의 주소가 달라지기 때문에 같이 바뀌게 됨
sunJong.name = '이척';
console.log(sunJong.name); // 출력: 이척
console.log(goJong.name); // 출력: 이척

// {}로 객체를 새로 생성하는 경우 주소가 새로 생기며 할당되기 때문에 goJong과 sunJong의 위치가 달라짐
sunJong = {
    name: goJong.name,
    age: goJong.age,
    address: goJong.address
};

sunJong = {};
for (const key in goJong) {
    sunJong[key] = goJong[key];
}
console.log(sunJong); // 출력: { name: '이척', age: 40, address: '서울특별시' }

sunJong = {};
console.log(sunJong); // 출력: {}

// name, age, address라고 하는 각각의 변수로 바뀌며 배열이 할당됨
sunJong = { ...goJong };
console.log(sunJong); // 출력: { name: '이척', age: 40, address: '서울특별시' }

goJong.name = '이형'; // goJong의 주소가 변경된 것이 아니라 goJong.name에 담긴 값이 변경된 것
console.log(goJong.name); // 출력: 이형
console.log(sunJong.name); // 출력: 이척