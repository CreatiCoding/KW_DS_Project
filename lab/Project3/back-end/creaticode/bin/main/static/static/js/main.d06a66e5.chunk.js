(window.webpackJsonp=window.webpackJsonp||[]).push([[0],{20:function(e,t,a){},22:function(e,t,a){e.exports=a.p+"static/media/logo.26ef1cbc.svg"},29:function(e,t,a){e.exports=a(60)},34:function(e,t,a){},36:function(e,t,a){},38:function(e,t,a){},43:function(e,t,a){},45:function(e,t,a){},48:function(e,t,a){},50:function(e,t,a){},52:function(e,t,a){},54:function(e,t,a){},56:function(e,t,a){},60:function(e,t,a){"use strict";a.r(t);var n=a(0),l=a.n(n),r=a(21),c=a.n(r),o=(a(34),a(63)),m=(a(36),a(22)),i=a.n(m),s=a(61),u=(a(38),{display:"none"}),d={display:"inline-block"},p=function(e){e.match;return l.a.createElement("header",{className:"app-header"},l.a.createElement("div",{className:"app-header-left"},l.a.createElement("img",{src:i.a,className:"app-logo",alt:"logo"}),l.a.createElement("div",{className:"app-header-title"},"CreatiCode")),l.a.createElement("div",{className:"app-header-right"},l.a.createElement("div",{className:"app-header-block"},l.a.createElement(s.a,{to:"/"},"\ud648")),l.a.createElement("div",{className:"app-header-block"},l.a.createElement(s.a,{to:"/problem/list"},"\ubb38\uc81c\ubcf4\uae30")),l.a.createElement("div",{className:"app-header-block"},l.a.createElement(s.a,{to:"/answer/list/1"},"\ud480\uc774\ubcf4\uae30")),l.a.createElement("div",{className:"app-header-block"},l.a.createElement(s.a,{to:"/rank/list"},"\uc21c\uc704")),l.a.createElement("div",{className:"app-header-block",id:"name",style:null==localStorage.getItem("name")?u:d},l.a.createElement(s.a,{to:"/profile"},null==localStorage.getItem("name")?"":localStorage.getItem("name"))),l.a.createElement("div",{className:"app-header-block",style:null==localStorage.getItem("name")?d:u},l.a.createElement("a",{href:"/googleLogin"},"Login")),l.a.createElement("div",{className:"app-header-block",style:null==localStorage.getItem("name")?d:u},l.a.createElement(s.a,{to:"/join"},"Join")),l.a.createElement("div",{className:"app-header-block",style:null==localStorage.getItem("name")?u:d},l.a.createElement("a",{href:"#",onClick:function(){localStorage.clear()}},"Logout"))))},b=(a(20),a(62)),E=function(e){e.match;return l.a.createElement("div",{style:{fontSize:"large"}},"Welcome to home page!!")},h=a(6),f=a(7),v=a(5),g=a(8),N=a(9),w=(a(43),a(45),function(e){var t=e.idx,a=e.problem,n=e.enterProblem;return l.a.createElement("tr",{className:"problem-column problem-column-content",idx:a.idx},l.a.createElement("td",{className:"problem-column-default problem-column-idx"},t),l.a.createElement("td",{className:"problem-column-default problem-column-title",onClick:function(e){n(a.idx)}},a.title),l.a.createElement("td",{className:"problem-column-default problem-column-difficulty"},a.difficulty),l.a.createElement("td",{className:"problem-column-default problem-column-accepted"},a.accepted," / ",a.submit),l.a.createElement("td",{className:"problem-column-default problem-column-writer"},a.writer),l.a.createElement("td",{className:"problem-column-default problem-column-share"},a.share))}),j=function(e){var t=e.enterProblem,a=e.list;return a=[{idx:1,title:"\uc54c\uace0\ub9ac\uc998 \uc26c\uc6b4 \ubb38\uc81c",difficulty:"easy",accepted:101,submit:123,writer:"creco",share:"/problem/1"},{idx:2,title:"\uc54c\uace0\ub9ac\uc998 \uc57d\uac04 \uc5b4\ub824\uc6b4 \ubb38\uc81c",difficulty:"medium",accepted:80,submit:120,writer:"jimmy",share:"/problem/2"},{idx:3,title:"\uc54c\uace0\ub9ac\uc998 \uc5c4\uccad \uc5b4\ub824\uc6b4 \ubb38\uc81c",difficulty:"hard",accepted:33,submit:109,writer:"creco",share:"/problem/3"}],l.a.createElement("table",{className:"problem-table"},l.a.createElement("thead",null,l.a.createElement("tr",{className:"problem-column problem-column-header"},l.a.createElement("td",{className:"problem-column-default problem-column-idx"},"No"),l.a.createElement("td",{className:"problem-column-default problem-column-title"},"\uc81c \ubaa9"),l.a.createElement("td",{className:"problem-column-default problem-column-difficulty"},"\ub09c \uc774 \ub3c4"),l.a.createElement("td",{className:"problem-column-default problem-column-accepted"},"\uc131 \uacf5"),l.a.createElement("td",{className:"problem-column-default problem-column-writer"},"\uc800 \uc790"),l.a.createElement("td",{className:"problem-column-default problem-column-share"},"\uacf5 \uc720"))),l.a.createElement("tbody",null,function(e,t){return e.map(function(e,a,n){return l.a.createElement(w,{enterProblem:t,problem:e,idx:a+1,key:a})})}(a,t)))},y=a(64),x=function(e){function t(e){return Object(h.a)(this,t),Object(v.a)(this,Object(g.a)(t).call(this,e))}return Object(N.a)(t,e),Object(f.a)(t,[{key:"render",value:function(){var e=this;return l.a.createElement("div",{className:"problem-list-container"},l.a.createElement(j,{enterProblem:function(t){!function(e,t){e.history.push("/problem/"+t)}(e.props,t)}}))}}]),t}(n.Component),O=Object(y.a)(x),k=function(e){e.match;return l.a.createElement("div",null,l.a.createElement("br",null),l.a.createElement("div",null,l.a.createElement(O,null)))},C=(a(48),a(13)),S=(a(50),function(e){Object(C.a)(e);var t="\uc54c\uace0\ub9ac\uc998 \uc26c\uc6b4 \ubb38\uc81c",a="easy",n=101,r=123,c=111,o=44,m="creco",i="contents";return l.a.createElement("div",{className:"problem-wrapper"},l.a.createElement("div",{className:"problem-title"},l.a.createElement("div",{className:"problem-title-left"},t),l.a.createElement("div",{className:"problem-title-right"},l.a.createElement("button",null,"\ud574\uc124"))),l.a.createElement("div",{className:"problem-header"},l.a.createElement("div",{className:"problem-left"},l.a.createElement("div",{className:"header-text"},"\uc791\uc131\uc790: ",m)),l.a.createElement("div",{className:"clear"}),l.a.createElement("div",{className:"problem-right"},l.a.createElement("div",{className:"header-text problem-right-difficulty"},a),l.a.createElement("div",{className:"header-text problem-right-accepted"},parseInt(n/r*1e4)/100,"%"),l.a.createElement("div",{className:"header-text problem-right-like"},c),l.a.createElement("div",{className:"header-text problem-right-hate"},o),l.a.createElement("div",{className:"header-sign problem-right-wish"},"\u2764\ufe0f"),l.a.createElement("div",{className:"header-sign problem-right-share"},"\ud83d\udce4"))),l.a.createElement("br",null),l.a.createElement("br",null),l.a.createElement("div",{className:"problem-contents"},l.a.createElement("div",{className:"problem-contents-inner"},i)))}),A=function(e){function t(e){return Object(h.a)(this,t),Object(v.a)(this,Object(g.a)(t).call(this,e))}return Object(N.a)(t,e),Object(f.a)(t,[{key:"render",value:function(){return l.a.createElement("div",{className:"problem-container"},l.a.createElement(S,null))}}]),t}(n.Component),W=Object(y.a)(A),I=(a(52),a(54),function(e){return Object(C.a)(e),l.a.createElement("div",{className:"answer-wrapper"},l.a.createElement("br",null),l.a.createElement("div",{className:"answer-header"},l.a.createElement("div",{className:"answer-header-inner"},l.a.createElement("div",null,"\xa0\xa0\xa0\xa0\xa0\xa0\ucf54\ub4dc \uc791\uc131\ud558\uae30\xa0\xa0\xa0\xa0\xa0\xa0"),l.a.createElement("button",null,"\uc2e4\ud589"),"\xa0\xa0\xa0",l.a.createElement("button",null,"\uc81c\ucd9c"))),l.a.createElement("br",null),l.a.createElement("div",null,l.a.createElement("textarea",{onKeyDown:function(e){if(9===e.keyCode){e.preventDefault();var t=e.target.value,a=e.target.selectionStart,n=e.target.selectionEnd;return e.target.value=t.substring(0,a)+"\t"+t.substring(n),e.target.selectionStart=e.target.selectionEnd=a+1,!1}},className:"code-area",defaultValue:'#include <stdio.h>\nint main(){\n\tprintf("hello world!\\n");\n\treturn 0;\n}\n'})),l.a.createElement("div",null,l.a.createElement("textarea",{readOnly:!0,className:"console-area",defaultValue:" >"})))}),B=function(e){function t(e){return Object(h.a)(this,t),Object(v.a)(this,Object(g.a)(t).call(this,e))}return Object(N.a)(t,e),Object(f.a)(t,[{key:"render",value:function(){return l.a.createElement("div",{className:"answer-container"},l.a.createElement(I,null))}}]),t}(n.Component),P=Object(y.a)(B),z=function(e){e.match;return l.a.createElement("div",null,l.a.createElement("br",null),l.a.createElement(W,null),l.a.createElement(P,null))},R=function(e){e.match;return l.a.createElement("div",{style:{fontSize:"large"}},"Welcome to about ProblemWriteRoute!!")},L=function(e){var t=e.match;return l.a.createElement("div",{style:{fontSize:"large"}},"Welcome to about AnswerRoute!! ",l.a.createElement("br",null)," ",t.params.idx)},J=function(e){var t=e.match;return l.a.createElement("div",{style:{fontSize:"large"}},"Welcome to about AnswerListRoute!!",l.a.createElement("br",null)," ",t.params.idx)},D=function(e){e.match;return l.a.createElement("div",{style:{fontSize:"large"}},"Welcome to about LoginRoute!!")},_=function(e){e.match;return l.a.createElement("div",{style:{fontSize:"large"}},"Welcome to about JoinRoute!!")},G=function(){return l.a.createElement("div",{className:"app-wrapper"},l.a.createElement("div",{className:"/problem/list"!=window.location.pathname&&0==window.location.pathname.indexOf("/problem/")?"app-wrapper-inner-problem":"app-wrapper-inner"},l.a.createElement(b.a,{exact:!0,path:"/",component:E}),l.a.createElement(b.a,{exact:!0,path:"/home",component:E}),l.a.createElement(b.a,{exact:!0,path:"/problem/list",component:k}),l.a.createElement(b.a,{exact:!0,path:"/problem/write",component:R}),l.a.createElement(b.a,{exact:!0,path:"/problem/:idx(\\d+)",component:z}),l.a.createElement(b.a,{exact:!0,path:"/answer/list/:idx",component:J}),l.a.createElement(b.a,{exact:!0,path:"/answer/:idx(\\d+)",component:L}),l.a.createElement(b.a,{exact:!0,path:"/join",component:_}),l.a.createElement(b.a,{exact:!0,path:"/login",component:D})))},H=(a(56),function(){return l.a.createElement("footer",{className:"app-footer"},l.a.createElement("br",null),l.a.createElement("p",{className:"footer-copyright"},l.a.createElement("a",{href:"https://github.com/CreatiCoding/KW_DS_Project/tree/master/%EC%8B%A4%EC%8A%B5%EA%B3%BC%EB%AA%A9/Project3"},"CreatiCode")," ","From @Copyright"," ",l.a.createElement("a",{href:"https://github.com/CreatiCoding"},"CreatiCoding")," and"," ",l.a.createElement("a",{href:"https://github.com/jimmy3663"},"jimmy3663")))}),K=a(12),M=function(e){var t=Math.floor(Number(e));return t!==1/0&&String(t)===e&&t>=0},V=function(e){function t(e){var a;Object(h.a)(this,t),a=Object(v.a)(this,Object(g.a)(t).call(this,e)),window.component=Object(K.a)(Object(K.a)(a));for(var n=["/","/home","/problem/list","/problem/write","/answer/","/join","/login","/rank/list"],l=window.location.pathname,r=0;r<n.length;r++)if(l===n[r])return Object(v.a)(a);if(0===l.indexOf("/problem/")){if(!M(l.substr(9)))throw new Error("404 Error about path: "+l)}else{if(0!==l.indexOf("/answer/list/"))throw new Error("404 Error about path: "+l);if(!M(l.substr(13)))throw new Error("404 Error about path: "+l)}return a}return Object(N.a)(t,e),Object(f.a)(t,[{key:"render",value:function(){return null}}]),t}(n.Component),F=Object(y.a)(V),$=function(){return l.a.createElement(o.a,null,l.a.createElement("div",{className:"App"},l.a.createElement(F,null),l.a.createElement(p,null),l.a.createElement(G,null),l.a.createElement(H,null)))};Boolean("localhost"===window.location.hostname||"[::1]"===window.location.hostname||window.location.hostname.match(/^127(?:\.(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)){3}$/));var q=a(27),Q=a(11),T=a(28),U="CHANGE_MESSAGE",X={message:"Hello World!"};var Y=Object(Q.b)({messageReducer:function(){var e=arguments.length>0&&void 0!==arguments[0]?arguments[0]:X,t=arguments.length>1?arguments[1]:void 0;switch(t.type){case U:return Object(T.a)({},e,{message:t.message});default:return e}}}),Z=Object(Q.c)(Y);c.a.render(l.a.createElement(q.a,{store:Z},l.a.createElement($,null)),document.getElementById("root")),"serviceWorker"in navigator&&navigator.serviceWorker.ready.then(function(e){e.unregister()})}},[[29,2,1]]]);
//# sourceMappingURL=main.d06a66e5.chunk.js.map