const handleSubmit = () => {
  const data = $("#formData").serialize();
  const csrfHeader = $("meta[name='_csrf_header']").attr("content");
  const csrfToken = $("meta[name='_csrf']").attr("content");
  const headers = {};
  headers[csrfHeader] = csrfToken;
  $.ajax({
    type: "POST",
    headers,
    url: $("#formData").attr("action"),
    data,
    success: (res) => console.log(res),
    error: (res) => console.error(res),
  });
};

$(document).ready(() => {
  $("#formData").submit((e) => {
    e.preventDefault();
    handleSubmit();
  });
});
