<#import "parts/common.ftl" as c>
<@c.page>
<form action="/search" method="post">
    <a>Search by</a>
    <select name="filterName">
        <option value="category">Category</option>
        <option value="title">Title</option>
        <option value="text">Text</option>
    </select>
    <input type="text" name="filterValue" maxlength="20"/>
    <button type="submit">Search</button>
</form>
<a href="/" >off filter</a>
<table>
    <thead>
    <tr>
        <th>text</th>
        <th>title</th>
        <th>category</th>
        <th>date</th>
        <th></th>
        <th></th>
    </tr>
    </thead>
    <tbody>
    <#list newss as news>
    <tr>
        <td>${news.text}</td>
        <td>${news.title}</td>
        <td>${news.category.category}</td>
        <td>${news.date}</td>
        <td><a href="/remove/${news.id}">remove</button></td>
        <td><a href="/redact/${news.id}">redact</button></td>
    </tr>
    <#else>
    No message
    </#list>
    </tbody>
</table>
<a href="/add">add news</a>
</@c.page>