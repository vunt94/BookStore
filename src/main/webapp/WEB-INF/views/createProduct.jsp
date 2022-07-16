<!DOCTYPE html>
<html>
<head>
    <title>Create product</title>
    <link rel="stylesheet" href="productStyle.css">
</head>
<body>

<div class="container">
    <form action="action_page.php">
        <div class="row">
            <div class="col-25">
                <label for="pname">Product Name</label>
            </div>
            <div class="col-75">
                <input type="text" id="pname" name="productname" placeholder="Product name..">
            </div>
        </div>
        <div class="row">
            <div class="col-25">
                <label for="pamount">Amount</label>
            </div>
            <div class="col-75">
                <input type="text" id="pamount" name="productamount" placeholder="Product amount..">
            </div>
        </div>
        <div class="row">
            <div class="col-25">
                <label for="pprice">Price</label>
            </div>
            <div class="col-75">
                <input type="text" id="pprice" name="pprice" placeholder="Product price..">
            </div>
        </div>
        <div class="row">
            <div class="col-25">
                <label for="description">Description</label>
            </div>
            <div class="col-75">
                <textarea id="description" name="description" placeholder="Write something about product.." style="height:200px"></textarea>
            </div>
        </div>
        <div class="row">
            <div class="col-25">
                <label class="col-md-4 control-label" for="filebutton">Image</label>
            </div>
            <div class="col-75">
                <input id="filebutton" name="filebutton" class="input-file" type="file">
            </div>
        </div>
        <div class="row">
            <div class="col-25">
                <label for="aname">Author Name</label>
            </div>
            <div class="col-75">
                <input type="text" id="aname" name="authorname" placeholder="Author name..">
            </div>
        </div>
        <div class="row">
            <div class="col-25">
                <label for="publisher">Publisher</label>
            </div>
            <div class="col-75">
                <input type="date" id="publisher" name="publisher">
            </div>
        </div>
        <div class="row">
            <input type="submit" value="Submit">
        </div>
    </form>
</div>
</body>
</html>