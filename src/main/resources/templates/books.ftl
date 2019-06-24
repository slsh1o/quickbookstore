<#import "parts/common.ftl" as common>
<#import "parts/bookForm.ftl" as bf>

<@common.main>
<#--Collapse form-->
    <a class="btn btn-primary" data-toggle="collapse" href="#collapseAddBook" role="button" aria-expanded="false" aria-controls="collapseAddBook">
        Add new book
    </a>
    <div class="collapse" id="collapseAddBook">
        <@bf.bookForm "/books" false />
    </div>
<#--Books list-->
    <div class="card-columns">
    <#list books as book>
        <div class="card my-3" style="width: 18rem;">
            <div class="card-body">
                <h5 class="card-title">${book.title}</h5>
                <h6 class="card-text">${book.id}</h6>
                <p class="card-text">${book.description}</p>
            </div>
            <ul class="list-group list-group-flush">
                <li class="list-group-item">by <#list book.authors as author>${author}<#sep>, </#list></li>
                <li class="list-group-item">Genres: <#list book.genres as genre>${genre}<#sep>, </#list></li>
                <li class="list-group-item">$ ${book.price}</li>
            </ul>
            <div class="card-body">
                <a href="/books/edit/${book.id}" class="card-link">Edit</a>
            </div>
        </div>
    </#list>
    </div>
</@common.main>