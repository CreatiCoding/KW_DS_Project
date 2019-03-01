import React from "react";
import ProblemWriteContainer from "../containers/ProblemWriteContainer";

//console.log(match.params.toon_info_idx);
const ProblemWriteRoute = ({ match }) => {
  return (
    <div>
      <ProblemWriteContainer />
    </div>
  );
};

export default ProblemWriteRoute;
