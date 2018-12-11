import React from "react";
import "../css/AppWrapper.css";
import { Route } from "react-router-dom";

import HomeRoute from "../routes/HomeRoute";
import ProblemListRoute from "../routes/ProblemListRoute";
import ProblemRoute from "../routes/ProblemRoute";
import ProblemWriteRoute from "../routes/ProblemWriteRoute";
import AnswerRoute from "../routes/AnswerRoute";
import AnswerListRoute from "../routes/AnswerListRoute";
import LoginRoute from "../routes/LoginRoute";
import JoinRoute from "../routes/JoinRoute";

import "../css/AppWrapper.css";

const AppWrapper = () => {
  return (
    <div className="app-wrawpper">
      <div className="app-wrawpper-inner">
        <Route exact path="/" component={HomeRoute} />
        <Route exact path="/home" component={HomeRoute} />

        <Route exact path="/problem/list" component={ProblemListRoute} />
        <Route exact path="/problem/write" component={ProblemWriteRoute} />
        <Route exact path="/problem/:idx(\d+)" component={ProblemRoute} />

        <Route exact path="/answer/list/:idx" component={AnswerListRoute} />
        <Route exact path="/answer/:idx(\d+)" component={AnswerRoute} />

        <Route exact path="/join" component={JoinRoute} />
        <Route exact path="/login" component={LoginRoute} />
      </div>
    </div>
  );
};

export default AppWrapper;
