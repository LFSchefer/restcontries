import HeaderComponent from "./components/HeaderComponent.js";
// import messages from "./messages/ja-JP.js";
// import messages from "./messages/ar-MA.js"
// import messages from "./messages/pl-PL.js";
// import messages from "./messages/fr-FR.js";
import messages from "./messages/en-US.js";

async function lng() {
  const module = await import (`./messages/${navigator.language}.js`);
  return module.default;
}


import HomeComponent from "./components/HomeComponent.js";
import TableComponent from "./components/TableComponent.js";
import ContactComponent from "./components/ContactComponent.js";
import AddCountryComponent from "./components/AddCountryComponent.js";
import {initI18n} from "../assets/i18n.js";
import routes from "./routes/routes.js";
import initRouter from '../assets/router.js';



customElements.define('rc-header', HeaderComponent);
customElements.define('rc-homecomponent', HomeComponent);
customElements.define('rc-tablecomponent', TableComponent);
customElements.define('rc-contactcomponent', ContactComponent);
customElements.define('rc-addcountrycomponent', AddCountryComponent)
initI18n(messages);
initRouter(routes);


// console.log(`./messages/${navigator.language}.js`)
