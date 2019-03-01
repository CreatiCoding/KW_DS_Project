import React from "react";

import logo from "../logo.svg";
import { Link } from "react-router-dom";

import "../css/AppHeader.css";

var hide = {
  display: "none"
};
var show = {
  display: "inline-block"
};
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
          <Link to="/problem/list">문제보기</Link>
        </div>
        <div className="app-header-block">
          <Link to="/answer/list/1">풀이보기</Link>
        </div>
        <div className="app-header-block">
          <Link to="/rank/list">순위</Link>
        </div>
        <div
          className="app-header-block"
          id="name"
          style={localStorage.getItem("name") == null ? hide : show}
        >
          <Link to="/profile">
            {localStorage.getItem("name") == null
              ? ""
              : localStorage.getItem("name")}
          </Link>
        </div>
        <div
          className="app-header-block"
          style={localStorage.getItem("name") == null ? show : hide}
        >
          <a href="/googleLogin">Login</a>
        </div>
        <div
          className="app-header-block"
          style={localStorage.getItem("name") == null ? show : hide}
        >
          <Link to="/join">Join</Link>
        </div>
        <div
          className="app-header-block"
          style={localStorage.getItem("name") == null ? hide : show}
        >
          <a
            href="#"
            onClick={() => {
              localStorage.clear();
            }}
          >
            Logout
          </a>
        </div>
      </div>
    </header>
  );
};
export default AppHeader;
