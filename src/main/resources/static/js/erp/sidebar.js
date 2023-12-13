const sidebarRef = document.getElementById("sidebar");
document.getElementById("sidebar-collapse").innerHTML = collapseIcon;
const handleCollapseClick = () => setIsSidebarCollapsed(sidebarRef);
const setIsSidebarCollapsed = (value) => {};

let isDropDownOpen = false;
document.getElementById("settings-icon").innerHTML = gearIcon;
document.getElementById("logout-icon").innerHTML = logoutIcon;
const userDropdownRef = document.getElementById("user-dropdown");
const handleUserClick = () => setIsDropDownOpen(userDropdownRef.hidden);

const setIsDropDownOpen = (value) => (userDropdownRef.hidden = !value);

const SidebarRoute = (name, href, icon) =>
  `<li class="sidebar-route ${
    ((href != "/" && window.location.pathname.includes(href)) ||
      (href === "/" && window.location.pathname === "/")) &&
    "active"
  }">
    <a class="icon-wrapper" href="${href}" title="Navigate to ${name}">
        ${icon} ${sidebarRef ? name : ""}
    </a>
</li>`;

document.getElementById("sidebar-routes").innerHTML = _routes
  .map((route) =>
    route.hidden ? "" : SidebarRoute(route.name, route.href, route.icon)
  )
  .join("");
