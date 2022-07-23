import "./App.css";
import { Routes, Route } from "react-router-dom";
import Login from "./routes/Login";
function App() {
  return (
    <div className="App">
      <Routes>
        <Route path="/" element={<Login />}></Route>
      </Routes>
    </div>
  );
}

export default App;
