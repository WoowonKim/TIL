import "../App.css";
import { LoginInput, GreenBtn } from "../components/styled";
import "../css/Login.css";
import { Link } from "react-router-dom";
import { useState } from "react";

const Forgot = () => {
  let [confirm, setConfirm] = useState(false);
  let [confirmFlag, setConfirmFlag] = useState(false);
  return (
    <div className="Forgot">
      <h2>비밀 번호 재설정</h2>
      {confirm ? (
        <div className="password">
          <LoginInput placeholder="비밀번호"></LoginInput>
          <LoginInput placeholder="비밀번호 확인"></LoginInput>
          <Link to="/">
            <GreenBtn style={{ width: "150px" }}>비밀번호 변경</GreenBtn>
          </Link>
        </div>
      ) : (
        <div className="email">
          <LoginInput placeholder="email"></LoginInput>
          {confirmFlag ? <GreenBtn>인증 메일 다시 보내기</GreenBtn> : null}
          {confirmFlag ? (
            <div className="confirmForm">
              <LoginInput
                style={{ width: "205px", marginRight: "10px" }}
                placeholder="인증 번호"
              ></LoginInput>
              <GreenBtn
                style={{ width: "100px", marginLeft: "10px" }}
                onClick={() => {
                  setConfirm(true);
                }}
              >
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
        </div>
      )}
    </div>
  );
};

export default Forgot;
