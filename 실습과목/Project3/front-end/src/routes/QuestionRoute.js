import React from "react";

const QuestionRoute = ({ match }) => {
  let contents = {
    fontSize: "large"
  };
  return (
    <div style={contents}>
      Welcome to about QuestionRoute!! <br /> {match.params.question_idx}
    </div>
  );
};

export default QuestionRoute;
