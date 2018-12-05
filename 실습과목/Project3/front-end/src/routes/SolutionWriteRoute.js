import React from "react";

//console.log(match.params.toon_info_idx);
const SolutionWriteRoute = ({ match }) => {
  let contents = {
    fontSize: "large"
  };
  return (
    <div style={contents}>
      Welcome to about SolutionWriteRoute!!
      <br /> {match.params.question_idx}
    </div>
  );
};

export default SolutionWriteRoute;
