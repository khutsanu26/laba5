<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ru">
<head>
    <meta charset="UTF-8">
    <title>Лабораторная работа 4: Платформа для развертывания программных продуктов (Вариант 26)</title>
    <link rel="icon" type="image/png" sizes="32x32" href="/favicon-32x32.png">
    <link rel="icon" type="image/png" sizes="16x16" href="/favicon-16x16.png">
    <link rel="stylesheet" href="styles.css">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1.0, user-scalable=0">
</head>

<body>
    <div class="wrapper">

    <header>
        <div class="logo">
            <a href="/">
            <span class="light__logo">Объём&nbsp;</span><span class="bold__logo">Шарового Сектора</span></a>
        </div>
    </header>

    <div class="result__area">

        <h2 class="result__caption">Результат<br></h2>
        <p class="result__string__1">${formattedResult} куб. м</p>
        <p class="result__string__2">${formattedResultInMm} куб. мм</p>
        <form action="${pageContext.request.contextPath}/MainForm">
            <button class="back__button" type="submit">НА ГЛАВНУЮ</button>
            <input type="hidden" name="first" value="${first}">
            <input type="hidden" name="second" value="${second}">
        </form>

    </div>

    <footer>
        <a href="https://github.com/abramov26/pi223team26">GitHub</a>
    </footer>

    </div>

</body>
</html>