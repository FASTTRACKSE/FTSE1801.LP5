/*=========================================================================================
    File Name: 3-columns-left-sidebar.js
    Description: Invoices list datables configurations
    ----------------------------------------------------------------------------------------
    Item Name: Stack - Responsive Admin Theme
    Version: 1.1
    Author: GeeksLabs
    Author URL: http://www.themeforest.net/user/geekslabs
==========================================================================================*/

$(document).ready(function() {
    /***********************************
    *        js of small Slider        *
    ************************************/

    var sm_options = {
        start: [30,70],
        behaviour: 'drag',
        connect: true,
        range: {
            'min': 20,
            'max': 80
        }
    };
    var smallSlider = document.getElementById('small-slider');
    noUiSlider.create(smallSlider, sm_options);


    /*************************************
    *        Default Score Rating        *
    **************************************/
    $.fn.raty.defaults.path = '../../../app-assets/images/raty/';

    $('#score-rating').raty({
        score: 3
    });

    $(".sidebar-sticky").sticky();
});