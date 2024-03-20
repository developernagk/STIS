/*
    배열 고차 함수
    - 배열의 불변성을 최대한 보장하여 부수 효과를 제거한 메서드
*/
const array = [7, 11, 20, 1, 8, 3, 16, 2, 19, 9, 10, 4, 13, 12, 14, 17, 15, 5, 18, 6];

/*
    sort(비교 함수) : 배열의 요소를 적절하게 정렬
    - 단순 .sort()로 정렬하면 사전식 정렬을 하게 됨
*/
// array.sort();
// console.log(array);
// 출력: [
//     1, 10, 11, 12, 13, 14, 15,
//    16, 17, 18, 19,  2, 20,  3,
//     4,  5,  6,  7,  8,  9
//  ]
const asc = function (x, y) {
    return x - y;
}
array.sort(asc);
console.log(array);
// 출력: [
//     1,  2,  3,  4,  5,  6,  7,
//     8,  9, 10, 11, 12, 13, 14,
//    15, 16, 17, 18, 19, 20
//  ]
array.sort(function (x, y) { return y - x });
console.log(array);
// 출력: [
//     20, 19, 18, 17, 16, 15, 14,
//     13, 12, 11, 10,  9,  8,  7,
//      6,  5,  4,  3,  2,  1
//  ]

const objects = [
    { x: 9, y: -5 },
    { x: -2, y: 0 },
    { x: 0, y: -3 },
    { x: 6, y: 5 }
];
console.log(objects); // 출력: [ { x: 9, y: -5 }, { x: -2, y: 0 }, { x: 0, y: -3 }, { x: 6, y: 5 } ]
objects.sort(function (a, b) {
    return a.x - b.x;
});
console.log(objects);
// 출력(x값 기준): [ { x: -2, y: 0 }, { x: 0, y: -3 }, { x: 6, y: 5 }, { x: 9, y: -5 } ]
// 출력(y값 기준): [ { x: 9, y: -5 }, { x: 0, y: -3 }, { x: -2, y: 0 }, { x: 6, y: 5 } ]

console.log('==============================');

/*
    forEach(콜백 함수) : for문 대신 사용
    - 배열을 순회하면서 각 요소와 인덱스를 사용할 수 있도록 함
    - 원본 배열 변경 X
    - break, continue, ... 부가적인 작업을 추가 X
    - for문보다 성능 떨어짐, 가독성이 좋고 편리하므로 자주 사용됨
    - async await 작업은 forEach문으로 사용 불가
*/
array.forEach(function (item, index) {
    console.log(`index : ${index}, item : ${item}`);
});
// 출력: (인덱스 키 : 값)

console.log('==============================');

/*
    map(콜백 함수) : 콜백 함수의 반환값들로 이루어진 새로운 배열 생성해서 반환
    - 원본 배열 변경 X
    - forEach 단순히 요소를 가지고 작업만 진행(반환값X), map 요소를 가지고 작업한 결과로 배열 새로 만듦(반환값O)
*/
const mapArray = array.map(function (item, index) {
    console.log(`index : ${index}, item : ${item}`);
    return item * item;
}); // 출력: (인덱스 키 : 값)
console.log(mapArray); // 출력: (20~1까지 제곱한 값 배열로 반환)
console.log(array); // 출력: (20~1까지 배열로 반환)

console.log('==============================');

/*
    filter(콜백 함수) : 콜백 함수의 반환값이 true인 배열의 요소 값만을 추출한 새로운 배열을 생성
    - 배열에서 특정 케이스만 필터링 조건으로 추출하여 새로운 배열을 만들고 싶을 때 사용
    - 원본 배열 변경 불가능
*/
const filterArray = array.filter(function (item, index) {
    return item % 2 === 1;
});
console.log(filterArray); // 출력: (array에서 홀수 값만 반환)
console.log(array); // 출력: (20~1까지 배열로 반환)

console.log('==============================');

/*
    find(콜백 함수) : 콜백 함수의 결과가 true인 첫 번째 요소를 반환
*/
const findResult = array.find(function (item, index) {
    return item % 2 === 1;
});
console.log(findResult); // 출력: 19

console.log('==============================');

/*
    findIndex(콜백 함수) : 콜백 함수 결과가 true인 첫 번째 요소의 인덱스를 반환
*/
const findIndexResult = array.findIndex(function (item, index) {
    return item % 2 === 1;
});
console.log(findIndexResult); // 출력: 1

console.log('==============================');