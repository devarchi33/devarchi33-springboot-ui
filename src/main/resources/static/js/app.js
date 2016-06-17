/**
 * Created by donghoon on 2016. 6. 17..
 */
$(document).ready(function () {
    'use strict';

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
