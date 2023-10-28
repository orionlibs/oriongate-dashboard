"use strict";
(function () {
  if (localStorage.getItem("zemthemecolors") == "dark") {
    document.querySelector("html").setAttribute("data-theme-color", "dark");
  }
})();