import React from "react";
import "../css/ProblemWrite.css";

const form = {
  float: "left",
  width: "100%",
  textAlign: "initial",
  fontSize: "20px"
};
const title = {
  fontSize: "30px"
};
const input = {
  fontSize: "20px",
  width: "100%"
};
const select = {
  fontSize: "20px"
};
const textarea = {
  width: "100%",
  overflow: "scroll",
  margin: "auto",
  resize: "none",
  height: "460px",
  fontSize: "30px"
};
const button = {
  float: "right",
  fontSize: "20px"
};
const ProblemWrite = ({}) => {
  return (
    <div>
      <br />
      <div style={title}>문제 작성</div>
      <br />
      <form method="post" actions="/problem/write">
        <div style={form}>
          제목&nbsp;&nbsp;&nbsp;&nbsp;난이도&nbsp;&nbsp;&nbsp;&nbsp;
          <select style={select}>
            <option>easy</option>
            <option>medium</option>
            <option>hard</option>
          </select>
          <button style={button}>작성</button>
          <br />
          <br />
          <input style={input} type="text" name="title" /> <br />
          <br />
          내용
          <br />
          <textarea style={textarea} />
        </div>
      </form>
    </div>
  );
};
export default ProblemWrite;
