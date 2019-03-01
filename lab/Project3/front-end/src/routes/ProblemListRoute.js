import React from "react";

//console.log(match.params.toon_info_idx);
import ProblemListContainer from "../containers/ProblemListContainer";
const ProblemListRoute = ({ match }) => {
  return (
    <div>
      <br />
      <div>
        <ProblemListContainer />
      </div>
    </div>
  );
};

export default ProblemListRoute;
