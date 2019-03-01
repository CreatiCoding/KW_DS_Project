import React, { Component } from "react";
import "../css/ProblemWriteContainer.css";
import ProblemWrite from "../components/ProblemWrite";
import { withRouter } from "react-router-dom";

class ProblemWriteContainer extends Component {
  constructor(props) {
    super(props);
  }
  render() {
    return (
      <div className="problem-write">
        <ProblemWrite />
      </div>
    );
  }
}

export default withRouter(ProblemWriteContainer);
