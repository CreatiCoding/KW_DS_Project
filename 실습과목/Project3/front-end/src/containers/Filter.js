import { withRouter } from "react-router-dom";

import { Component } from "react";

const isNormalInteger = str => {
  const n = Math.floor(Number(str));
  return n !== Infinity && String(n) === str && n >= 0;
};

class Filter extends Component {
  constructor(props) {
    super(props);
    window.component = this;
    const allowPaths = [
      "/",
      "/home",
      "/problem/list",
      "/problem/write",
      //"/problem/",
      //"/answer/list/",
      "/answer/",
      "/join",
      "/login",
      "/rank/list"
    ];
    const currentPath = window.location.pathname;
    for (let i = 0; i < allowPaths.length; i++) {
      if (currentPath === allowPaths[i]) {
        return;
      }
    }

    if (currentPath.indexOf("/problem/") === 0) {
      if (!isNormalInteger(currentPath.substr(9))) {
        throw new Error("404 Error about path: " + currentPath);
      }
    } else if (currentPath.indexOf("/answer/list/") === 0) {
      if (!isNormalInteger(currentPath.substr(13))) {
        throw new Error("404 Error about path: " + currentPath);
      }
    } else {
      throw new Error("404 Error about path: " + currentPath);
    }
    // this.props.history.push("/home");
  }

  render() {
    return null;
  }
}

export default withRouter(Filter);
