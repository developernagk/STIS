import React, { useState } from 'react';
import './style.css';

type AuthPage = 'sign-in' | 'sign-up';

interface Props {
  onLinkClickHandler: () => void;
}

function SignIn ({ onLinkClickHandler }: Props) {

  const onSignInButtonClickHandler = () => {

  };

  return (
    <div className="authentication-contents">
      <div className="authentication-input-container"></div>
      <div className="authentication-button-container">
        <div className="primary-button full-width" onClick={onSignInButtonClickHandler}>로그인</div>
        <div className="text-link" onClick={onLinkClickHandler}>회원가입</div>
      </div>
      <div className="short-divider"></div>
      <div className="authentication-sns-container"></div>
    </div>
  );
}

function SignUp ({ onLinkClickHandler }: Props) {

  const onSignUpButtonClickHandler = () => {

  };

  return (
    <div className="authentication-contents">
      <div className="authentication-sns-container"></div>
      <div className="short-divider"></div>
      <div className="authentication-input-container"></div>
      <div className="authentication-button-container">
        <div className="primary-button full-width" onClick={onSignUpButtonClickHandler}>회원가입</div>
        <div className="text-link" onClick={onLinkClickHandler}>로그인</div>
      </div>
    </div>
  );
}

export default function Authentication() {

  // useState는 반드시 컴포넌트 안에 선언되어야 함
  // 컴포넌트 바로 아래에 선언되어야 하고 컴포넌트 내에 선언된 함수 안에서 사용 불가능
  const [page, setPage] = useState<AuthPage>('sign-in');

  // 자식 컴포넌트에서 선언하고 싶을 경우 전역에 interface로 선언을 하고 매개변수로 받아온 뒤 사용
  const onLinkClickHandler = () => {
    if (page === 'sign-in') setPage('sign-up');
    else setPage('sign-in');
  };

  const AutenticationContents = page === 'sign-in' ? <SignIn onLinkClickHandler={onLinkClickHandler} /> : <SignUp onLinkClickHandler={onLinkClickHandler}/>;

  return (
    <div id="authentication-wrapper">
      <div className="authentication-image-box"></div>
      <div className="authentication-box">
        <div className="authentication-container">
          <div className="authentication-title h1">{'임대주택 가격 서비스'}</div>
          { AutenticationContents }
        </div>
      </div>
    </div>
  )
}
