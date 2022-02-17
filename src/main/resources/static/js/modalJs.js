$('#modal-confirm').on('show.bs.modal', function(e) {
	var id = $(e.relatedTarget).data('employeeid');
	var name = $(e.relatedTarget).data('employeename');
	var url = $(e.relatedTarget).data('url');
	$(e.currentTarget).find('input[name="employeeId"]').val(id);
	$('#employee-name-deleted').html(name);
	$('#employee-id-deleted').html("ID : " + id);
	$('#confirmDelete').attr("href", url);
});

$('#modal-addData')
		.on(
				'show.bs.modal',
				function(e) {
					var btnAction = $(e.relatedTarget).data('buttonaction');
					let
					now = new Date();

					let
					now1 = new Date();
					var maxDate = new Date(now1.setMonth(now1.getMonth() + 3));
					var day1 = ("0" + maxDate.getDate()).slice(-2);
					var month1 = ("0" + (maxDate.getMonth() + 1)).slice(-2);
					var today1 = maxDate.getFullYear() + "-" + (month1) + "-"
							+ (day1);
					$('#dateJoined').attr('max', today1);

					let
					now2 = new Date();
					var minDate = new Date(now2.setMonth(now2.getMonth() - 2));
					var day2 = ("0" + minDate.getDate()).slice(-2);
					var month2 = ("0" + (minDate.getMonth() + 1)).slice(-2);
					var today2 = minDate.getFullYear() + "-" + (month2) + "-"
							+ (day2);
					$('#dateJoined').attr('min', today2);

					if (btnAction == "edit") {
						$('#headModalAdd').html("Edit Employee's Data");
						var id = $(e.relatedTarget).data('employeeid');
						var name = $(e.relatedTarget).data('employeename');
						var phone = $(e.relatedTarget).data('employeephone');
						var joined = ($(e.relatedTarget)
								.data('employeedatejoined'));
						var remibursement = $(e.relatedTarget).data(
								'employeemaxreimbursement');
						var created = ($(e.relatedTarget)
								.data('employeedatecreated'));
						var updated = ($(e.relatedTarget)
								.data('employeelastupdated'));

						var action = $(e.relatedTarget).data('action');
						$('#addData').attr("action", action);

						$(e.currentTarget).find('input[name="employeeId"]')
								.val(id);
						$(e.currentTarget).find('input[name="employeeName"]')
								.val(name);
						$(e.currentTarget).find('input[name="employeePhone"]')
								.val(phone);
						$(e.currentTarget).find('input[name="dateJoined"]')
								.val(joined);
						$(e.currentTarget).find('input[name="dateCreated"]')
								.val(created);
						$(e.currentTarget).find(
								'input[name="maxReimbursement"]').val(
								remibursement);
						$(e.currentTarget).find('input[name="lastUpdated"]')
								.val(updated);
					}

					if (btnAction == "add") {
						$('#headModalAdd').html("Add New Employee");
						var action = $(e.relatedTarget).data('action');
						$('#addData').attr("action", action);

						var day = ("0" + now.getDate()).slice(-2);
						var month = ("0" + (now.getMonth() + 1)).slice(-2);
						var today = now.getFullYear() + "-" + (month) + "-"
								+ (day);
						$('#dpCreated').attr('value', today);
						$('#dpUpdated').attr('value', today);

					}

				});

$('#modal-addData').on('hidden.bs.modal', function() {
	$('#modal-addData form')[0].reset();
});
