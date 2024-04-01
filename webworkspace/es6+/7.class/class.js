/*
    클래스 정의 : class 키워드를 사용하여 선언
    - constructor를 이용해서 멤버 변수를 선언 및 초기화를 할 수 있음
    - 생성자에서 this를 이용해서 멤버 변수를 지정
    - new 연산자를 통해서 인스턴스를 생성할 수 있음
*/
// 왕 클래스 : 이름 / 묘명 / 생일 / 사망일
// class King {
//     constructor () {
//         this.name = '이성계';
//         this.tombName = '태조';
//         this.birth = '1335-11-04';
//         this.death = '1408-06-27';
//     }
// }

// const taejo = new King();
// console.log(taejo);

console.log('==================================================');

/*
    constructor: 
    - 인스턴스를 생성하고 클래스 필드를 초기화하기 위한 용도로 사용되는 특수한 메서드(생성자)
    - 생성자 안에서 this 키워드를 이용해서 클래스의 멤버 변수를 선언하고 초기화할 수 있음
    - 생성자의 매개변수로 각 속성의 값을 받아서 초기화
    - 자바스크립트의 생성자는 오버로드가 되지 않음
*/
class King {
    // constructor () {  }
    constructor (name, tombName, birth, death) {
        this.name = name;
        this.tombName = tombName;
        this.birth = birth;
        this.death = death;
    }
}

const jeongjong = new King('이방과', '정종', '1357-07-26', '1419-10-24');
// console.log(jeongjong); 출력: SyntaxError: A class may only have one constructor
console.log(jeongjong);
// 출력
// King {
//     name: '이방과',
//     tombName: '정종',
//     birth: '1357-07-26',
//     death: '1419-10-24'
// }

console.log('==================================================');

/*
    클래스의 필드 선언 : ES6+의 클래스가 가질 수 있는 제어자
    - public 필드
    - private 필드
    - 정적(static) public 필드
    - 정적(static) private 필드
*/ 
class Sample1 {
    // public 필드
    publicField;
    // private 필드
    #privateField;
    // static 필드는 인스턴스로 사용 불가능
    // 정적(static) public 필드
    static staticPublicField = '정적 public 필드';
    // 정적(static) private 필드
    static #staticPrivateField = '정적 private 필드';

    constructor (publicField, privateField) {
        this.publicField = publicField;
        this.#privateField = privateField;
        // this.staticPublicField = publicField;
        // this.#staticPrivateField = privateField;
    }
}


console.log('==================================================');

/*
    getter, setter : 
    - 
    - 
*/



console.log('==================================================');

/*
    인스턴스 메서드와 정적 메서드 : 
    - 
    - 
*/



console.log('==================================================');

/*
    클래스 상속 : 
    - 
    - 
    - 
*/


