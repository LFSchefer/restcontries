import BaseComponent from "../../assets/BaseComponent.js";
import { getJson } from '../../assets/api.js';
import { msg } from '../../assets/i18n.js';

export default class TableComponent extends BaseComponent {

  constructor() {
    super();
  }

  async beforeRender() {
    const url = "http://localhost:8080/countries/admin"
    const response = await getJson(url);
    this.data.contriesTable = response
    // console.log(response)
  }

  template() {
    return `
    <main class="container">
    <h1 class='display-5'>${msg('rcTableTitle')}</h1>
    <div class="table-responsive">
      <table class="table table-striped table-hover table-md align-middle">
        <thead>
          <tr class="text-center">
            <th scope="col">Flag</th>
            <th scope="col">coat of arms</th>
            <th scope="col">ISO</th>
            <th scope="col">TLD</th>
            <th scope="col">Name</th>
            <th scope="col">Area</th>
          </tr>
        </thead>
        <tbody id="list-container">
          ${this.data.contriesTable.map((contry) => {
            return this.contryTable(contry)
          }).join("")}
        </tbody>
      </table>
    </div>
  </main>`;
  }

  contryTable(contry) {
    // console.log(contry);
    return `<tr class="text-center">
      <td class="col-1"><a href="${contry.googleMap === undefined ? '' : contry.googleMap}" target="_blank"><img src="${contry.flagPng}" class="sm-img img-fluid"></a></td>
      <td class="col-1">${contry.coatOfArmsPng === '' ? '<i class="bi bi-question-circle text-danger"></i>' : `<img src="${contry.coatOfArmsPng}" class="sm-img img-fluid"></img>`}</td>
      <td>${contry.isoCode === undefined ? '<i class="bi bi-question-circle text-danger"></i>' : contry.isoCode}</td>
      <td>${contry.tld === undefined ? '<i class="bi bi-question-circle text-danger"></i>' : contry.tld}</td>
      <td class="text-nowrap text-start">${contry.countryName === undefined ? '<i class="bi bi-question-circle text-danger"></i>' : contry.countryName}</td>
      <td class="text-end">${contry.countryArea === undefined ? '<i class="bi bi-question-circle text-danger"></i>' : new Intl.NumberFormat('en-EN').format(contry.countryArea)} km²</td>
    </tr>`
  }
}
