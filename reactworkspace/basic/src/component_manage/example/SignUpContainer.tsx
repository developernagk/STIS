import React from 'react'
import InputBox, { InputBoxProps } from './InputBox';
import './common.css'
import './style.css'

const InputBoxes: InputBoxProps[] = [
  { label: '아이디', type: 'text', placeholder: '아이디를 입력하세요.', check: '중복 확인'}, 
  { label: '비밀번호', type: 'password', placeholder: '비밀번호를 입력하세요.'},
  { label: '비밀번호 확인', type: 'password', placeholder: '비밀번호를 입력하세요.'},
  { label: '이메일', type: 'text', placeholder: '이메일을 입력하세요.', check: '이메일 인증'},
  { label: '인증번호', type: 'text', placeholder: '인증번호를 입력하세요.', check: '인증 확인'}
];


export default function SignUpContainer() {

  const InputBoxComponent = InputBoxes.map((item, index) => <InputBox key={index} {...item} />)

  return (
    <>
      {InputBoxComponent}
    </>
  );
}