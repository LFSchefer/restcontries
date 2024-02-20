import HeaderComponent from "./components/HeaderComponent.js";
import message from "./messages/fr-FR.js";
// import message from "./messages/en-US.js";
import HomeComponent from "./components/HomeComponent.js";
import TableComponent from "./components/TableComponent.js";
import ContactComponent from "./components/ContactComponent.js";
import {initI18n} from "../assets/i18n.js";
import routes from "./routes/routes.js";
import initRouter from '../assets/router.js';



customElements.define('rc-header', HeaderComponent);
customElements.define('rc-homecomponent', HomeComponent);
customElements.define('rc-tablecomponent', TableComponent);
customElements.define('rc-contactcomponent', ContactComponent);
initI18n(message);
initRouter(routes);




// console.log(`./messages/${navigator.language}.js`)
