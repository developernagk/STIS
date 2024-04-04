// SignInContainer 함수형 컴포넌트를 생성
// 해당 컴포넌트는 InputBox 컴포넌트를 2개 포함
// SignInContainer 컴포넌트를 기본 값으로 내보내기

import React from 'react'
import { IdInputBox, PasswordInputBox } from './InputBox';
import './common.css'
import './style.css'


export default function SignInContainer() {
  return (
    <>
      <IdInputBox label='아이디' type='text' placeholder='아이디를 입력하세요.' />
      <PasswordInputBox />
    </>
  );
}