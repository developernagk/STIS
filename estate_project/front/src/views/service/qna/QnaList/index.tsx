import React, { useEffect, useState } from 'react';
import './style.css';
import { useUserStore } from 'src/stores';
import { useNavigate } from 'react-router';
import { AUTH_ABSOLUTE_PATH, COUNT_PER_PAGE, COUNT_PER_SECTION, QNA_DETAIL_ABSOLUTE_PATH, QNA_WRITE_ABSOLUTE_PATH } from 'src/constant';
import { BoardListItem } from 'src/types';
import { getBoardListRequest } from 'src/apis/board';
import { useCookies } from 'react-cookie';
import ResponseDto from 'src/apis/response.dto';
import { GetBoardListResponseDto } from 'src/apis/board/dto/response';

//   component   //
function ListItem({ receptionNumber, status, title, writerId, writeDatetime, viewCount }: BoardListItem) {
  //   function   //
  const navigator = useNavigate();

  //   event handler   //
  const onClickHandler = () => navigator(QNA_DETAIL_ABSOLUTE_PATH(receptionNumber));

  //   render   //
  return (
    <div className="qna-list-table-tr" onClick={onClickHandler}>
      <div className="qna-list-table-reception-number">{receptionNumber}</div>
      <div className="qna-list-table-status">
        {status ? <div className="disable-badge">완료</div> : 
        <div className="primary-badge">접수</div>
        }
      </div>
      <div className="qna-list-table-title" style={{ textAlign: 'left' }}>{title}</div>
      <div className="qna-list-table-writer-id">{writerId}</div>
      <div className="qna-list-table-write-date">{writeDatetime}</div>
      <div className="qna-list-table-view-count">{viewCount}</div>
    </div>
  )
} 

//   component   //
export default function QnaList() {
  //   state   //
  const { loginUserRole } = useUserStore();

  const [cookies] = useCookies();

  const [boardList, setBoardList] = useState<BoardListItem[]>([]);
  const [viewList, setViewList] = useState<BoardListItem[]>([]);
  const [totalLength, setTotalLength] = useState<number>(0);
  const [totalPage, setTotalPage] = useState<number>(1);
  const [currentPage, setCurrentPage] = useState<number>(1);
  const [pageList, setPageList] = useState<number[]>([1]);
  const [totalSection, setTotalSection] = useState<number>(1);
  const [currentSection, setCurrentSection] = useState<number>(1);
  const [isToggleOn, setToggleOn] = useState<boolean>(false);

  //   function   //
  const navigator = useNavigate();

  const getBoardListResponse = (result: GetBoardListResponseDto | ResponseDto | null) => {
    const message = 
      !result ? '서버에 문제가 있습니다.' : 
      result.code === 'AF' ? '인증에 실패했습니다.' : 
      result.code === 'DBE' ? '서버에 문제가 있습니다.' : 
      '';
    if (!result || result.code !== 'SU') {
      alert(message);
      if (result?.code === 'AF') navigator(AUTH_ABSOLUTE_PATH);
      return;
    }
    const { boardList } = result as GetBoardListResponseDto;
    setBoardList(boardList);

    const totalLength = boardList.length;
    setTotalLength(totalLength);

    const totalPage = Math.floor((totalLength - 1) / COUNT_PER_PAGE) + 1;
    setTotalPage(totalPage);

    const totalSection = Math.floor((totalPage - 1) / COUNT_PER_SECTION) + 1;
    setTotalSection(totalSection);

    const startIndex = (currentPage - 1) * COUNT_PER_PAGE;
    let endIndex = currentPage * COUNT_PER_PAGE;
    if (endIndex > totalLength - 1) endIndex = totalLength;
    const viewList = boardList.slice(startIndex, endIndex);
    setViewList(viewList);

    const startPage = (currentSection * COUNT_PER_SECTION) - (COUNT_PER_SECTION - 1);
    let endPage = currentSection * COUNT_PER_SECTION;
    if (endPage > totalPage) endPage = totalPage;
    const pageList: number[] = [];
    for (let page = startPage; page <= endPage; page++) pageList.push(page);
    setPageList(pageList);
  };

  //   event handler   //
  const onWriteButtonClickHandler = () => {
    if (loginUserRole !== 'ROLE_USER') return;
    navigator(QNA_WRITE_ABSOLUTE_PATH);
  };

  const onToggleClickHandler = () => {
    if (loginUserRole !== 'ROLE_ADMIN') return;
    setToggleOn(!isToggleOn);
  };

  //   effect  //
  useEffect(() => {
    if (!cookies.accessToken) return;
    getBoardListRequest(cookies.accessToken).then(getBoardListResponse);
  }, []);

  //   render   //
  const toggleClass = isToggleOn ? 'toggle-active' : 'toggle';
  return (
    <div id="qna-list-wrapper">
      <div className="qna-list-top">
        <div className="qna-list-size-text">전체 <span className="emphasis">{totalLength}건</span> | 페이지 <span className="emphasis">{currentPage}/{totalPage}</span></div>
        <div className="qna-list-top-rignt">
          {loginUserRole === 'ROLE_USER' ? 
          <div className="primary-button" onClick={onWriteButtonClickHandler}>글쓰기</div> : 
          <>
            <div className={toggleClass} onClick={onToggleClickHandler}></div>
            <div className="qna-list-top-admin-text">미완료 보기</div>
          </>}
        </div>
      </div>
      <div className="qna-list-table">
        <div className="qna-list-table-th">
          <div className="qna-list-table-reception-number">접수번호</div>
          <div className="qna-list-table-status">상태</div>
          <div className="qna-list-table-title">제목</div>
          <div className="qna-list-table-writer-id">작성자</div>
          <div className="qna-list-table-write-date">작성일</div>
          <div className="qna-list-table-view-count">조회수</div>
        </div>
        {viewList.map(item => <ListItem {...item} />)}
      </div>
      <div className="qna-list-bottom">
        <div style={{ width: '299px' }}></div>
        <div className="qna-list-pagenation">
          <div className="qna-list-page-left"></div>
          <div className="qna-list-page-box">
            {pageList.map(page => 
              page === currentPage ?
              <div className="qna-list-page-active">{page}</div> : 
              <div className="qna-list-page">{page}</div>
            )}
          </div>
          <div className="qna-list-page-right"></div>
        </div>
        <div className="qna-list-search-box">
          <div className="qna-list-search-input-box">
            <input className="qna-list-search-input" />
          </div>
          <div className="disable-button">검색</div>
        </div>
      </div>
    </div>
  )
}
