import React from "react";

const ProblemRoute = ({ match }) => {
  let contents = {
    fontSize: "large"
  };
  return (
    <div style={contents}>
      Welcome to about ProblemRoute!! <br /> {match.params.idx}
    </div>
  );
};

export default ProblemRoute;
