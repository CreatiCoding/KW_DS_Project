import React from "react";
import "../css/AppWrapper.css";
import { Route, Link } from "react-router-dom";
import HomeRoute from "../routes/HomeRoute";
import QuestionRoute from "../routes/QuestionRoute";
import QuestionsRoute from "../routes/QuestionsRoute";
import QuestionWriteRoute from "../routes/QuestionWriteRoute";
import SolutionRoute from "../routes/SolutionRoute";
import SolutionsRoute from "../routes/SolutionsRoute";
import SolutionWriteRoute from "../routes/SolutionWriteRoute";
import LoginRoute from "../routes/LoginRoute";
import JoinRoute from "../routes/JoinRoute";
import "../css/AppWrapper.css";

const AppWrapper = ({ match }) => {
  return (
    <div className="app-wrawpper">
      <Route exact path="/" component={HomeRoute} />
      <Route exact path="/home" component={QuestionsRoute} />
      <Route exact path="/questions" component={QuestionsRoute} />
      <Route exact path="/question/:question_idx" component={QuestionRoute} />
      <Route exact path="/questionWrite" component={QuestionWriteRoute} />
      <Route exact path="/solutions/:question_idx" component={SolutionsRoute} />
      <Route exact path="/solution/:solution_idx" component={SolutionRoute} />
      <Route
        exact
        path="/solutionWrite/:question_idx"
        component={SolutionWriteRoute}
      />
      <Route exact path="/join" component={JoinRoute} />
      <Route exact path="/login" component={LoginRoute} />
    </div>
  );
};

export default AppWrapper;
