import React from "react";
import "../css/Problem.css";

const Problem = ({}) => {
  var problem = {
    idx: 4,
    title: "안녕 세상아!",
    difficulty: "easy",
    accepted: 0,
    submit: 0,
    like: 0,
    hate: 0,
    writer: "SeokHo Jeong",
    share: "/problem/4",
    contents:
      "코딩 테스트 사이트에서 첫 코드를 작성하여 코딩의 세계로 빠져보세요!\n\ninput: (none)\n\noutput:\nhello world!\n"
  };
  return (
    <div className="problem-wrapper">
      <div className="problem-title">
        <div className="problem-title-left">{problem.title}</div>
        <div className="problem-title-right">
          <button>해설</button>
        </div>
      </div>
      <div className="problem-header">
        <div className="problem-left">
          <div className="header-text">작성자: {problem.writer}</div>
        </div>
        <div className="clear" />
        <div className="problem-right">
          <div className="header-text problem-right-difficulty">
            {problem.difficulty}
          </div>
          <div className="header-text problem-right-accepted">
            {problem.submit == 0
              ? 0
              : parseInt((problem.accepted / problem.submit) * 10000) / 100}
            %
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
        <pre className="problem-contents-inner">{problem.contents}</pre>
      </div>
    </div>
  );
};
export default Problem;
