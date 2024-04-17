/*
    if else 문
    - 조건식이 true일 경우 if 코드 블럭 실행, false일 경우 else 코드 블럭 실행
    - 조건식 위치에 논리 값을 반환하는 표현식이 아니더라도 사용 가능
*/
let age = 10;
if (age > 19) console.log('성인');
else console.log('미성년자');
// 출력: 미성년자

console.log('==============================');

let number = 10;
let kind = '';
if (number % 3) kind = '3의 배수가 아님';
else kind = '3의 배수';

console.log('==============================');

/*
    - if else 문을 삼항 연산자로 변경하여 사용 가능
*/
kind = number % 3 ? '3의 배수가 아님':'3의 배수';

console.log('==============================');

/*
    switch 문
    - 표현식을 비교하여 값이 표현식과 일치하면 해당하는 case문으로 실행 순서를 옮김
    - 표현식과 일치하는 case가 존재하지 않으면 default문으로 이동
    - break 지정하지 않으면 맨 끝까지 진행
*/
const weekNumber = 3;
let weekString = '';

// switch (weekNumber) {
//     case 0:
//         weekString += '일요일';
//     case 1:
//         weekString += '월요일';
//     case 2:
//         weekString += '화요일';
//     case 3:
//         weekString += '수요일';
//     case 4:
//         weekString += '목요일';
//     default:
//         weekString += '금토요일';
// }
// console.log(weekString);
// 출력: 수요일목요일금토요일

switch (weekNumber) {
    case 0:
        weekString += '일요일';
        break;
    case 1:
        weekString += '월요일';
        break;
    case 2:
        weekString += '화요일';
        break;
    case 3:
        weekString += '수요일';
        break;
    case 4:
        weekString += '목요일';
        break;
    default:
        weekString += '금토요일';
}
console.log(weekString);
// 출력: 수요일

console.log('==============================');

/*
    for 반복문
    - 반복할 횟수가 지정되어 있을 때 사용하는 반복문
*/
const dan =3;
for (let count = 1; count <= 9; count++) {
    console.log(`${dan} * ${count} = ${dan * count}`);
}
// 출력: 구구단 출력

console.log('==============================');

/*
    while 반복문
    - 반복할 횟수가 지정되어 있지 않을 때 사용하는 반복문
*/
let randomNumber = Math.random();
console.log(randomNumber);
// 출력: (랜덤한 값 출력)

while(randomNumber > 0.5) {
    randomNumber = Math.random();
    console.log(randomNumber);
}
// 출력: (0.5 보다 큰 랜덤한 값 출력)

console.log('==============================');

/*
    do-while 반복문
    - 반복할 코드 블럭을 한 번은 반드시 실행하고 조건을 확인
*/
let randomNumber2 = 0;
do {
    randomNumber2 = Math.random();
    console.log(randomNumber2);
} while (randomNumber2 > 0.5);
// 출력: (0.5 보다 큰 랜덤한 값 출력)

console.log('==============================');

/*
    break 문 
    - switch문, 반복문에서 코드 블럭을 강제로 탈출 할 때 사용
*/
let count = 0;
while (true) {
    if (count === 5) break;
    console.log(count++);
}
// 출력: 0 / 1 / 2 / 3 / 4

console.log('==============================');

/*
    continue 문
    - 반복문의 진행 위치를 맨 마지막으로 이동시킴
*/
count = 0;
// while (true) {
//     if (count % 2 === 0) continue;
//     if (count === 10) break;
//     console.log(count++);
// }
// 첫 번째 if문을 돌 때 0은 count % 2 === 0 조건식에서 참이기 때문에 continue로 빠져나가서 맨 위의 코드로 이동한다.
// 이때 count가 증가되지 않고 계속 0으로 잡혀있기 때문에 무한루프에 빠진다.

while (true) {
    if (count === 10) break;
    if (count % 2 === 0) {
        count++;
        continue;
    }
    console.log(count++);
}
// 출력: 1 / 3 / 5 / 7 / 9