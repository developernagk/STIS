/*
    클래스 정의 :
    - 속성을 사전 정의해서 사용
*/
class Sample1 {
    field: string;

    constructor (field: string) {
        this.field = field;
    }
}

console.log('==================================================');

/*
    접근 제어자
    - public: 클래스 내부, 자식 클래스 내부, 모든 위치
    - protected: 클래스 내부, 자식 클래스 내부
    - private: 클래스 내부
    - typescript에는 패키지라는 개념이 없기 때문에 기본적으로 public으로 지정됨
*/
class Sample2 {
    private privateField: string;
    protected protectedField: string;
    public publicField: string;

    constructor () {
        this.privateField = 'private 필드';
        this.protectedField = 'protected 필드';
        this.publicField = 'public 필드';
    }
}

console.log('==================================================');

/*
    생성자 매개변수에 접근 제어자 지정
    - 생성자의 매개변수에 접근 제어자를 지정하여 필드 선언 가능
*/
class Sample3 {
    constructor (
        public publicField: string,
        protected protectedField: string,
        private privateField: string,
        // 필드에 존재하지 않고 매개변수로만 지정됨
        // 접근 제어자를 따로 지정하지 않았기 때문에 매개변수로 인식
        localVariable: string
    ) {
        this.publicField = publicField;
        // this.localVariable = localVariable;
    }
}

// 필드에 선언했을 경우
// class Sample3 {
//     public publicField: string;
//         protected protectedField: string;
//         private privateField: string;
//         localVariable: string;

//     constructor () {
//         this.publicField = 'public';
//         this.protectedField = 'protected';
//         this.privateField = 'private';
//         this.localVariable = 'local';
//     }
// }
// const sample3Instance = new Sample3();
// console.log(sample3Instance);

console.log('==================================================');

/*
    readonly :
    - readonly가 선언된 클래스 속성은 선언 시 또는 생성자 내부에서만 값을 할당할 수 있음
    - 값을 재할당할 수 없고 오직 읽기만 가능
    - 상수 선언에 사용됨
*/
class Sample4 {
    public readonly field1: string = 'public 읽기 전용 필드1';
    public readonly field2: string;

    constructor (
        field2: string,
        public readonly field3: string
    ) {
        this.field2 = field2;
    }
}
const sample4Instance = new Sample4('public 읽기 전용 필드2', 'public 읽기 전용 필드3');
console.log(sample4Instance);
// 출력
// Sample4 {
//     field3: 'public 읽기 전용 필드3',
//     field1: 'public 읽기 전용 필드1',
//     field2: 'public 읽기 전용 필드2'
// }

// sample4Instance.field1 = '변경';

console.log('==================================================');

/*
    추상 클래스 :
    - 하나 이상의 추상 메서드를 포함하는 클래스, abstract 키워드로 선언
*/
abstract class AbstractClass {
    abstract abstractMethod (arg: string): string;
}

class SubClass extends AbstractClass {
    abstractMethod(arg: string): string {
        return arg;
    }
}

console.log('==================================================');