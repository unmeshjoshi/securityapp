<html>
<head><title>Add Permissions</title>
<body>
<div id="header">
    <H2>
        Add Permissions
    </H2>
</div>

<div id="content">

    <fieldset>
        <legend>Add Permissions For ${admin.applicationNames}</legend>
        <form name="administrator" action="add-permissions" method="post">
            User Name:
            <select name="userName">
            <#list model["users"] as user>
                <option value="${user}">${user}</option>
            </#list>
            </select>

            <table>
            <#list model["permissions"] as permission>

                <tr>
                    <td><input type="checkbox" name="permission" value="${permission}">${permission}</td>
                </tr>
            </#list>
            </table>

            <input type="submit" value="   Save   "/>
        </form>
    </fieldset>
</div>
</body>
</html>