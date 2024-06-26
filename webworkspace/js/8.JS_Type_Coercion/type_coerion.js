/*
    암묵적 형변환
*/

/*
    문자열 타입으로 형변환
    - + 연산자를 사용할 때 좌항과 우항 중 하나라도 문자열이 존재하면 문자열이 아닌 항을 문자열로 변경하여 연결 연산
*/
console.log(1 + '1');
// 출력: 11(string)

console.log('==============================');

/*
    숫자 타입으로 형변환
    - + 연산자를 제외한 나머지 산술 연산 혹은 대소 비교 연산에 대하여
    좌,우항 중 하나라도 숫자가 존재하면 숫자가 아닌 항을 숫자 타입으로 변경하여 연산을 진행(변경이 가능한 것이어야 함)
*/
console.log('1' - 0);
// 출력: 1

console.log('==============================');

/*
    불리언 타입으로 형변환
    - '', 0, -0, NaN, null, undefined는 false, 그 이외의 데이터에 대해서는 true로 변경하여 연산을 진행
*/
if (null) console.log('null');
if (!null) console.log('not null');
// 출력: not null

console.log('==============================');

/*
    명시적 형변환
*/

/*
    문자열 타입으로 형변환
    - String 클래스 생성자를 new 연산자 없이 사용
    - 데이터.toString()
    - 데이터 + ''
*/
console.log(String(10));
console.log(typeof String(10));
// 출력: 10 / string

console.log((10).toString());
console.log(typeof (10).toString());
// 출력: 10 / string

console.log('==============================');

/*
    숫자 타입으로 형변환
    - Number 클래스의 생성자를 new 연산자 없이 사용
    - 문자열일 경우 parseInt(), parseFloat() 메서드 사용 가능
    - + 단항 연산자 사용 가능
*/
console.log(Number(false));
console.log(typeof Number(false));
// 출력: 0 / number

console.log(parseInt('10'));
console.log(typeof parseInt('10'));
// 출력: 10 / number

console.log(parseFloat('10.8'));
console.log(typeof parseFloat('10.8'));
// 출력: 10.8 / number

console.log('==============================');

/*
    불리언 타입으로 형변환
    - Boolean 클래스의 생성자를 new 연산자 없이 사용
    - !! 사용 가능
*/
console.log(Boolean('문자열'));
// 출력: true
console.log(!'문자열');
// 출력: false
console.log(!!'문자열');
// 출력: true

console.log('==============================');

/*
    단축 평가 
    - 논리 연산자는 논리 결과를 결정한 피연산자의 결과를 그대로 반환
    - true && data -> data
    - false && data -> false
    - true || data -> true
    - false || data -> data
*/
console.log('홍길동' || false);
// 출력: 홍길동
