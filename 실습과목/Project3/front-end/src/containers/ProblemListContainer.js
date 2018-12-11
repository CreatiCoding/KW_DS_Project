import React, { Component } from "react";
import "../css/ProblemListContainer.css";
import ProblemList from "../components/ProblemList";
//console.log(match.params.toon_info_idx);

class ProblemListContainer extends Component {
  constructor(props) {
    super(props);
  }
  render() {
    return (
      <div className="problem-container">
        <ProblemList />
      </div>
    );
  }
}

export default ProblemListContainer;
