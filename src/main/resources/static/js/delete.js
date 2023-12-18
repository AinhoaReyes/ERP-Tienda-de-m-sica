const handleClick = () => {
  const csrfHeader = $("meta[name='_csrf_header']").attr("content");
  const csrfToken = $("meta[name='_csrf']").attr("content");
  const headers = {};
  headers[csrfHeader] = csrfToken;
  $.ajax({
    type: "DELETE",
    headers,
    url: $("#delete").attr("href"),
    success: (res) => {
      console.log(res);
      toast.ok(res);
    },
    error: (res) => {
      console.error(res);
      toast.error(res.responseText);
    },
  });
};

$(document).ready(() => {
  $("#delete").click((e) => {
    e.preventDefault();
    handleClick();
  });
});
