import logo from ".././logo.png";
import styled from "styled-components";
import "../css/Login.css";
import "../App.css";
import { Link } from "react-router-dom";
import { useState } from "react";

let LoginInput = styled.input`
  background: #f7f8f9;
  border: 1px solid #dadada;
  border-radius: 8px;
  width: 330px;
  height: 50px;
  padding-left: 10px;
`;
let GreenBtn = styled.button`
  background: #adc178;
  border: 1px solid #dadada;
  border-radius: 8px;
  width: 340px;
  height: 50px;
  text-align: center;
  color: white;
  cursor: pointer;
`;

const Login = () => {
  let [inputEmail, setInputEmail] = useState();
  let [inputPassword, setInputPassword] = useState();
  const submitLogin = (e) => {
    e.preventDefault();
    alert(inputEmail + inputPassword);
  };
  return (
    <div className="Login">
      <img src={logo} className="App-logo" alt="logo" />
      <LoginInput
        placeholder="email"
        onChange={(e) => {
          setInputEmail(e.target.value);
        }}
      />
      <LoginInput
        placeholder="password"
        type="password"
        onChange={(e) => {
          setInputPassword(e.target.value);
        }}
      />
      <div className="form-group">
        <input type="checkbox" id="autoLogin"></input>
        <label className="AutoLoginCheckBoxLabel" htmlFor="autoLogin">
          로그인 상태 유지
        </label>
      </div>
      <GreenBtn onClick={submitLogin}>로그인</GreenBtn>
      <div className="hr-sect">
        <span>sns로 3초만에 시작하기</span>
      </div>
      <div className="social-login-btn">
        <img
          src={process.env.PUBLIC_URL + "google-login icon.jpg"}
          alt="googleLogin"
        ></img>
        <img
          src={process.env.PUBLIC_URL + "/kakao_login_small.png"}
          alt="kakaoLogin"
        ></img>
      </div>
      <div className="hr-sect">
        <span>제가</span>
      </div>
      <Link to="/regist" className="regist-find">
        제가 아직 회원이 아니에요
      </Link>
      <Link to="/forgot" className="regist-find">
        비밀번호를 잊어버렸어요
      </Link>
    </div>
  );
};

export default Login;
