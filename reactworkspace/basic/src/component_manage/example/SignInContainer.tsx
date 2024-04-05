import React from 'react'
import InputBox from './InputBox';
import './common.css'
import './style.css'


export default function SignInContainer() {
  return (
    <>
      <InputBox label='아이디' type='text' placeholder='아이디를 입력하세요.' check='중복 확인' />
      <InputBox label='비밀번호' type='password' placeholder='비밀번호를 입력하세요.' />
    </>
  );
}