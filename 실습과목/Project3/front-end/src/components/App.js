import React from "react";
import { BrowserRouter as Router } from "react-router-dom";
import "../App.css";
import AppHeader from "./AppHeader";
import AppWrapper from "./AppWapper";
import AppFooter from "./AppFooter";
import Filter from "../containers/Filter";

const App = () => {
  return (
    <Router>
      <div className="App">
        <Filter />
        <AppHeader />
        <AppWrapper />
        <AppFooter />
      </div>
    </Router>
  );
};

export default App;
