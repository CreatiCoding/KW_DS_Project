import React from "react";
import "../css/ProblemList.css";

const Problem = ({ idx, problem }) => {
  return (
    <tr className="problem-column problem-column-content">
      <td className="problem-column-default problem-column-idx">{idx}</td>
      <td className="problem-column-default problem-column-title">
        {problem.title}
      </td>
      <td className="problem-column-default problem-column-difficulty">
        {problem.difficulty}
      </td>
      <td className="problem-column-default problem-column-accepted">
        {problem.accepted}
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
const mapToProblem = list => {
  return list.map((e, i, a) => <Problem problem={e} idx={i + 1} />);
};
const ProblemList = ({ list }) => {
  list = [
    {
      title: "제목1",
      difficulty: "easy",
      accepted: 123,
      writer: "creco",
      share: "test.com"
    },
    {
      title: "제목2",
      difficulty: "medium",
      accepted: 333,
      writer: "jimmy",
      share: "test2.com"
    }
  ];
  return (
    <table className="problem-table">
      <tr className="problem-column problem-column-header">
        <td className="problem-column-default problem-column-idx">No</td>
        <td className="problem-column-default problem-column-title">제 목</td>
        <td className="problem-column-default problem-column-difficulty">
          난 이 도
        </td>
        <td className="problem-column-default problem-column-accepted">
          성 공
        </td>
        <td className="problem-column-default problem-column-writer">저 자</td>
        <td className="problem-column-default problem-column-share">공 유</td>
      </tr>
      {mapToProblem(list)}
    </table>
  );
};
export default ProblemList;
