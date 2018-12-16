import React from "react";
import "../css/ProblemList.css";

const Problem = ({ idx, problem, enterProblem }) => {
  return (
    <tr className="problem-column problem-column-content" idx={problem.idx}>
      <td className="problem-column-default problem-column-idx">{idx}</td>
      <td
        className="problem-column-default problem-column-title"
        onClick={e => {
          enterProblem(problem.idx);
        }}
      >
        {problem.title}
      </td>
      <td className="problem-column-default problem-column-difficulty">
        {problem.difficulty}
      </td>
      <td className="problem-column-default problem-column-accepted">
        {problem.accepted} / {problem.submit}
      </td>
      <td className="problem-column-default problem-column-writer">
        {problem.writer}
      </td>
      <td className="problem-column-default problem-column-share">
        {problem.share}
      </td>
    </tr>
  );
};
const mapToProblem = (list, enterProblem) => {
  return list.map((e, i, a) => (
    <Problem enterProblem={enterProblem} problem={e} idx={i + 1} key={i} />
  ));
};
const ProblemList = ({ enterProblem, list }) => {
  list = [
    {
      idx: 1,
      title: "알고리즘 쉬운 문제",
      difficulty: "easy",
      accepted: 101,
      submit: 123,
      writer: "creco",
      share: "/problem/1"
    },
    {
      idx: 2,
      title: "알고리즘 약간 어려운 문제",
      difficulty: "medium",
      accepted: 80,
      submit: 120,
      writer: "jimmy",
      share: "/problem/2"
    },
    {
      idx: 3,
      title: "알고리즘 엄청 어려운 문제",
      difficulty: "hard",
      accepted: 33,
      submit: 109,
      writer: "creco",
      share: "/problem/3"
    }
  ];
  return (
    <table className="problem-table">
      <thead>
        <tr className="problem-column problem-column-header">
          <td className="problem-column-default problem-column-idx">No</td>
          <td className="problem-column-default problem-column-title">제 목</td>
          <td className="problem-column-default problem-column-difficulty">
            난 이 도
          </td>
          <td className="problem-column-default problem-column-accepted">
            성 공
          </td>
          <td className="problem-column-default problem-column-writer">
            저 자
          </td>
          <td className="problem-column-default problem-column-share">공 유</td>
        </tr>
      </thead>
      <tbody>{mapToProblem(list, enterProblem)}</tbody>
    </table>
  );
};
export default ProblemList;
