<#ftl encoding="utf-8">
<html lang="en">
<head>
    <meta charset="UTF-8">
    <script>

    </script>
</head>
<body>
    <#if motion?has_content>
        <#list motion as m>
            <h4>Motion Sensor: </h4>${m}
        </#list>
    </#if>

    <#if water?has_content>
        <#list motion as m>
            <h4>Water Leak Sensor: </h4>${m}
        </#list>
    </#if>

    <#if door?has_content>
        <#list motion as m>
            <h4>Door Opening Sensor: </h4>${m}
        </#list>
    </#if>

    <#if shutter?has_content>
        <#list motion as m>
            <h4>Shutter Control Sensor: </h4>${m}
        </#list>
    </#if>

    <#if smoke?has_content>
        <#list motion as m>
            <h4>Smoke Sensor: </h4>${m}
        </#list>
    </#if>

    <#if light?has_content>
        <#list motion as m>
            <h4>Light Sensor: </h4>${m}
        </#list>
    </#if>
</body>
