const toastWrapper = document.createElement("div");
toastWrapper.className = "toast-wrapper";
document.body.appendChild(toastWrapper);

const createToast = (src, text, duration) => {
  const toastElement = document.createElement("div");
  toastElement.className = "toast";
  const toastImage = document.createElement("img");
  toastImage.src = src;
  toastImage.className = "toast-icon";
  const toastBody = document.createElement("p");
  toastBody.innerText = text;
  toastElement.appendChild(toastImage);
  toastElement.appendChild(toastBody);
  toastElement.ontransitionend = () => toastWrapper.removeChild(toastElement);
  toastElement.style.opacity = 1;
  setTimeout(() => (toastElement.style.opacity = 0), duration);
  return toastElement;
};

const toast = {
  ok: (message) =>
    toastWrapper.appendChild(createToast("/images/tick.png", message, 3000)),
  error: (message) =>
    toastWrapper.appendChild(createToast("/images/cross.png", message, 3000)),
};
