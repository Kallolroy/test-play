$ ->
  $.get "/users", (data) ->
    $.each data, (index, item) ->
      $("#users").append $("<li>").html(
        'Name :'+ item.name +
          '<br> Email:'+ item.email +
          '<br> Address:' + item.address +
            '<br> <a href="/user/delete?id='+item.email+'">Delete </a>')
