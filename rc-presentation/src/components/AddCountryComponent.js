import BaseFormComponent from "../../assets/BaseFormComponent.js";
import { msg } from '../../assets/i18n.js';

export default class AddCountryComponent extends BaseFormComponent {

  constructor() {
    super();
  }

  onValidationErrors() {
    let errorToast = document.querySelector("#toastNotice");
    let bsAlert = new bootstrap.Toast(errorToast);
    bsAlert.show();
  }

  validate() {
    const countryName = document.querySelector("#countryName");
    const countryCapital = document.querySelector("#countryCapital");
    const population = document.querySelector("#population");
    const area = document.querySelector("#area");
    const isoCode = document.querySelector("#isoCode");
    const tld = document.querySelector("#tld");
    const flagPng = document.querySelector("#flagPng");
    const coatOfArmsPng = document.querySelector("#coatOfArmsPng");
    const googleMap = document.querySelector("#googleMap");

    resetFormDisplay()

    let isValide = {
      countryName: false,
      countryCapital: false,
      countryPopulation: false,
      countryArea: false,
      flagPng: false,
      coatOfArmsPng: false,
      googleMap: false,
      tld: false,
      isoCode: false
    };

    if (this.data.countryName.length > 0 && this.data.countryName.length <= 60) {
      isValide.countryName = true;
    }
    if (this.data.countryCapital.length > 0 && this.data.countryCapital.length <= 200) {
      isValide.countryCapital = true;
    }
    if (typeof(parseFloat(this.data.countryPopulation)) == 'number' && this.data.countryPopulation > 0 && this.data.countryPopulation <= 9223372036854775807) {
      isValide.countryPopulation = true;
    }
    if (typeof(parseFloat(this.data.countryArea)) == 'number' && this.data.countryArea > 0  && this.data.countryArea <= 2147483647) {
      isValide.countryArea = true;
    }
    if (this.data.flagPng.length > 0 && this.data.flagPng.length <= 40) {
      isValide.flagPng = true;
    }
    if (this.data.coatOfArmsPng == "" || this.data.coatOfArmsPng.length <= 60) {
      isValide.coatOfArmsPng = true;
    }
    if (this.data.googleMap.length > 0 && this.data.googleMap.length <= 40) {
      isValide.googleMap = true;
    }
    if (this.data.tld == "" || this.data.tld.length == 2) {
      isValide.tld = true;
    }
    if (this.data.isoCode.length == 2) {
      isValide.isoCode = true;
    }

    console.log(isValide);
    if (
      isValide.countryName &&
      isValide.countryCapital &&
      isValide.countryPopulation &&
      isValide.countryArea &&
      isValide.flagPng &&
      isValide.coatOfArmsPng &&
      isValide.googleMap &&
      isValide.tld &&
      isValide.isoCode
    ) {
      let errorToast = document.querySelector("#toastSuccess");
      let bsAlert = new bootstrap.Toast(errorToast);
      bsAlert.show();
      const countryData = {
        countryName: this.data.countryName,
        countryCapital: this.data.countryCapital,
        countryPopulation: parseFloat(this.data.countryPopulation),
        countryArea: parseFloat(this.data.countryArea),
        flagPng: this.data.flagPng,
        coatOfArmsPng: this.data.coatOfArmsPng,
        googleMap: this.data.googleMap,
        tld: this.data.tld.toUpperCase(),
        isoCode: this.data.isoCode.toLowerCase()
      }
      console.log(countryData);
      this.submit("http://localhost:8080/countries/create", countryData);
      return true
    }
    else {
      displayErrorForm(isValide)
      return false
    }

    function displayErrorForm(object) {
      if (object.countryName) {
        countryName.classList.add("is-valid");
      } else {
        countryName.classList.add("is-invalid");
      }
      if (object.countryCapital) {
        countryCapital.classList.add("is-valid");
      } else {
        countryCapital.classList.add("is-invalid");
      }
      if (object.countryPopulation) {
        population.classList.add("is-valid");
      } else {
        population.classList.add("is-invalid");
      }
      if (object.countryArea) {
        area.classList.add("is-valid");
      } else {
        area.classList.add("is-invalid");
      }
      if (object.flagPng) {
        flagPng.classList.add("is-valid");
      } else {
        flagPng.classList.add("is-invalid");
      }
      if (object.coatOfArmsPng) {
        coatOfArmsPng.classList.add("is-valid");
      } else {
        coatOfArmsPng.classList.add("is-invalid");
      }
      if (object.googleMap) {
        googleMap.classList.add("is-valid");
      } else {
        googleMap.classList.add("is-invalid");
      }
      if (object.tld) {
        tld.classList.add("is-valid");
      } else {
        tld.classList.add("is-invalid");
      }
      if (object.isoCode) {
        isoCode.classList.add("is-valid");
      } else {
        isoCode.classList.add("is-invalid");
      }
    }

    function resetFormDisplay() {
      countryName.className = "form-control";
      countryCapital.className = "form-control";
      population.className = "form-control";
      area.className = "form-control";
      isoCode.className = "form-control";
      tld.className = "form-control";
      flagPng.className = "form-control";
      coatOfArmsPng.className = "form-control";
      googleMap.className = "form-control";
    }
  }

  template() {
    return /*html*/`
      <h1 class='display-5'>${msg('rcCreateTitle')}</h1>
      <main class="container">
      <div class="row">
        <div id="toastNotice" class="toast bg-danger col-6 offset-6 mt-4">
          <div class="toast-body text-light">
            Sorry, something went wrong please try again !
          </div>
        </div>

        <div id="toastSuccess" class="toast bg-success col-6 offset-6 mt-4">
          <div class="toast-body text-light">Country send =) !</div>
          </div>
        </div>

      <div class="row row-cols-md-2 row-cols-1">
        <div class="col order-md-1 order-2 my-4">
          <img
            class="w-100 rounded-5 shadow"
            src="https://img.freepik.com/vecteurs-libre/banniere-vierge-jolie-licorne-dans-fond-ciel-pastel_1308-45955.jpg?w=1480&t=st=1707313511~exp=1707314111~hmac=88cca5b28f8f1a3b135d105d0e91c9f6408031e148c28796727897b3351e4e6a"
            alt=""
          />
        </div>
        <div class="col order-md-2 order-1 my-4">
          <form class="form" novalidate>
            <div class="mb-3">
              <label for="inputcountryname" class="form-label">${msg('rcFormCountryName')}<span class="text-danger">*</span></label>
              <input
                type="text"
                class="form-control"
                id="countryName"
                name="countryName"
              />
              <div class="invalid-feedback">
                ${msg('rcFormValidationCountryName')}
              </div>
            </div>
            <div class="mb-3">
              <label for="inputCountryCapital" class="form-label"
                >${msg('rcFormCountryCapital')}<span class="text-danger">*</span></label
              >
              <input name="countryCapital" type="text" class="form-control" id="countryCapital" />
              <div class="invalid-feedback">
              ${msg('rcFormValidationCountryCapital')}
              </div>
            </div>
            <div class="mb-3">
              <label for="population" class="form-label"
                >${msg('rcFormPopulation')}<span class="text-danger">*</span></label
              >
              <input
                type="Population"
                class="form-control"
                id="population"
                name="countryPopulation"
              />
              <div class="invalid-feedback">${msg('rcFormValidationPopulation')}</div>
            </div>
            <div class="mb-3">
              <label for="area" class="form-label"
                >${msg('rcFormArea')}<span class="text-danger">*</span></label
              >
              <input
                type="area"
                class="form-control"
                id="area"
                name="countryArea"
              />
              <div class="invalid-feedback">${msg('rcFormValidationArea')}</div>
            </div>
            <div class="mb-3">
              <label for="isoCode" class="form-label"
              >${msg('rcFormIsoCode')}<span class="text-danger">*</span></label>
              <input
                type="isoCode"
                class="form-control"
                id="isoCode"
                name="isoCode"
                />
              <div class="invalid-feedback">${msg('rcFormValidationIsoCode')}</div>
            </div>
            <div class="mb-3">
              <label for="tld" class="form-label"
                >${msg('rcFormTld')}</label
                >
              <input
                type="tld"
                class="form-control"
                id="tld"
                name="tld"
              />
              <div class="invalid-feedback">${msg('rcFormValidationTld')}</div>
            </div>
            <div class="mb-3">
              <label for="flagPng" class="form-label"
                >${msg('rcFormFlagPng')}<span class="text-danger">*</span></label
              >
              <input
                type="flagPng"
                class="form-control"
                id="flagPng"
                name="flagPng"
              />
              <div class="invalid-feedback">${msg('rcFormValidationFlagPng')}</div>
            </div>
            <div class="mb-3">
              <label for="coatOfArmsPng" class="form-label"
                >${msg('rcFormCoatOfArmsPng')}</label
              >
              <input
                type="coatOfArmsPng"
                class="form-control"
                id="coatOfArmsPng"
                name="coatOfArmsPng"
              />
              <div class="invalid-feedback">${msg('rcFormValidationCoatOfArms')}</div>
            </div>
            <div class="mb-3">
              <label for="googleMap" class="form-label"
                >${msg('rcFormGoogleMap')}<span class="text-danger">*</span></label>
              <input
                type="googleMap"
                class="form-control"
                id="googleMap"
                name="googleMap"
              />
              <div class="invalid-feedback">${msg('rcFormValidationEmail')}</div>
            </div>
            <button
              type="submit"
              class="btn btn-primary col-12 col-md-3 offset-md-9"
              id="submit"
            >
              ${msg('rcFormSubmit')}
            </button>
          </form>
        </div>
      </div>
    </main>`;
  }
}
