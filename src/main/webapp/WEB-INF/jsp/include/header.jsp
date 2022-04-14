<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <title>Welcome</title>

    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>


</head>

<body>

<div class="container">

    <a href="/home">Home</a>
    <sec:authorize access="isAnonymous()">
        &nbsp | &nbsp <a href="/register">Sign Up</a>
        &nbsp | &nbsp <a href="/login">Login</a>
    </sec:authorize>
    <sec:authorize access="isAuthenticated()">
        &nbsp | &nbsp <a href="/search">Characters</a>
        &nbsp | &nbsp <a href="/login/logout">Logout</a>
        &nbsp | &nbsp Logged in as <sec:authentication property="principal.username"/>
    </sec:authorize>

    <hr>
