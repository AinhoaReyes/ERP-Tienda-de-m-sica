document.addEventListener("keydown", (e) => {
  if (e.key === "k" && (e.metaKey || e.ctrlKey)) {
    e.preventDefault();
    searchOpen = true;
  }
});

if (window.location.pathname === "/") {
  document.getElementById("header-route-icon").innerHTML = homeIcon;
  document.getElementById(
    "header-route"
  ).innerHTML = `<p>Home / <span class="active">Overview</span></p>`;
} else {
  const filteredRoute = _routes.filter(
    (route) =>
      route.href !== "/" && window.location.pathname.includes(route.href)
  );
  document.getElementById("header-route-icon").innerHTML =
    filteredRoute[0].icon;
  document.getElementById(
    "header-route"
  ).innerHTML = `<p>${filteredRoute[0].name} / <span class="active">Overview</span></p>`;
}

document.getElementById("header-search-icon").innerHTML = searchIcon;
