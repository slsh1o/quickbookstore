<#macro bookForm path isEditForm>
    <div class="form-group mt-3 col-md-6">
        <form action="${path}" method="post" enctype="multipart/form-data">
            <div class="form-group">
                <label for="title">Title</label>
                <input type="text" name="title" class="form-control" placeholder="Enter title" id="title" required
                       <#if isEditForm>value="${book.title}"</#if> />
            </div>
            <div class="form-group">
                <label for="description">Description</label>
                <textarea name="description" class="form-control" id="description" rows="4" maxlength="2000" required
                          <#if !isEditForm> placeholder="Enter description" </#if>><#if isEditForm>${book.description}</#if></textarea>
            </div>
            <div class="form-group">
                <label>Genres</label>
                <#list genres as genre>
                    <div class="form-check">
                        <input name="${genre}" <#if isEditForm>${book.genres?seq_contains(genre)?string("checked", "")}</#if> class="form-check-input" type="checkbox" id="genreCheck">
                        <label class="form-check-label" for="genreCheck">
                            ${genre}
                        </label>
                    </div>
                </#list>
            </div>
            <div class="form-group">
                <label for="author">Authors</label>
                <input aria-describedby="descriptionHelp" type="text" name="authors" class="form-control" placeholder="Enter authors separated by comma ','" id="author" required
                       <#if isEditForm>value="<#list book.authors as author>${author}<#sep>, </#list>"</#if> />
                <small id="descriptionHelp" class="form-text text-muted">Use comma to separate several authors like: Martin Jeannot, Linus Torvalds, ...</small>
            </div>
            <div class="form-group">
                <label for="price">Price</label>
                <input class="form-control" name="price" id="price" type="number" min="1" step="0.01" required
                       <#if isEditForm>value="${book.price?c}" <#else>value="0.99"</#if>
                />
            </div>
            <button type="submit" class="btn btn-primary"><#if isEditForm>Edit<#else>Add</#if></button>
            <#if isEditForm><input type="hidden" value="${book.id}" name="bookId"></#if>
        </form>
    </div>
</#macro>