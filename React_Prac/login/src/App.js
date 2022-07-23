import "./App.css";
import { Routes, Route } from "react-router-dom";
import Login from "./routes/Login";
import Regist from "./routes/Regist";
import UserName from "./routes/UserName";
import Forgot from "./routes/Forgot";
function App() {
  return (
    <div className="App">
      <Routes>
        <Route path="/" element={<Login />}></Route>
        <Route path="/regist" element={<Regist />}></Route>
        <Route path="/regist/username" element={<UserName />}></Route>
        <Route path="/forgot" element={<Forgot />}></Route>
      </Routes>
    </div>
  );
}

export default App;
