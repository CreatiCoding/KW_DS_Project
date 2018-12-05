import React, { Component } from "react";
import { BrowserRouter as Router, Route } from "react-router-dom";

import QuestionRoute from "./routes/QuestionRoute";
import QuestionsRoute from "./routes/QuestionsRoute";
import QuestionWriteRoute from "./routes/QuestionWriteRoute";
import SolutionRoute from "./routes/SolutionRoute";
import SolutionsRoute from "./routes/SolutionsRoute";
import SolutionWriteRoute from "./routes/SolutionWriteRoute";
import LoginRoute from "./routes/LoginRoute";
import JoinRoute from "./routes/JoinRoute";

import logo from "./logo.svg";
import "./App.css";
import { connect } from "react-redux";
import * as actions from "./actions";
import AppTitle from "./AppTitle";
import { Link } from "react-router-dom";

class App extends Component {
  render() {
    return (
      <div className="App">
        <header className="App-header">
          <img src={logo} className="App-logo" alt="logo" />
          <AppTitle message={this.props.message} />
        </header>
        <Router>
          <div>
            <div>
              <Link to="/">홈으로</Link>
              <br />
              <Link to="/post">게시판</Link>
              <br />
              <Link to="/post/test">게시판테스트</Link>
              <br />
              <Link to="/about">자세히</Link>
              <br />
            </div>

            <div className="app">
              <Route exact path="/" component={QuestionsRoute} />
              <Route exact path="/home" component={QuestionsRoute} />
              <Route exact path="/questions" component={QuestionsRoute} />
              <Route
                exact
                path="/question/:question_idx"
                component={QuestionRoute}
              />
              <Route
                exact
                path="/questionWrite"
                component={QuestionWriteRoute}
              />
              <Route
                exact
                path="/solutions/:question_idx"
                component={SolutionsRoute}
              />
              <Route
                exact
                path="/solution/:solution_idx"
                component={SolutionRoute}
              />
              <Route
                exact
                path="/solutionWrite/:question_idx"
                component={SolutionWriteRoute}
              />
              <Route exact path="/join" component={JoinRoute} />
              <Route exact path="/login" component={LoginRoute} />
            </div>
          </div>
        </Router>
      </div>
    );
  }
}

const mapStateToPrpos = state => {
  return {
    message: state.messageReducer.message
  };
};

const mapDispatchToProps = dispatch => {
  return {
    handleChaneMessage: message => {
      dispatch(actions.changeMessage(message));
    }
  };
};
export default connect(
  mapStateToPrpos,
  mapDispatchToProps
)(App);
