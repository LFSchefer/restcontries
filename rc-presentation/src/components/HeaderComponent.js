export default class HeaderComponent extends HTMLElement {

  constructor() {
    super();
  }

  connectedCallback() {
    this.render();
  }

  render() {
    const html = this.template();
    this.innerHTML = html;
  }

  template() {
    return /*html*/`
    <header class="navbar navbar-expand-lg bg-body-tertiary bg-primary-subtle sticky-top shadow-sm">
      <div class="container-fluid">
        <span class="mx-4">Rest Contries</span>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
          <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarSupportedContent">
          <a class="nav-link mx-3" aria-current="home" href="./index.html">Home</a>
          <a class="nav-link mx-3" aria-current="table" href="./table.html">Table</a>
          <a class="nav-link mx-3" aria-current="contact" href="./contact.html">Contact</a>
        </div>
      </div>
    </header>`;
  }
}
