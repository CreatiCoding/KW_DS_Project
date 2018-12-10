import React from "react";

import logo from "../logo.svg";
import { Link } from "react-router-dom";

import "../css/AppHeader.css";

const AppHeader = ({ match }) => {
  return (
    <header className="app-header">
      <div className="app-header-left">
        <img src={logo} className="app-logo" alt="logo" />
        <div className="app-header-title">CreatiCode</div>
      </div>
      <div className="app-header-right">
        <div className="app-header-block">
          <Link to="/">홈</Link>
        </div>
        <div className="app-header-block">
          <Link to="/problem/list">문제풀기</Link>
        </div>
        <div className="app-header-block">
          <Link to="/rank/list">순위</Link>
        </div>
        <div className="app-header-block">
          <Link to="/login">Login</Link>
        </div>
        <div className="app-header-block">
          <Link to="/join">Join</Link>
        </div>
      </div>
    </header>
  );
};
export default AppHeader;
