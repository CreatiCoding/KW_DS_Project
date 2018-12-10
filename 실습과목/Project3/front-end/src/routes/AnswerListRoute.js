import React from "react";

//console.log(match.params.toon_info_idx);
const AnswerListRoute = ({ match }) => {
  let contents = {
    fontSize: "large"
  };
  return (
    <div style={contents}>
      Welcome to about AnswerListRoute!!
      <br /> {match.params.idx}
    </div>
  );
};

export default AnswerListRoute;
