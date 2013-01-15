<html>
<head><title>Add Applications</title>
<body>
<div id="header">
    <H2>
        Add Applications
    </H2>
</div>

<div id="content">

    <fieldset>
        <legend>Add Application</legend>
        <form name="application" action="add-application" method="post">
            Name: <input type="text" name="name"/> <br/>
            Permissions: <input type="text" name="permissions"/> <br/>
            <input type="submit" value="   Save   "/>
        </form>
    </fieldset>
    <br/>
    <table class="datatable">
        <tr>
            <th>Name</th>
            <th>Permissions</th>
        </tr>
    <#list model["applications"] as application>
        <tr>
            <td>${application.name}</td>
            <td>${application.permissions}</td>
        </tr>
    </#list>
    </table>

</div>
</body>
</html>