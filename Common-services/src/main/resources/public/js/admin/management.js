$(document).ready(function() {

    //notify function
    function notify(from, align, icon, type, animIn, animOut, msg) {
        $.notify({
            icon: icon,
            title: '',
            message: msg,
            url: ''
        }, {
            element: 'body',
            type: type,
            allow_dismiss: false,
            placement: {
                from: from,
                align: align
            },
            offset: {
                x: 20,
                y: 20
            },
            spacing: 10,
            z_index: 1000000000,
            delay: 1500,
            timer: 750,
            url_target: '_blank',
            mouse_over: false,
            animate: {
                enter: animIn,
                exit: animOut
            },
            template: '<div data-notify="container" class="alert alert-dismissible alert-{0} alert--notify" role="alert">' +
                '<span data-notify="icon"></span> ' +
                '<span data-notify="title">{1}</span> ' +
                '<span data-notify="message">{2}</span>' +
                '<div class="progress" data-notify="progressbar">' +
                '<div class="progress-bar progress-bar-{0}" role="progressbar" aria-valuenow="0" aria-valuemin="0" aria-valuemax="100" style="width: 0%;"></div>' +
                '</div>' +
                '<a href="{3}" target="{4}" data-notify="url"></a>' +
                '<button type="button" aria-hidden="true" data-notify="dismiss" class="alert--notify__close">Close</button>' +
                '</div>'
        });
    };



    var data = {
        "data" : []
    };

    $.fn.dataTable.moment('M/D/YYYY, hh:mm:ss a');
    var table = $('#userTable').DataTable({
        ajax : {
            "url" : "/user/user"
        },
        data : data.data,
        columnDefs : [ {
            "targets" : [ 0
            ],
            "searchable" : false
        }
        ],
        columns : [ {
            data : 'id'
        }, {
            data : null,
            render : function(data) {
                return data.firstName + ' ' + data.lastName;
            }
        }, {
            data : 'username'
        }, {
            data : null,
            render : function(data) {
                return data.role == "ROLE_ADMIN" ? "System Administrator" : "User";
            }
        }, {
            data : null,
            render : function(data) {
                return data.enable ? "Yes" : "No";
            }
        }, {
            data : null,
            render : function(data) {
                return localeDateString(data.createTime)
            }
        }, {
            data : null,
            render : function(data) {
                return localeDateString(data.lastUpdate)
            }
        }, {
            data : null,
            render : function(data) {
                html = '<div class="btn-demo">';
                html += '<button class="btn btn-info btn-sm" data-toggle="modal" data-target="#edit-user-modal" data-id="' + data.id + '"><i class="zmdi zmdi-edit"></i> Edit</button>'
                html += '<button class="btn btn-warning btn-sm" data-toggle="modal" data-target="#reset-password-modal" data-id="' + data.id + '"><i class="zmdi zmdi-undo"></i> Reset Password</button>'
                if (data.enable) {
                    html += '<button class="btn btn-light btn-sm" data-toggle="modal" data-target="#toggle-disable-modal" data-id="' + data.id + '"><i class="zmdi zmdi-block"></i> Disable</button>'
                } else {
                    html += '<button class="btn btn-light btn-sm" data-toggle="modal" data-target="#toggle-enable-modal" data-id="' + data.id + '"><i class="zmdi zmdi-arrow-right"></i> Enable</button>'
                }
                html += '</div>'
                return html
            }
        }
        ],
        order : [ [ 6, 'desc'
        ]
        ],
    });

    // var $createUserForm = $('#create-user-form');
    // $createUserForm.on('submit', function(ev){
    //     ev.preventDefault();
    //     if ($createUserForm[0].checkValidity()) {
    //         var form = {
    //             "username" : $("#c_username").val(),
    //             "firstName" : $("#c_firstname").val(),
    //             "lastName" : $("#c_lastname").val(),
    //             "enabled" : true,
    //             "role" : $('input[name=c_role]:checked', '#create-user-form').val()
    //         };
    //
    //         $.ajax({
    //             'url' : "/user/user",
    //             'type' : 'put',
    //             'data' : JSON.stringify(form),
    //             'contentType' : "application/json",
    //             'dataType' : 'json',
    //             'success' : function(data) {
    //                 console.log(data);
    //                 if(data.code == 0){
    //                     notify("top", "center", null, "danger", "animated bounceIn", "animated fadeOut",
    //                         'found user with the same user name!');
    //                 }else{
    //                     table.ajax.reload();
    //                     $("#create-user-modal").modal('hide');
    //                 }
    //             },
    //             'error' : function() {
    //             }
    //         });
    //     } else {
    //         $createUserForm.find(':submit').click();
    //         console.log("invalid form");
    //     }
    // });

    var $editUserForm = $('#edit-user-form');
    $editUserForm.on('submit', function(ev){
        ev.preventDefault();
        if ($editUserForm[0].checkValidity()) {
            var form = {
                "id" : $("#e_id").val(),
                "firstName" : $("#e_firstname").val(),
                "lastName" : $("#e_lastname").val(),
                "email" : $("#e_email").val(),
                "role" : $('input[name=e_role]:checked', '#edit-user-form').val()
            };

            $.ajax({
                'url' : "/user/user",
                'type' : 'put',
                'data' : JSON.stringify(form),
                'contentType' : "application/json",
                'dataType' : 'json',
                'success' : function(data) {
                    table.ajax.reload();
                    $("#edit-user-modal").modal('hide');
                },
                'error' : function() {
                }
            });
        } else {
            $editUserForm.find(':submit').click();
            console.log("invalid form");
        }
    });

    $('#edit-user-modal').on('show.bs.modal', function(event) {
        var button = $(event.relatedTarget);
        var id = button.data('id');
        $.ajax({
            'url': "/user/user/" + id,
            'type': 'get',
            'success': function(data) {
                var user = data.data;
                $('#e_id').val(user.id);
                $('#e_username').val(user.username);
                $('#e_firstname').val(user.firstName);
                $('#e_lastname').val(user.lastName);
                $('#e_email').val(user.email);
                $("input[name=e_role][value=" + user.role + "]").prop('checked', true);
            },
            'error': function() {}
        });
    });

    $("#disable-user-button").click(function() {
        var id = $(this).attr('data-id');
        var enable = false;
        $.ajax({
            'url': "/user/toggle_enable/" + id,
            'type': 'patch',
            'data': JSON.stringify(enable),
            'contentType': "application/json",
            'dataType': 'json',
            'success': function(data) {
                table.ajax.reload();
            },
            'error': function() {}
        });
    });

    $('#toggle-disable-modal').on('show.bs.modal', function(event) {
        var button = $(event.relatedTarget);
        var id = button.data('id');
        var modal = $(this);
        $("#disable-user-button").attr('data-id', id);
    });

    $("#enable-user-button").click(function() {
        var id = $(this).attr('data-id');
        var enable = true;
        $.ajax({
            'url': "/user/toggle_enable/" + id,
            'type': 'patch',
            'data': JSON.stringify(enable),
            'contentType': "application/json",
            'dataType': 'json',
            'success': function(data) {
                table.ajax.reload();
            },
            'error': function() {}
        });
    });

    $('#toggle-enable-modal').on('show.bs.modal', function(event) {
        var button = $(event.relatedTarget);
        var id = button.data('id');
        var modal = $(this);
        $("#enable-user-button").attr('data-id', id);
    });


    $("#reset-password-button").click(function() {
        var id = $(this).attr('data-id');
        $.ajax({
            'url': "/user/reset_password/" + id,
            'type': 'patch',
            'data': JSON.stringify(id),
            'contentType': "application/json",
            'dataType': 'json',
            'success': function(data) {
                table.ajax.reload();
            },
            'error': function() {}
        });
    });

    $('#reset-password-modal').on('show.bs.modal', function(event) {
        var button = $(event.relatedTarget);
        var id = button.data('id');
        var modal = $(this);
        $("#reset-password-button").attr('data-id', id);
    });

    function secondsToStr(seconds) {
        function numberEnding(number) {
            return (number > 1) ? 's' : '';
        }

        var temp = Math.floor(seconds);
        var years = Math.floor(temp / 31536000);
        if (years) {
            return years + ' year' + numberEnding(years);
        }
        var days = Math.floor((temp %= 31536000) / 86400);
        if (days) {
            return days + ' day' + numberEnding(days);
        }
        var hours = Math.floor((temp %= 86400) / 3600);
        if (hours) {
            return hours + ' hour' + numberEnding(hours);
        }
        var minutes = Math.floor((temp %= 3600) / 60);
        if (minutes) {
            return minutes + ' minute' + numberEnding(minutes);
        }
        var seconds = temp % 60;
        if (seconds) {
            return seconds + ' second' + numberEnding(seconds);
        }
        return 'N/A';
    }

    function estimateExecTime(dur, interval) {
        if (dur === undefined || interval === undefined)
            return 4;
        if (dur === 0 || interval === 0)
            return 4;
        var idx1 = dur / interval;
        if (idx1 < 16)
            return 0;
        else if (idx1 < 24)
            return 1;
        else if (idx1 < 32)
            return 2;
        else
            return 3;
    }

    function localeDateString(date) {
        var options = {
            hour12 : true,
            timeZone : "America/New_York"
        };
        return new Date(date).toLocaleString('en-US', options);
    }
});
