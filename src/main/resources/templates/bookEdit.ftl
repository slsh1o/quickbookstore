<#import "parts/common.ftl" as common>
<#import "parts/bookForm.ftl" as bf>

<@common.main>
    Book editor
    <@bf.bookForm "/books/edit" true />
</@common.main>