import logo from ".././logo.png";
import "../css/Forgot.css";
import { Link } from "react-router-dom";
import { useState } from "react";
import { LoginInput, GreenBtn, WarningText } from "../components/styled.jsx";
import axios from "axios";

const Login = () => {
  let [inputEmail, setInputEmail] = useState();
  let [inputPassword, setInputPassword] = useState();
  let [loginWarning, setLoginWarning] = useState(false);

  const submitLogin = (e) => {
    e.preventDefault();
    axios
      .post("eco/user/login", {
        email: inputEmail,
        password: inputPassword,
        social_type: 0,
      })
      .then((res) => {
        console.log(res);
      })
      .catch(setLoginWarning(true));
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
      {loginWarning ? (
        <WarningText>
          등록되지 않은 이메일이거나 비밀번호가 일치하지 않습니다.
        </WarningText>
      ) : null}
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
        아직 회원이 아니에요
      </Link>
      <Link to="/forgot" className="regist-find">
        비밀번호를 잊어버렸어요
      </Link>
    </div>
  );
};

export default Login;
