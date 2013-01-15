<html>
<head><title>Users and Permissions</title>
<body>
<div id="header">
    <H2>
        List of Users and Their Permissions
    </H2>
</div>

<div id="content">
    <table class="datatable">
        <tr>
            <th>Name</th>
            <th>Permissions</th>
        </tr>

    <#list model["users"] as user>
        <tr>
            <td>${user.name}</td>
            <td>${user.permissionNames}</td>
        </tr>
    </#list>
    </table>

</div>
</body>
</html>