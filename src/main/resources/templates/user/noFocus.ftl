<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>
    <div style="text-align: center">
        <a href="#" onclick="goBack()">你并没有关注任何人，或许你可以去看帖子找找想关注的人</a>
    </div>
</body>
<script>
    function goBack() {
        self.location=document.referrer;  //返回上一页
    }
</script>
</html>