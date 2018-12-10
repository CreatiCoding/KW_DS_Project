import React from "react";
import "../css/AppFooter.css";

const AppFooter = () => {
  return (
    <footer className="app-footer">
      <p>
        현 사이트의 저작권은 광운대학교 2018년 소프트웨어프로젝트1 교수님 및
        연구실, 학생(정석호, 이진수) 에게 있습니다.{" "}
      </p>

      <p className="footer-copyright">
        <a href="https://github.com/CreatiCoding/KW_DS_Project/tree/master/%EC%8B%A4%EC%8A%B5%EA%B3%BC%EB%AA%A9/Project3">
          CreatiCode
        </a>{" "}
        From @Copyright{" "}
        <a href="https://github.com/CreatiCoding">CreatiCoding</a> and{" "}
        <a href="https://github.com/jimmy3663">jimmy3663</a>
      </p>
    </footer>
  );
};
export default AppFooter;
