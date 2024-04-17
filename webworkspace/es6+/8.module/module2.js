/*
    import from:
    - 타 모듈에서 export한 대상을 로드
    - 타 모듈에서 export 내보내면 {  }를 사용하여 import 해야 함, 이름이 같아야 함
    - 타 모듈에서 export default로 내보내면 {  } 없이 import함, 내보낸 이름과 받아오는 이름이 달라도 됨
*/
import { exportVariable, exportFunction, exportClass } from './module.mjs';
console.log(exportVariable); // 출력: export 변수

import defaultVariable from './module.mjs';
console.log(defaultVariable); // 출력: export default 변수

/*
    - as 키워드로 export로 내보낸 대상의 이름을 변경하여 사용할 수 있음
*/
import { exportVariable as ev } from './module.mjs';
console.log(ev); // 출력: export 변수

/*
    - 타 모듈의 모든 대상을 한 번에 받을 때는 * 키워드 사용해서 가져올 수 있음
    - as 키워드 필요
*/
import * as md from './module.mjs';
console.log(md);
// 출력
// [Module: null prototype] {
//     default: 'export default 변수',
//     exportClass: [class exportClass],
//     exportFunction: [Function: exportFunction],
//     exportVariable: 'export 변수'
// }

/*
    - 모듈의 이름이 index이면 해당 모듈의 폴더명으로 import 가능
*/
import { indexExport } from './folder';
console.log(indexExport);