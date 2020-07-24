$(function () {
           
    $('#startdate,#enddate').datetimepicker({
        useCurrent: false,
        format: 'MM-DD-YYYY',
        minDate: moment()
    });
    $('#startdate').datetimepicker().on('dp.change', function (e) {
        var incrementDay = moment(new Date(e.date));
        incrementDay.add(1, 'days');
        $('#enddate').data('DateTimePicker').minDate(incrementDay);
        $(this).data("DateTimePicker").hide();
    });

    $('#enddate').datetimepicker().on('dp.change', function (e) {
        var decrementDay = moment(new Date(e.date));
        decrementDay.subtract(1, 'days');
        $('#startdate').data('DateTimePicker').maxDate(decrementDay);
         $(this).data("DateTimePicker").hide();
    });

});


function relatorio(){
    $("#tabela").html(`
        <table id="sailorTable" class="table table-striped table-bordered" width="100%">
 
        <thead>
            <tr>
                <th>Alarme</th>
                <th>Quantidade</th>
            </tr>
        </thead>
        <tbody>
            <tr>
                <td>Tiger</td>
                <td>Nixon</td>
            </tr>
            <tr>
                <td>Garrett</td>
                <td>Winters</td>
            </tr>
            <tr>
                <td>Ashton</td>
                <td>Cox</td>
            </tr>
            <tr>
                <td>Cedric</td>
                <td>Kelly</td>
            </tr>
            <tr>
                <td>Airi</td>
                <td>Satou</td>
            </tr>
        </tbody>
    </table>
    `)
}