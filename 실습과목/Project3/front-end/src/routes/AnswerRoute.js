import React from "react";

const AnswerRoute = ({ match }) => {
  let contents = {
    fontSize: "large"
  };
  return (
    <div style={contents}>
      Welcome to about AnswerRoute!! <br /> {match.params.idx}
    </div>
  );
};

export default AnswerRoute;
