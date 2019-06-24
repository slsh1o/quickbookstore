<#import "parts/common.ftl" as common>

<@common.main>
    <div class="form-group mt-3 col-md-6">
        <form action="/order" method="post" enctype="multipart/form-data">
            <div class="form-group">
                <h4>${book.title}</h4><h6>by <#list book.authors as author>${author}<#sep>, </#list></h6>
            </div>
            <div class="form-group">
                <label for="firstName">First name</label>
                <input type="text" name="firstName" class="form-control" id="firstName" placeholder="Enter first name" required>
            </div>
            <div class="form-group">
                <label for="lastName">Last name</label>
                <input type="text" name="lastName" class="form-control" id="lastName" placeholder="Enter last name" required>
            </div>
            <div class="form-group">
                <label for="address">Address</label>
                <input type="text" name="address" class="form-control" id="address" placeholder="Enter your address" required>
            </div>
            <div class="form-group">
                <label for="quantity">Quantity</label>
                <input class="form-control" name="quantity" id="quantity" type="number" min="1" step="1" required value="1"/>
            </div>
            <button type="submit" class="btn btn-primary">Buy now</button>
            <input type="hidden" value="${book.id}" name="bookId">
        </form>
    </div>
</@common.main>