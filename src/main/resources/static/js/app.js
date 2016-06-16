/**
 * Created by donghoon on 2016. 6. 17..
 */
$(document).ready(function () {
    'use strict';

    var deleteBtn = $("#deleteCustomerBtn");


    /**
     * customer delete event.
     */
    deleteBtn.on("click", function () {

        var checked = confirm("Are you really delete this customer?");

        if (checked) {
            var id = $("#deleteId").val();
            var token = $("#token").val();
            var deleteCustomerForm = makeForm("post", "/customers/delete");
            var deleteCustomerInput = makeInput("id", id);
            var csrfInput = makeInput("_csrf", token);

            deleteCustomerForm.appendChild(deleteCustomerInput);
            deleteCustomerForm.appendChild(csrfInput);
            deleteCustomerForm.submit();
        }
    });


    function makeInput(name, value) {
        var objs = document.createElement('input');
        objs.setAttribute('type', 'hidden');
        objs.setAttribute('name', name);
        objs.setAttribute('value', value);
        return objs;
    };

    function makeForm(method, url) {
        var form = document.createElement('form');
        form.setAttribute('method', method);
        form.setAttribute('action', url);
        document.body.appendChild(form);
        return form;
    };
});
