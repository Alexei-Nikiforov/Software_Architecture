const route = (event) => {
    event = event || window.event;
    event.preventDefault();
    window.history.pushState({}, "", event.target.href);
    handleLocation();
};

const routes = {
    404: "./pages/404.html",
    "/": "./DZ7/pages/home.html",
    "/about": "./DZ7/pages/about.html",
    "/contact": "./DZ7/pages/contact.html",
    "/card": "./DZ7/pages/card.html",
    "/form": "./DZ7/pages/form.html",
};



const handleLocation = async() => {
    const path = window.location.pathname;
    const route = routes[path] || routes[404];
    const html = await fetch(route).then((data) => data.text());
    document.getElementById("main-page").innerHTML = html;
};


window.onpopstate = handleLocation;
window.route = route;

handleLocation();