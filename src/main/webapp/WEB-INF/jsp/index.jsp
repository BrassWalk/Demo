<!DOCTYPE html>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html lang="en">
<head>
    <meta
            charset="utf-8"
            name="description"
            content="Web site created using create-react-app"
    />
    <link rel="shortcut icon" href="http://${host}/favicon.ico"/>
    <meta name="viewport" content="width=device-width, initial-scale=1"/>
    <meta name="theme-color" content="#000000"/>

    <link rel="apple-touch-icon" href="http://${host}/logo192.png"/>
    <title>React App</title>
</head>
<body>
    <script src="https://cdn.jsdelivr.net/npm/sockjs-client@1/dist/sockjs.min.js"></script>

    <script>
        window.webappconfig = {
            host: "${host}"
        }
    </script>

    <div id="root"></div>
    <script src="http://${host}/bundle.js"></script>
</body>
</html>
