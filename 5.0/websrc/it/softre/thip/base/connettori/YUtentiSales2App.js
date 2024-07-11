function YUtentiSales2AppOL(){
  if(document.forms[0].thMode.value == "NEW"){
	  $("#dati").hide();
  }else{
	  //$("#dati").show();
  }
  $('#user').autocomplete({
		source: function(request, response) {
			var jsonData = JSON.parse(json);
			var datamap = jsonData.map(function(data) {
				var name = data.firstname.trim();
				var lastname = data.lastname.trim();
				var email = data.email.trim();
				var phone = data.phone.trim();
				var id = data.id;
				var hash = data.hash.trim();
				var role = data.role.trim();
				return {
					label: name+ ' ' + lastname,
					value: hash,
					lastname: lastname,
					name : name,
					email : email,
					phone: phone,
					id : id,
					role : role,
					hash : hash,
				}
			});
			var key = request.term;
			datamap = datamap.filter(function(i) {
				return (i.name.toUpperCase().indexOf(key.toUpperCase()) >= 0
					|| i.value.toUpperCase().indexOf(key.toUpperCase()) >= 0);
			});
			response(datamap);
		},
		minLength: 0,
		delay: 500,
		select: function(event, ui) {
			let firstname = ui.item.name.trim();
			this.value = firstname;
			//settare gli altri valori
			$('#Lastname').val(ui.item.lastname);
			$('#FirstName').val(ui.item.name);
			$('#Email').val(ui.item.email);
			$('#Phone').val(ui.item.phone);
			$('#Id').val(ui.item.id);
			$('#HashUser').val(ui.item.hash);
			$('#Role').val(ui.item.role);
			$("#dati").show();
			return false;
		},
	}).data("ui-autocomplete")._renderItem = function(ul, item) {
		let name = String(item.name).replace(new RegExp(this.term, "gi"), "<b>$&</b>");
		let lastname = String(item.lastname.trim()).replace(new RegExp(this.term, "gi"), "<b>$&</b>");
		return $("<li></li>")
			.data("ui-autocomplete-item", item)
			.append("<table class='table m-0'><tr><td style='width:200px'><a>" + lastname + "</a></td><td><a>" + name.trim() + "</a></tr></table>")
			.appendTo(ul);
	};
}
