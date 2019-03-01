import React, { Component } from "react";
import "../css/ProblemListContainer.css";
import ProblemList from "../components/ProblemList";
import { withRouter, Link } from "react-router-dom";

//console.log(match.params.toon_info_idx);

const enterProblemWrite = r => {
  r.history.push("/problem/write");
};
const enterProblem = (r, idx) => {
  r.history.push("/problem/" + idx);
};
const title = {
  fontSize: "30px"
};
const button = {
  fontSize: "20px",
  color: "black",
  textDecoration: "none"
};
class ProblemListContainer extends Component {
  constructor(props) {
    super(props);
  }
  render() {
    return (
      <div className="problem-list-container">
        <div>
          <div style={title}>
            &nbsp;&nbsp;&nbsp;&nbsp;문제
            리스트&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
            &nbsp;&nbsp;&nbsp;&nbsp;
            <Link style={button} to="/problem/write">
              글 작성
            </Link>
          </div>
        </div>
        <ProblemList
          enterProblem={idx => {
            enterProblem(this.props, idx);
          }}
          enterProblemWrite={() => {
            enterProblemWrite(this.props);
          }}
        />
      </div>
    );
  }
}

export default withRouter(ProblemListContainer);
