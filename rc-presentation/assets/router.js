let target = null;
const registry = new Map();

function initRouter(routes) {
  target = document.querySelector(routes.target)
  const mappings = routes.mappings;
  for (let i = 0; i < mappings.length; i++) {
    const mapping = mappings[i] // {name: , component:}
    const element = '<rc-' + mapping.component.toLowerCase()+'></rc-'+mapping.component.toLowerCase()+'>';
    registry.set(mapping.name, element)
  }
  window.addEventListener('hashchange', (event) => {
    const hash = window.location.hash;
    const name = hash.split('#/')[1];
    const element = registry.get(name);
    target.innerHTML = element;
  })
}

export default initRouter;
