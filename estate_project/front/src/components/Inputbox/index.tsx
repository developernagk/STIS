import React, { ChangeEvent } from 'react';
import './style.css';

//   interface   //
export interface InputBoxProps {
  label: string;
  type: 'text' | 'password';
  value: string;
  placeholder: string;
  onChangeHandler: (event: ChangeEvent<HTMLInputElement>) => void;
  buttonTitle?: string;
  buttonStatus?: boolean;
  onButtonClickHandler?: () => void;
  message?: string;
  error?: boolean;
}

//   function   //
export default function InputBox({ label, type, value, placeholder, onChangeHandler, buttonTitle, buttonStatus, onButtonClickHandler, message, error }: InputBoxProps) {
  //   state   //
  const buttonClass = buttonStatus ? 'input-primary-button' : 'input-disable-button';
  const messageClass = 'input-message ' + (error ? 'error' : 'primary');

  //   render   //
  return (
    <div className="input-box">
      <div className="input-label label">{label}</div>
      <div className="input-content-box">
        <input className="input" type={type} value={value} placeholder={placeholder} onChange={onChangeHandler} />
        { buttonTitle && 
        <div className={buttonClass} onClick={onButtonClickHandler}>
          {buttonTitle}
        </div> }
      </div>
      <div className={messageClass}>
        {message}
      </div>
    </div>
  )
}
