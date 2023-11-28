let isCollapsed = true;
document.getElementById("sidebar-collapse").innerHTML = collapseIcon;

const SidebarRoute = (name, href, icon) =>
  `<li class="sidebar-route ${
    ((href != "/" && window.location.pathname.includes(href)) ||
      (href === "/" && window.location.pathname === "/")) &&
    "active"
  }">
    <a class="icon-wrapper" href="${href}" title="Navigate to ${name}">
        ${icon} ${!isCollapsed ? name : ""}
    </a>
</li>`;

document.getElementById("sidebar-routes").innerHTML = _routes
  .map((route) => SidebarRoute(route.name, route.href, route.icon))
  .join("");
