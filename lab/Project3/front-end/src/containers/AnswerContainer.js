import React, { Component } from "react";
import { withRouter } from "react-router-dom";
import "../css/AnswerContainer.css";
import Answer from "../components/Answer";

//console.log(match.params.toon_info_idx);

class AnswerContainer extends Component {
  constructor(props) {
    super(props);
  }
  render() {
    return (
      <div className="answer-container">
        <Answer />
      </div>
    );
  }
}

export default withRouter(AnswerContainer);
