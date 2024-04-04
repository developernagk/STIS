import React from 'react'
import InputBox from './InputBox';
import './common.css'
import './style.css'


export default function SignInContainer() {
  return (
    <>
      <InputBox label='이메일' type='text' placeholder='이메일 주소를 입력해주세요.' check='이메일 인증' />
    </>
  );
}