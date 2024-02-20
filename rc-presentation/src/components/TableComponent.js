import BaseComponent from "../../assets/BaseComponent.js";
import { getJson } from '../../assets/api.js';
import { msg } from '../../assets/i18n.js';

export default class TableComponent extends BaseComponent {

  constructor() {
    super();
  }

  async beforeRender() {
    
  }

  template() {
    return /*html*/`
    <main class="container">
      <h1 class='display-5'>${msg('rcTableTitle')}</h1>
      </div>
    </main>`;
  }
}
