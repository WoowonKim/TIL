import "../App.css";
import logo from ".././logo.png";
import { LoginInput, GreenBtn, WarningText } from "../components/styled";
import "../css/Login.css";
import { Link } from "react-router-dom";
import { useState } from "react";

const Regist = () => {
  let [confirmFlag, setConfirmFlag] = useState(false);
  let [inputEmail, setInputEmail] = useState("");
  let [inputPassword, setInputPassword] = useState("");
  let [passwordFlag, setPasswordFlag] = useState(false);
  let [emailFlag, setEmailFlag] = useState(false);

  return (
    <div className="Login">
      <img src={logo} className="App-logo" alt="logo" />
      <LoginInput
        placeholder="email"
        onChange={(e) => {
          setInputEmail(e.target.value);
        }}
      ></LoginInput>
      {emailFlag ? (
        <WarningText>이메일 형식이 올바르지 않습니다</WarningText>
      ) : null}
      {confirmFlag ? (
        <GreenBtn
          onClick={() => {
            let regExp =
              /^[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*.[a-zA-Z]{2,3}$/i;
            if (inputEmail.match(regExp) != null) {
              setEmailFlag(false);
            } else {
              setEmailFlag(true);
            }
          }}
        >
          인증 메일 다시 보내기
        </GreenBtn>
      ) : null}
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
            let regExp =
              /^[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*.[a-zA-Z]{2,3}$/i;
            if (inputEmail.match(regExp) != null) {
              setConfirmFlag(!confirmFlag);
              setEmailFlag(false);
            } else {
              setEmailFlag(true);
            }
          }}
        >
          이메일 인증하기
        </GreenBtn>
      )}
      <LoginInput
        placeholder="비밀번호"
        type="password"
        onChange={(e) => {
          setInputPassword(e.target.value);
        }}
      ></LoginInput>
      <LoginInput
        placeholder="비밀번호 확인"
        type="password"
        onChange={(e) => {
          if (inputPassword != e.target.value && e.target.value != "") {
            setPasswordFlag(true);
          } else {
            setPasswordFlag(false);
          }
        }}
      ></LoginInput>
      {passwordFlag ? (
        <WarningText>비밀번호가 일치하지 않습니다. </WarningText>
      ) : null}
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
