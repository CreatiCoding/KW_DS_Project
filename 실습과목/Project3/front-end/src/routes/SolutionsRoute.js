import React from "react";

//console.log(match.params.toon_info_idx);
const SolutionsRoute = ({ match }) => {
  let contents = {
    fontSize: "large"
  };
  return (
    <div style={contents}>
      Welcome to about SolutionsRoute!!
      <br /> {match.params.question_idx}
    </div>
  );
};

export default SolutionsRoute;
