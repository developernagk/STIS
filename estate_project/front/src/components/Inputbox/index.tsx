import React, { ChangeEvent, KeyboardEvent } from 'react';
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
  onKeydownHandler?: (event: KeyboardEvent<HTMLInputElement>) => void;
}

//   component   //
export default function InputBox({ label, type, value, placeholder, onChangeHandler, buttonTitle, buttonStatus, onButtonClickHandler, message, error, onKeydownHandler }: InputBoxProps) {
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
        <div className={buttonClass} onClick={onButtonClickHandler} onKeyDown={onKeydownHandler}>
          {buttonTitle}
        </div> }
      </div>
      <div className={messageClass}>
        {message}
      </div>
    </div>
  )
}
