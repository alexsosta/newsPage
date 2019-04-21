<#macro message path isRedactForm>
<form action="${path}" method="post">
    <#if isRedactForm><input name="id" type="hidden" value="${news.id}"></#if>
    <div>
        <label>News title:</label>
        <div>
            <input type="text" name="title" maxlength="20" <#if isRedactForm>value="${news.title}"</#if>/>
        </div>
    </div>
    <div>
        <label>News text:</label>
        <div>
            <textarea name="text" cols="60" rows="10" maxlength="4000"><#if isRedactForm>${news.text}</#if></textarea></p>
        </div>
    </div>

    <div>
        <label>News category:</label>
        <div>
            <select name="category">
                <#if isRedactForm><option disabled value=${news.category.id}>${news.category.category}</option></#if>
                <#list categories as category>
                <option value=${category.id}>${category.category}</option>
                </#list>
            </select>
        </div>
    </div>
    <button type="submit">submit</button>
</form>
</#macro>