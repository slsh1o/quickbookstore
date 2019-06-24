<#import "parts/common.ftl" as common>

<@common.main>
    <div class="container mb-4">
        <nav class="navbar navbar-expand-lg navbar-light bg-light">

            <button class="btn btn-secondary dropdown-toggle" type="button" id="dropdownMenuButton" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                Genres
            </button>
            <div class="dropdown-menu" aria-labelledby="dropdownMenuButton">
                <a class="dropdown-item" href="/">All genres</a>
                <#list genres as genre>
                    <a class="dropdown-item" href="?genreFilter=${genre}">${genre?capitalize}</a>
                </#list>
            </div>
            <div class="ml-2">
                <span class="badge badge-light">${genreFilter?ifExists?capitalize}</span>
            </div>
            <ul class="navbar-nav mr-auto">
            </ul>
            <form class="form-inline my-2 my-lg-0 mr-1">
                <input class="form-control mr-sm-2" name="filter" value="${filter?ifExists}" type="search" placeholder="Search" aria-label="Search">
                <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
            </form>
        </nav>
    </div>
    <div class="card-columns">
        <#list books as book>
            <div class="card my-3">
                <div class="card-body">
                    <h5 class="card-title"><b>${book.title}</b></h5>
                    <p class="card-text">${book.description}</p>
                </div>
                <ul class="list-group list-group-flush">
                    <li class="list-group-item">by <#list book.authors as author>${author}<#sep>, </#list></li>
                    <li class="list-group-item">Genres: <#list book.genres as genre>${genre?capitalize}<#sep>, </#list></li>
                    <li class="list-group-item">$ ${book.price}</li>
                </ul>
                <div class="card-body">
                    <a href="/order/${book.id}" class="card-link">Buy</a>
                </div>
            </div>
        <#else>
            <div class="card-body">
                No available books
            </div>
        </#list>
    </div>
</@common.main>