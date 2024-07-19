import BaseComponent from "./BaseComponent.js";

export default class BaseFormComponent extends BaseComponent {

  constructor() {
    super();
  }

  async connectedCallback() {
    await super.connectedCallback();
    const form = this.querySelector('form');
    form.addEventListener('submit',(event)=> {
      event.preventDefault();
      // read form input => bound to data
      const formData = new FormData(form);
      formData.forEach((value, key )=> {
        this.data[key] = value.trim();
      })
      // console.log(this.data)
      const valid = this.validate();
      if (valid) {
        console.log('is valid');
      }
      else {
        console.log('is not valid');
        this.onValidationErrors();
      }
    })
  }

  async submit(url, data) {
    try {
      const response = await fetch(url, {
        method: "POST",
        headers: {
          "Content-Type": "application/json",

        },
        body: JSON.stringify(data)
      });

    } catch (error) {

    }
    console.log("submit")
  }

  validate() {
    return true;
  }

  onValidationErrors() {
    return;
  }
}
