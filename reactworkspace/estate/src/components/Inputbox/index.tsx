import React, { ChangeEvent } from 'react';
import './style.css';

export interface InputBoxProps {
  label: string;
  type: 'text' | 'password';
  value: string;
  placeholder: string;
  onChangeHandler: (event: ChangeEvent<HTMLInputElement>) => void;
  buttonTitle?: string;
  buttonStatus?: boolean;
}

export default function InputBox({label, type, value, placeholder, onChangeHandler, buttonTitle, buttonStatus}: InputBoxProps) {

  const buttonClass = buttonStatus ? 'input-primary-button' : 'input-disable-button';

  return (
    <div className="input-box">
      <div className="input-label label">{label}</div>
      <div className="input-content-box">
        <input className="input" type={type} value={value} placeholder={placeholder} onChange={onChangeHandler} />
        { buttonTitle && 
        <div className={buttonClass}>{buttonTitle}</div> }
      </div>
      <div className="input-message"></div>
    </div>
  )
}
