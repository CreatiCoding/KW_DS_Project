import React from "react";
import { BrowserRouter as Router } from "react-router-dom";
import "../App.css";
import AppHeader from "./AppHeader";
import AppWrapper from "./AppWapper";

const App = () => {
  return (
    <Router>
      <div className="App">
        <AppHeader />
        <AppWrapper />
      </div>
    </Router>
  );
};

export default App;
