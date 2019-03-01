import React from "react";

import ProblemContainer from "../containers/ProblemContainer";
import AnswerContainer from "../containers/AnswerContainer";

const ProblemRoute = ({ match }) => {
  return (
    <div>
      <br />
      <ProblemContainer />
      <AnswerContainer />
    </div>
  );
};

export default ProblemRoute;
