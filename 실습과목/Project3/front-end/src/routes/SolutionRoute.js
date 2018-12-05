import React from "react";

//console.log(match.params.toon_info_idx);
const SolutionRoute = ({ match }) => {
  let contents = {
    fontSize: "large"
  };
  return (
    <div style={contents}>
      Welcome to about SolutionRoute!!
      <br /> {match.params.solution_idx}
    </div>
  );
};

export default SolutionRoute;
