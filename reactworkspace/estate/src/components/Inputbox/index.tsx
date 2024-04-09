import React from 'react';
import './style.css';

export interface InputBoxProps {
  label: string;
  type: 'text' | 'password';
  placeholder: string;
  check?: string;
}

export default function InputBox({label, type, placeholder, check}: InputBoxProps) {
  return (
    <div className="input-box">
      <div className="input-label label">{label}</div>
      <div className="input-content-box">
        <input className="input" type={type} placeholder={placeholder} />
        { check && 
        <div className="input-disable-button">{check}</div> }
      </div>
      <div className="input-message"></div>
    </div>
  )
}
