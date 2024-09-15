var webconfig = {
    user: 'login',
    password: '',
    server: 'LAPTOP-I2KFVJQ2',
    database: 'TestDB',

    options: {
        encrypt: false // Use this if you're on Windows Azure 
    }
}

var express = require('express');
var sql = require('mssql');
var http = require('http');

var app = express();
var port = process.env.PORT || 8000;

var connection = new sql.Connection(webconfig, function (err) {
    var request = new sql.Request(connection);
    request.query('select * from Users', function (err, recordset) {
        if (err)      // ... error checks 
            console.log('Database connection error');

        console.dir("User Data: " + recordset);
    });
});


app.listen(port);
console.log(port + ' is the magic port');