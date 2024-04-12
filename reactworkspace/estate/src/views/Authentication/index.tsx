import React, { ChangeEvent, useState } from 'react';
import './style.css';

import SignInBackground from 'assets/image/sign-in-background.png';
import SignUpBackground from 'assets/image/sign-up-background.png';
import InputBox from 'components/Inputbox';

type AuthPage = 'sign-in' | 'sign-up';

interface SnsContainerProps {
  title: string;
}

function SnsContainer({ title }: SnsContainerProps) {

  const onSnsButtonClickHandler = (type: 'kakao' | 'naver') => {
    alert(type);
  };

  return (
    <div className="authentication-sns-container">
      <div className="sns-container-title label">{title}</div>
      <div className="sns-button-container">
        <div className="sns-button kakao-button" onClick={() => onSnsButtonClickHandler('kakao')}></div>
        <div className="sns-button naver-button" onClick={() => onSnsButtonClickHandler('naver')}></div>
      </div>
    </div>
  );
}

interface Props {
  onLinkClickHandler: () => void;
}

function SignIn ({ onLinkClickHandler }: Props) {

  const [id, setId] = useState<string>('');
  const [password, setPassword] = useState<string>('');

  const onIdChangeHandler = (event: ChangeEvent<HTMLInputElement>) => {
    setId(event.target.value);
  };

  const onPasswordChangeHandler = (event: ChangeEvent<HTMLInputElement>) => {
    setPassword(event.target.value);
  };

  const onSignInButtonClickHandler = () => {
    alert(`아이디: ${id} / 비밀번호: ${password}`);
    setId('');
    setPassword('');
  };

  return (
    <div className="authentication-contents">
      <div className="authentication-input-container">
        <InputBox label="아이디" type="text" value={id} placeholder="아이디를 입력해주세요." onChangeHandler={onIdChangeHandler} />
        <InputBox label="비밀번호" type="password" value={password} placeholder="비밀번호를 입력해주세요." onChangeHandler={onPasswordChangeHandler} />
      </div>
      <div className="authentication-button-container">
        <div className="primary-button full-width" onClick={onSignInButtonClickHandler}>로그인</div>
        <div className="text-link" onClick={onLinkClickHandler}>회원가입</div>
      </div>
      <div className="short-divider"></div>
      <SnsContainer title="SNS 로그인" />
    </div>
  );
}

function SignUp ({ onLinkClickHandler }: Props) {

  //   state   //
  const [id, setId] = useState<string>('');
  const [password, setPassword] = useState<string>('');
  const [passwordCheck, setPasswordCheck] = useState<string>('');
  const [email, setEmail] = useState<string>('');
  const [authNumber, setAuthNumber] = useState<string>('');

  const [idButtonStatus, setIdButtonStatus] = useState<boolean>(false);
  const [emailButtonStatus, setEmailButtonStatus] = useState<boolean>(false);
  const [authNumberButtonStatus, setAuthNumberBottonStatus] = useState<boolean>(false);

  const [isIdCheck, setIsIdCheck] = useState<boolean>(false);
  const [isEmailCheck, setIsEmailCheck] = useState<boolean>(false);
  const [isAuthNumberCheck, setIsAuthNumerCheck] = useState<boolean>(false);

  const isSignUpActive = isIdCheck && isEmailCheck && isAuthNumberCheck && password && passwordCheck;
  // primary-button full-width / disable-button full-width
  const signUpButtonClass = isSignUpActive ? 'primary-button full-width' : 'disable-button full-width';
  // const signUpButtonClass = (isSignUpActive ? 'primary' : 'disable') + '-button full-width';
  // const signUpButtonClass = `${isSignUpActive ? 'primary' : 'disable'}-button full-width`;

  //   event handler   //
  const onIdChangeHandler = (event: ChangeEvent<HTMLInputElement>) => {
    const { value } = event.target;
    setId(value);
    setIdButtonStatus(value !== '');
    setIsIdCheck(false);
  };

  const onIdButtonClickHandler = () => {
    if (!idButtonStatus) return;
    alert(id);
    setIsIdCheck(true);
  };

  const onPasswordChangeHandler = (event: ChangeEvent<HTMLInputElement>) => {
    const { value } = event.target;
    setPassword(value);
  };

  const onPasswordCheckChangeHandler = (event: ChangeEvent<HTMLInputElement>) => {
    const { value } = event.target;
    setPasswordCheck(value);
};

  const onEmailChangeHandler = (event: ChangeEvent<HTMLInputElement>) => {
    const { value } = event.target;
    setEmail(value);
    setEmailButtonStatus(value !== '');
    setIsEmailCheck(false);
    setIsAuthNumerCheck(false);
  };

  const onEmailButtonClickHandler = () => {
    if (!emailButtonStatus) return;
    alert(email);
    setIsEmailCheck(true);
  }

  const onAuthNumberChangeHandler = (event: ChangeEvent<HTMLInputElement>) => {
    const { value } = event.target;
    setAuthNumber(value);
    setAuthNumberBottonStatus(value !== '');
    setIsAuthNumerCheck(false);
  }

  const onAuthNumberButtonClickHandler = () => {
    if (!authNumberButtonStatus) return;
    alert(authNumber);
    setIsAuthNumerCheck(true);
  }

  const onSignUpButtonClickHandler = () => {
    if (!isSignUpActive) return;
    alert('회원가입');
  };

  //   render   //
  return (
    <div className="authentication-contents">
      <SnsContainer title="SNS 회원가입" />
      <div className="short-divider"></div>
      <div className="authentication-input-container">

        <InputBox label="아이디" type="text" value={id} placeholder="아이디를 입력해주세요." onChangeHandler={onIdChangeHandler} buttonTitle="중복 확인" buttonStatus={idButtonStatus} onButtonClickHandler={onIdButtonClickHandler} error={false} message="사용 가능한 아이디입니다." />

        <InputBox label="비밀번호" type="password" value={password} placeholder="비밀번호를 입력해주세요." onChangeHandler={onPasswordChangeHandler} />

        <InputBox label="비밀번호 확인" type="password" value={passwordCheck} placeholder="비밀번호를 입력해주세요." onChangeHandler={onPasswordCheckChangeHandler} />

        <InputBox label="이메일" type="text" value={email} placeholder="이메일 주소를 입력해주세요." onChangeHandler={onEmailChangeHandler} buttonTitle="이메일 인증" buttonStatus={emailButtonStatus} onButtonClickHandler={onEmailButtonClickHandler} />

        { isEmailCheck && 
        <InputBox label="인증번호" type="text" value={authNumber} placeholder="인증번호 4자리를 입력해주세요." onChangeHandler={onAuthNumberChangeHandler} buttonTitle="인증 확인" buttonStatus={authNumberButtonStatus} onButtonClickHandler={onAuthNumberButtonClickHandler} /> }
        

      </div>
      <div className="authentication-button-container">
        <div className={signUpButtonClass} onClick={onSignUpButtonClickHandler}>회원가입</div>
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

  const imageBoxStyle = {backgroundImage: `url(${page === 'sign-in' ? SignInBackground : SignUpBackground})`};

  return (
    <div id="authentication-wrapper">
      <div className="authentication-image-box" style={imageBoxStyle}></div>
      <div className="authentication-box">
        <div className="authentication-container">
          <div className="authentication-title h1">{'임대주택 가격 서비스'}</div>
          { AutenticationContents }
        </div>
      </div>
    </div>
  )
}
