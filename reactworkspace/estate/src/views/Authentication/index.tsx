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
  const [isAuthNumberCheck, setIsAuthNumberCheck] = useState<boolean>(false);

  const [idMessage, setIdMessage] = useState<string>('');
  const [passwordMessage, setPasswordMessage] = useState<string>('');
  const [passwordCheckMessage, setPasswordCheckMessage] = useState<string>('');
  const [emailMessage, setEmailMessage] = useState<string>('');
  const [authNumberMessage, setAuthNumberMessage] = useState<string>('');

  const [isIdError, setIsIdError] = useState<boolean>(false);
  const [isEmailError, setIsEmailError] = useState<boolean>(false);
  const [isAuthNumberError, setIsAuthNumberError] = useState<boolean>(false);

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
    setIdMessage('');
  };

  const onIdButtonClickHandler = () => {
    if (!idButtonStatus) return;

    const idCheck = id !== 'admin';
    setIsIdCheck(idCheck);
    setIsIdError(!idCheck);

    const idMessage = idCheck ? '사용 가능한 아이디입니다.' : '이미 사용중인 아이디입니다.';
    setIdMessage(idMessage);
  };

  const onPasswordChangeHandler = (event: ChangeEvent<HTMLInputElement>) => {
    const { value } = event.target;
    setPassword(value);

    const passwordPattern = /^(?=.*[a-zA-Z])(?=.*[0-9]).{8,13}$/;
    const isPasswordPattern = passwordPattern.test(value);
    const passwordMessage = 
      isPasswordPattern ? '' : 
        value ? '영문, 숫자를 혼용하여 8 ~ 13자를 입력해주세요.' : '';
    setPasswordMessage(passwordMessage);

    
    const isEqualPassword = passwordCheck === value;
    const passwordCheckMessage = 
      isEqualPassword ? '' : 
        passwordCheck ? '비밀번호가 일치하지 않습니다.' : '';
    setPasswordCheckMessage(passwordCheckMessage);
  };

  const onPasswordCheckChangeHandler = (event: ChangeEvent<HTMLInputElement>) => {
    const { value } = event.target;
    setPasswordCheck(value);

    const isEqualPassword = password === value;
    const passwordCheckMessage = 
      isEqualPassword ? '' : 
        passwordCheck ? '비밀번호가 일치하지 않습니다.' : '';
    setPasswordCheckMessage(passwordCheckMessage);
};

  const onEmailChangeHandler = (event: ChangeEvent<HTMLInputElement>) => {
    const { value } = event.target;
    setEmail(value);
    setEmailButtonStatus(value !== '');
    setIsEmailCheck(false);
    setIsAuthNumberCheck(false);
    setEmailMessage('');
  };

  const onEmailButtonClickHandler = () => {
    if (!emailButtonStatus) return;

    const emailPattern = /^[a-zA-Z0-9]*@([-.]?[a-zA-Z0-9])*\.[a-zA-Z]{2,4}$/;
    const isEmailPattern = emailPattern.test(email);
    setIsEmailCheck(isEmailPattern);
    setIsEmailError(!isEmailPattern);

    const emailMessage = isEmailPattern ? '인증번호가 전송되었습니다.' : '이메일 형식이 아닙니다.';
    setEmailMessage(emailMessage);
  }

  const onAuthNumberChangeHandler = (event: ChangeEvent<HTMLInputElement>) => {
    const { value } = event.target;
    setAuthNumber(value);
    setAuthNumberBottonStatus(value !== '');
    setIsAuthNumberCheck(false);
    setAuthNumberMessage('');
  }

  const onAuthNumberButtonClickHandler = () => {
    if (!authNumberButtonStatus) return;
    
    const authNumberCheck = authNumber === '1234';
    setIsAuthNumberCheck(authNumberCheck);
    setIsAuthNumberError(!authNumberCheck);

    const authNumberMessage = authNumberCheck ? '인증번호가 확인되었습니다.' : '인증번호가 일치하지 않습니다.';
    setAuthNumberMessage(authNumberMessage);
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

        <InputBox label="아이디" type="text" value={id} placeholder="아이디를 입력해주세요." onChangeHandler={onIdChangeHandler} buttonTitle="중복 확인" buttonStatus={idButtonStatus} onButtonClickHandler={onIdButtonClickHandler} message={idMessage} error={isIdError} />

        <InputBox label="비밀번호" type="password" value={password} placeholder="비밀번호를 입력해주세요." onChangeHandler={onPasswordChangeHandler} message={passwordMessage} error />

        <InputBox label="비밀번호 확인" type="password" value={passwordCheck} placeholder="비밀번호를 입력해주세요." onChangeHandler={onPasswordCheckChangeHandler} message={passwordCheckMessage} error />

        <InputBox label="이메일" type="text" value={email} placeholder="이메일 주소를 입력해주세요." onChangeHandler={onEmailChangeHandler} buttonTitle="이메일 인증" buttonStatus={emailButtonStatus} onButtonClickHandler={onEmailButtonClickHandler} message={emailMessage} error={isEmailError} />

        { isEmailCheck && 
        <InputBox label="인증번호" type="text" value={authNumber} placeholder="인증번호 4자리를 입력해주세요." onChangeHandler={onAuthNumberChangeHandler} buttonTitle="인증 확인" buttonStatus={authNumberButtonStatus} onButtonClickHandler={onAuthNumberButtonClickHandler} message={authNumberMessage} error={isAuthNumberError} /> }
        

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
