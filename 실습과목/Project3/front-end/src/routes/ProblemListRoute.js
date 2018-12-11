import React from "react";

//console.log(match.params.toon_info_idx);
import ProblemListContainer from "../containers/ProblemListContainer";
const ProblemListRoute = ({ match }) => {
  let contents = {
    fontSize: "30px"
  };
  return (
    <div>
      <br />
      <div style={contents}> 문 제 리 스 트</div>
      <br />
      <div>
        <ProblemListContainer />
      </div>
    </div>
  );
};

export default ProblemListRoute;
