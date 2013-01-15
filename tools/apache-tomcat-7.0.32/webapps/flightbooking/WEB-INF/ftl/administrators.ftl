<html>
<head><title>Add Administrators</title>
<body>
<div id="header">
    <H2>
        Add Administrators
    </H2>
</div>

<div id="content">

    <fieldset>
        <legend>Add Administrator</legend>
        <form name="administrator" action="add-admin" method="post">
            Name: <input type="text" name="name"/> <br/>
            Applications:
            <select name="applicationNames">
                <#list model["applications"] as application>
                    <option value="${application.name}">${application.name}</option>
                </#list>
            </select>
            <br>
            <input type="submit" value="   Save   "/>
        </form>
    </fieldset>
    <br/>
    <table class="datatable">
        <tr>
            <th>Name</th>
            <th>Applications</th>
        </tr>
    <#list model["administrators"] as administrator>
        <tr>
            <td>${administrator.name}</td>
            <td>${administrator.applicationNames}</td>
        </tr>
    </#list>
    </table>

</div>
</body>
</html>