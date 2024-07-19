import BaseFormComponent from "../../assets/BaseFormComponent.js";
import { msg } from '../../assets/i18n.js';

export default class ContactComponent extends BaseFormComponent {

  constructor() {
    super();
  }

  onValidationErrors() {
    let errorToast = document.querySelector("#toastNotice");
    let bsAlert = new bootstrap.Toast(errorToast);
    bsAlert.show();
  }

  validate() {
    const firstname = document.querySelector("#firstName");
    const lastname = document.querySelector("#lastName");
    const email = document.querySelector("#email");
    const comments = document.querySelector("#comment");
    const regex =/^[\w]{1,64}([!#$%&'*+-=?^_`{|]|\w){0,62}[@][\w]{1,253}([-]|\w)[\w]{3,253}(\.\w{2,4})(\.\w{2,4})?$/;

    resetFormDisplay()

    let isValide = {
      firstname: false,
      lastname: false,
      email: false,
      comments: false,
    };

    if (this.data.firstname.length > 0 && this.data.firstname.length <= 100) {
      isValide.firstname = true;
    }
    if (this.data.lastname.length > 0 && this.data.lastname.length <= 100) {
      isValide.lastname = true;
    }
    if (this.data.email.length > 0 && regex.test(this.data.email)) {
      isValide.email = true;
    }
    if (this.data.comment == "" || this.data.comment.length < 1000) {
      isValide.comments = true;
    }

    if (
      isValide.firstname &&
      isValide.lastname &&
      isValide.email &&
      isValide.comments
    ) {
      let errorToast = document.querySelector("#toastSuccess");
      let bsAlert = new bootstrap.Toast(errorToast);
      bsAlert.show();
      const mailData = {
        firstname: this.data.firstname,
        lastname: this.data.lastname,
        email: this.data.email,
        comments: this.data.comment
      }
      // console.log(mailData);
      this.submit("http://localhost:8080/mail/send", mailData);
      return true
    }
    else {
      displayErrorForm(isValide)
      return false
    }

    function displayErrorForm(object) {
      if (object.firstname) {
        firstname.classList.add("is-valid");
      } else {
        firstname.classList.add("is-invalid");
      }
      if (object.lastname) {
        lastname.classList.add("is-valid");
      } else {
        lastname.classList.add("is-invalid");
      }
      if (object.email) {
        email.classList.add("is-valid");
      } else {
        email.classList.add("is-invalid");
      }
      if (object.comments) {
        comments.classList.add("is-valid");
      } else {
        comments.classList.add("is-invalid");
      }
    }

    function resetFormDisplay() {
      firstname.className = "form-control firstName";
      lastname.className = "form-control";
      email.className = "form-control";
      comments.className = "form-control";
    }
  }

  template() {
    return /*html*/`
    <main class="container">
      <h1 class='display-5'>${msg('rcContactTitle')}</h1>
      <main class="container">
      <div class="row">
        <div id="toastNotice" class="toast bg-danger col-6 offset-6 mt-4">
          <div class="toast-body text-light">
            Sorry, something went wrong please try again !
          </div>
        </div>

        <div id="toastSuccess" class="toast bg-success col-6 offset-6 mt-4">
          <div class="toast-body text-light">Mail send =) !</div>
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
              <label for="inputFirstname" class="form-label">${msg('rcFormFirstname')}<span class="text-danger">*</span></label>
              <input
                type="text"
                class="form-control firstName"
                id="firstName"
                name="firstname"
              />
              <div class="invalid-feedback">
                ${msg('rcFormValidationBlank100')}
              </div>
            </div>
            <div class="mb-3">
              <label for="inputLastname" class="form-label"
                >${msg('rcFormLastName')}<span class="text-danger">*</span></label
              >
              <input name="lastname" type="text" class="form-control" id="lastName" />
              <div class="invalid-feedback">
              ${msg('rcFormValidationBlank100')}
              </div>
            </div>
            <div class="mb-3">
              <label for="InputEmail" class="form-label"
                >${msg('rcFormEmail')}<span class="text-danger">*</span></label
              >
              <input
                type="email"
                class="form-control"
                id="email"
                placeholder="exemple@mail.com"
                name="email"
              />
              <div class="invalid-feedback">${msg('rcFormValidationEmail')}</div>
            </div>
            <div class="mb-3">
              <label for="exampleFormControlTextarea1" class="form-label"
                >${msg('rcFormComment')}</label
              >
              <textarea
                class="form-control"
                id="comment"
                rows="3"
                maxlength="1000"
                name="comment"
              ></textarea>
              <div class="invalid-feedback">${msg('rcFormValidationComment')}</div>
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
    </main>
    </main>`;
  }
}
