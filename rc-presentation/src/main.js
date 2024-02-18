import HeaderComponent from "./components/HeaderComponent.js";
// import message from "./messages/fr-FR.js";
import message from "./messages/en-US.js";

import {init} from "../assets/i18n.js";

init(message);
customElements.define('rc-header', HeaderComponent);


console.log(`./messages/${navigator.language}.js`)
