import logo from ".././logo.png";
import "../css/Login.css";
import "../App.css";
import { LoginInput, GreenBtn } from "../components/styled.jsx";
import { useNavigate } from "react-router-dom";
const UserName = () => {
  let navigate = useNavigate();
  return (
    <div className="Login">
      <img src={logo} className="App-logo" alt="logo" />
      <h1 style={{ marginBottom: "0px" }}>가입을 축하드립니다!</h1>
      <h2 style={{ textAlign: "center" }}>
        Eco2에서 사용할 개성있는
        <br />
        이름을 정해주세요!
      </h2>
      <LoginInput
        placeholder="최대 8글자"
        style={{ width: "200px" }}
      ></LoginInput>
      <GreenBtn
        onClick={() => {
          navigate("/");
        }}
        style={{ width: "150px" }}
      >
        시작하기
      </GreenBtn>
    </div>
  );
};

export default UserName;
