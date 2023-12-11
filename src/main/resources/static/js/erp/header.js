const setSearchRoutes = (array) =>
  (document.getElementById("route-search-routes").innerHTML = array
    .map((route) => SearchRoute(route.name, route.href, route.icon))
    .join(""));

const isActive = (href) => {
  if (window.location.pathname === "/" && href === "/") {
    return true;
  }
  return href !== "/" && window.location.pathname.includes(href);
};

const SearchRoute = (name, href, icon) =>
  `<li class="row-item">
    <a class="link-wrapper" href="${href}" title="Navigate to ${name}">
      <div class="icon-wrapper ${isActive(href) ? "active" : ""}">${icon}</div>
      <p>${name}</p>
    </a>
  </li>`;

document.getElementById("header-search-icon").innerHTML = searchIcon;
document.getElementById("route-search-icon").innerHTML = searchIcon;
document.getElementById("modal-close-icon").innerHTML = crossIcon;
document
  .getElementById("header-modal-content")
  .addEventListener("click", (e) => e.stopPropagation());

const headerModalRef = document.getElementById("header-modal");
const handleSearchbarClick = () => setIsSearchOpen(true);
const handleModalClose = () => {
  routeInputRef.value = "";
  setSearchRoutes(_routes);
  setIsSearchOpen(false);
};

const routeInputRef = document.getElementById("route-search-input");
routeInputRef.addEventListener("input", (e) => {
  const value = e.target.value.toLowerCase();
  setSearchRoutes(
    (filteredRoutes = _routes.filter((i) =>
      i.name.toLowerCase().startsWith(value.toLowerCase())
    ))
  );
});

const setIsSearchOpen = (value) => {
  headerModalRef.hidden = !value;
  if (value) {
    document.getElementById("route-search-input").focus();
  }
};

document.addEventListener("keydown", (e) => {
  if (e.key === "k" && (e.metaKey || e.ctrlKey)) {
    e.preventDefault();
    setIsSearchOpen(headerModalRef.hidden || false);
  }
});

const activeRoute = _routes.find((i) => {
  if (window.location.pathname === "/" && i.href === "/") {
    return true;
  }
  return i.href !== "/" && window.location.pathname.includes(i.href);
});

document.getElementById("header-route-icon").innerHTML = activeRoute.icon;
setSearchRoutes(_routes);
