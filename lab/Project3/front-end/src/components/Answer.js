import React from "react";
import "../css/Answer.css";

const run = event => {
  console.log(11);
  document.querySelector("#console").value =
    document.querySelector("#console").value + "gcc ./test.c\n";
  document.querySelector("#console").value =
    document.querySelector("#console").value + " > ./a.out\n";
  document.querySelector("#console").value =
    document.querySelector("#console").value + "success(0)...\n";
};
const c_code =
  '#include <stdio.h>\nint main(){\n\tprintf("hello world!\\n");\n\treturn 0;\n}\n';
const console_pwd = " > ";
const Answer = ({}) => {
  return (
    <div className="answer-wrapper">
      <br />
      <div className="answer-header">
        <div className="answer-header-inner">
          <div>
            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;코드
            작성하기&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
          </div>
          <button onClick={run}>실행</button>&nbsp;&nbsp;&nbsp;
          <button>제출</button>
        </div>
      </div>
      <br />
      <div>
        <textarea
          onKeyDown={event => {
            if (event.keyCode === 9) {
              event.preventDefault();
              var v = event.target.value;
              var s = event.target.selectionStart;
              var e = event.target.selectionEnd;
              event.target.value = v.substring(0, s) + "\t" + v.substring(e);
              event.target.selectionStart = event.target.selectionEnd = s + 1;
              return false;
            }
          }}
          className="code-area"
          defaultValue={c_code}
        />
      </div>
      <div>
        <textarea
          id="console"
          readOnly
          className="console-area"
          defaultValue={console_pwd}
        />
      </div>
    </div>
  );
};
export default Answer;
