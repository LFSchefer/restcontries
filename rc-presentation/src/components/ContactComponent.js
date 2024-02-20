import BaseComponent from "../../assets/BaseComponent.js";
import { msg } from '../../assets/i18n.js';

export default class ContactComponent extends BaseComponent {

  constructor() {
    super();
  }

  template() {
    return /*html*/`
    <main class="container">
      <h1 class='display-5'>${msg('rcContactTitle')}</h1>
      </div>
    </main>`;
  }
}
