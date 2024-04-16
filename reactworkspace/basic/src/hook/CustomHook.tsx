import React, { useState } from 'react'

// Custom Hook :
// - 리액트의 훅 함수는 반드시 함수형 컴포넌트의 코드 블럭에서만 호출 가능

export default function CustomHook() {
  // 총 게시물 수 : 107개
  // 한 페이지 게시물 5개씩 보여줌
  // 페이지네이션을 한 섹션 당 10개씩 보여줌

  // 총 페이지 수 : 22
  // 한 페이지 당 보여주고 싶은 게시물의 수
  // totalPageCount = Math.floor((boardCount - 1) / 5) + 1

  // 총 섹션 수 : 3
  // 한 섹션 당 보여주고 싶은 게시물의 수
  // totalSectionCount = Math.floor((boardCount - 1) / (5 * 10)) + 1

  // currentPageStart = 5 * (page - 1)
  // currentPageEnd = 5 * page - 1

  // viewList = [];
  // for (index = currentPageStart; index <= currentPageEnd; ++)
  //  if (index >= boardList.length) break;  
  //   viewList.push(boardList[index])

  const [page, setPage] = useState<number>(1);
  const [section, setSection] = useState<number>(1);
  const [boardList, setboardList] = useState<any[]>([]);
  const [viewList, setViewList] = useState<any[]>([]);

  const setNextPage = () => {

  }

  const setPreviousPage = () => {

  }

  const setNextSection = () => {

  }

  const setPreviousSection = () => {

  }

  return (
    <div>CustomHook</div>
  )
}
