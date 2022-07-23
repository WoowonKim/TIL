import "../App.css";
import logo from ".././logo.png";
import { LoginInput, GreenBtn } from "../components/styled";
import "../css/Login.css";
import { Link } from "react-router-dom";
import { useState } from "react";

const Regist = () => {
  let [confirmFlag, setConfirmFlag] = useState(false);

  return (
    <div className="Login">
      <img src={logo} className="App-logo" alt="logo" />
      <LoginInput placeholder="email"></LoginInput>
      {confirmFlag ? <GreenBtn>인증 메일 다시 보내기</GreenBtn> : null}
      {confirmFlag ? (
        <div>
          <LoginInput
            style={{ width: "205px", marginRight: "10px" }}
            placeholder="인증 번호"
          ></LoginInput>
          <GreenBtn style={{ width: "105px", marginLeft: "10px" }}>
            {" "}
            인증하기
          </GreenBtn>
        </div>
      ) : (
        <GreenBtn
          onClick={() => {
            setConfirmFlag(!confirmFlag);
          }}
        >
          이메일 인증하기
        </GreenBtn>
      )}
      <LoginInput placeholder="비밀번호"></LoginInput>
      <LoginInput placeholder="비밀번호 확인"></LoginInput>
      <Link to="username">
        <GreenBtn style={{ width: "150px" }}>가입하기</GreenBtn>
      </Link>
      <div className="hr-sect">
        <span>이미 회원이신가요?</span>
      </div>
      <Link to="/" className="regist-find">
        로그인 하기
      </Link>
    </div>
  );
};

export default Regist;
