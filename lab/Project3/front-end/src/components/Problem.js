import React from "react";
import "../css/Problem.css";

const Problem = ({}) => {
  var problem = {
    idx: 1,
    title: "알고리즘 쉬운 문제",
    difficulty: "easy",
    accepted: 101,
    submit: 123,
    like: 111,
    hate: 44,
    writer: "creco",
    share: "/problem/1",
    contents: "contents"
  };
  let problemHeader = {
    display: "inline"
  };
  return (
    <div className="problem-wrapper">
      <div className="problem-title">{problem.title}</div>
      <div className="problem-header">
        <div className="problem-left">
          <div className="header-text">from. {problem.writer}</div>
        </div>
        <div className="clear" />
        <div className="problem-right">
          <div className="header-text problem-right-difficulty">
            {problem.difficulty}
          </div>
          <div className="header-text problem-right-accepted">
            {parseInt((problem.accepted / problem.submit) * 10000) / 100}%
          </div>
          <div className="header-text problem-right-like">{problem.like}</div>
          <div className="header-text problem-right-hate">{problem.hate}</div>
          <div className="header-sign problem-right-wish">❤️</div>
          <div className="header-sign problem-right-share">📤</div>
        </div>
      </div>
      <br />
      <br />
      <div className="problem-contents">
        <div className="problem-contents-inner">{problem.contents}</div>
      </div>
    </div>
  );
};
export default Problem;
