<#import "parts/common.ftl" as common>

<@common.main>
<#--Collapse form-->
    <a class="btn btn-primary" data-toggle="collapse" href="#collapseAddBook" role="button" aria-expanded="false" aria-controls="collapseAddBook">
        Add new book
    </a>
    <div class="collapse" id="collapseAddBook">
        <div class="form-group mt-3 col-md-6">
            <form method="post" enctype="multipart/form-data">
                <div class="form-group">
                    <label for="title">Title</label>
                    <input type="text" name="title" class="form-control" placeholder="Enter title" id="title"/>
                </div>
                <div class="form-group">
                    <label for="description">Description</label>
                    <input type="text" name="description" class="form-control" placeholder="Enter description" id="description"/>
                </div>
                <div class="form-group">
                    <label>Genres</label>
                    <#list genres as genre>
                        <div class="form-check">
                            <input name="${genre}" class="form-check-input" type="checkbox" id="genreCheck">
                            <label class="form-check-label" for="genreCheck">
                                ${genre}
                            </label>
                        </div>
                    </#list>
                </div>
                <div class="form-group">
                    <label for="author">Authors</label>
                    <input type="text" name="authors" class="form-control" placeholder="Enter authors separated by comma ','" id="author"/>
                </div>
                <button type="submit" class="btn btn-primary">Add</button>
                <div class="form-group input-sm">
                    <label for="price">Price</label>
                    <input class="form-control" name="price" id="price" type="number" min="1" step="0.01" value="0.99"/>
                </div>
            </form>
        </div>
    </div>
<#--Books list-->
    <#list books as book>
        <div class="card my-3" style="width: 18rem;">
            <div class="card-body">
                <h5 class="card-title">${book.title}</h5>
                <p class="card-text">${book.description}</p>
            </div>
            <ul class="list-group list-group-flush">
                <li class="list-group-item">by <#list book.authors as author>${author}<#sep>, </#list></li>
                <li class="list-group-item">Genres: <#list book.genres as genre>${genre}<#sep>, </#list></li>
                <li class="list-group-item">$ ${book.price}</li>
            </ul>
            <div class="card-body">
                <a href="/books/${book.id}" class="card-link">Edit</a>
            </div>
        </div>
    </#list>
</@common.main>