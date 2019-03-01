import React, { Component } from "react";
import "../css/ProblemContainer.css";
import Problem from "../components/Problem";
import { withRouter } from "react-router-dom";

//console.log(match.params.toon_info_idx);
class ProblemContainer extends Component {
  constructor(props) {
    super(props);
  }
  render() {
    return (
      <div className="problem-container">
        <Problem />
      </div>
    );
  }
}

export default withRouter(ProblemContainer);
