import BaseComponent from "../../assets/BaseComponent.js";
import { getJson } from '../../assets/api.js';
import { msg } from '../../assets/i18n.js';

export default class TableComponent extends BaseComponent {

  constructor() {
    super();
  }

  async beforeRender() {
    const url = "https://restcountries.com/v3.1/region/europe?fields=name,flags,coatOfArms,tld,area,cca2,maps"
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
    return `<tr class="text-center">
      <td class="col-1"><a href="${contry.maps.googleMaps === undefined ? '' : contry.maps.googleMaps}" target="_blank"><img src="${contry.flags.png}" class="sm-img img-fluid"></a></td>
      <td class="col-1">${contry.coatOfArms.png === '' ? '<i class="bi bi-question-circle text-danger"></i>' : `<img src="${contry.coatOfArms.png}" class="sm-img img-fluid"></img>`}</td>
      <td>${contry.cca2 === undefined ? '<i class="bi bi-question-circle text-danger"></i>' : contry.cca2}</td>
      <td>${contry.tld[0] === undefined ? '<i class="bi bi-question-circle text-danger"></i>' : contry.tld[0]}</td>
      <td class="text-nowrap text-start">${contry.name.official === undefined ? '<i class="bi bi-question-circle text-danger"></i>' : contry.name.official}</td>
      <td class="text-end">${contry.area === undefined ? '<i class="bi bi-question-circle text-danger"></i>' : new Intl.NumberFormat('en-EN').format(contry.area)} km²</td>
    </tr>`
  }
}
