const ModalContent = (header, paragraph) => {
  const modalContent = document.createElement("div");
  modalContent.className = "modal-content";

  const headerElement = document.createElement("h2");
  headerElement.innerText = header;
  headerElement.className = "modal-header";

  const paragraphElement = document.createElement("p");
  paragraphElement.innerText = paragraph;
  paragraphElement.className = "modal-paragraph";

  modalContent.appendChild(headerElement);
  modalContent.appendChild(paragraphElement);
  return modalContent;
};

const ModalFooter = (action, onclick, variant, cancel, handleModalClose) => {
  const modalFooter = document.createElement("div");
  modalFooter.className = "modal-footer";

  const actionButton = document.createElement("button");
  actionButton.innerText = action;
  actionButton.type = "button";
  actionButton.className = `button button-${variant} modal-button`;
  actionButton.onclick = () => {
    onclick();
    handleModalClose();
  };

  const closeButton = document.createElement("button");
  closeButton.innerText = cancel;
  closeButton.onclick = handleModalClose;
  closeButton.className = "button button-outline modal-button";

  modalFooter.appendChild(actionButton);
  modalFooter.appendChild(closeButton);
  return modalFooter;
};

const createModal = (header, paragraph, onclick, action, variant, cancel) => {
  const handleModalClose = () => (modalWrapper.style.opacity = 0);

  const modalWrapper = document.createElement("div");
  modalWrapper.className = "modal-background";
  modalWrapper.onclick = handleModalClose;

  const modal = document.createElement("div");
  modal.className = "modal";
  modal.onclick = (e) => e.stopPropagation();

  const modalContent = ModalContent(header, paragraph);

  const modalFooter = ModalFooter(
    action,
    onclick,
    variant,
    cancel,
    handleModalClose
  );

  modal.appendChild(modalContent);
  modal.appendChild(modalFooter);

  modalWrapper.style.opacity = 0;
  setTimeout(() => (modalWrapper.style.opacity = 1), 0);
  modalWrapper.ontransitionend = () => {
    if (modalWrapper.style.opacity < 1) document.body.removeChild(modalWrapper);
  };

  modalWrapper.appendChild(modal);
  return modalWrapper;
};

const modal = {
  confirmation: (header, paragraph, onclick) =>
    document.body.appendChild(
      createModal(header, paragraph, onclick, "Save", "accent", "Cancel")
    ),
  destructive: (header, paragraph, onclick) =>
    document.body.appendChild(
      createModal(header, paragraph, onclick, "Delete", "destructive", "Cancel")
    ),
};
