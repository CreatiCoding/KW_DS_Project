import React, { Component } from "react";
import "../css/ProblemListContainer.css";
import ProblemList from "../components/ProblemList";
import { withRouter } from "react-router-dom";

//console.log(match.params.toon_info_idx);

const enterProblem = (r, idx) => {
  r.history.push("/problem/" + idx);
};
class ProblemListContainer extends Component {
  constructor(props) {
    super(props);
  }
  render() {
    return (
      <div className="problem-list-container">
        <ProblemList
          enterProblem={idx => {
            enterProblem(this.props, idx);
          }}
        />
      </div>
    );
  }
}

export default withRouter(ProblemListContainer);
