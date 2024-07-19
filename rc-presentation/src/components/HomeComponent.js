import BaseComponent from '../../assets/BaseComponent.js'
import { getJson } from '../../assets/api.js';
import { msg, fmtNb } from '../../assets/i18n.js';

export default class HomeComponent extends BaseComponent {

  constructor() {
    super();
  }

  async beforeRender() {
    const url = "http://localhost:8080/countries/all";
    const contries = await getJson(url);
    this.data.contries = contries;
    // console.log(contries)
  }

  template() {
    return /*html*/`
    <main class="container">
      <h1 class='display-5'>${msg('rcHomeTitle')}</h1>
      <div class="row row-cols-md-1 row-cols-lg-2 row-cols-xl-4 g-3 mx-0">
        ${this.data.contries.map((contry) => {
          return this.countryCard(contry)
        }).join('')}
      </div>
    </main>`;
  }

  countryCard (contry) {
    return /*html*/`
    <div class="col ">
      <div class="card shadow-sm h-100">
        <a href="${contry.googleMap}" target="blank"><img src="${contry.flagPng}" class="card-img-top border-bottom" alt=""></a>
        <div class="card-body">
          <h2 class="card-title">${contry.countryName}</h2>
          <h3>${contry.countryCapital ? contry.countryCapital : "No capital"}</h3>
          <span class="text-nowrap">
            <i class="bi bi-people-fill"></i> ${fmtNb(contry.countryPopulation)}
          </span>
        </div>
      </div>
    </div>`
  }
}
