<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Add Hotel Room</title>
</head>
<body>
    <h1>Add Hotel Room</h1>
    <form action= "<%= request.getContextPath  %>" method="post">
        <table>
            <tr>
                <td>Room Number</td>
                <td><input type="text" name="roomNumber" /></td>
            </tr>
            <tr>
                <td>Room Type</td>
                <td><input type="text" name="roomType" /></td>
            </tr>
            <tr>
                <td>Room Price</td>
                <td><input type="text" name="roomPrice" /></td>
            </tr>
            <tr>
                <td>Room Description</td>
                <td><input type="text" name="roomDescription" /></td>
            </tr>
            <tr>
                <td>Room Image</td>
                <td><input type="text" name="roomImage" /></td>
            </tr>
            <tr>
                <td>Room Status</td>
                <td><input type="text" name="roomStatus" /></td>
            </tr>
            <tr>
                <td>Hotel ID</td>
                <td><input type="text" name="hotelID" /></td>
            </tr>
            <tr>
                <td><input type="submit" value="Add" /></td>
            </tr>
        </table>
    </form>
</body>
</html>