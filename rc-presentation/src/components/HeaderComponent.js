import BaseComponent from "../../assets/BaseComponent.js";
import { msg, fmtDt } from "../../assets/i18n.js";

export default class HeaderComponent extends BaseComponent {

  constructor() {
    super();
  }

  beforeRender() {
    this.data.now = new Date();
  }

  template() {
    return /*html*/`
    <header class="navbar navbar-expand-lg bg-body-tertiary bg-primary-subtle sticky-top shadow-sm">
      <div class="container-fluid">
        <span class="mx-4"><a class="text-decoration-none fw-bold text-dark" aria-current="home" href="/#/index">${msg('rcBrand')}</a></span>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
          <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarSupportedContent">
          <a class="nav-link mx-3" aria-current="table" href="/#/table">${msg('rcMenuTable')}</a>
          <a class="nav-link mx-3" aria-current="table" href="/#/add-country">${msg('rcMenuCreate')}</a>
          <a class="nav-link mx-3" aria-current="contact" href="/#/contact">${msg('rcMenuContact')}</a>
        </div>
      </div>
      <div class="container bg-dark shadow-sm">
        <div class="text-light">${fmtDt(this.data.now)}</div>
      </div>
    </header>`;
  }
}
