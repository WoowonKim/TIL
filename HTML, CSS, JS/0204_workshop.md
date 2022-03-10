# 0204 WORKSHOP



## 1.  Semantic Tag

> 제시된 semantic.html과 semantic.css를 수정하여 다음 이미지와 같은 형태가 되도록 코드를 작성하시오.

``` html
<!DOCTYPE html>
<html lang="ko">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <link rel="stylesheet" href="semantic.css">
  <title>Layout Practice</title>
</head>
<body>
  <header class="bg-lightgrey magin-4px pad-4px bord-t">
    <h1 class="alig-cen">header</h1>
  </header>
  <nav class="bg-lightgrey magin-4px pad-4px bord-t">
    <h2>nav</h2>
  </nav>
  <div class="clearfix">
    <section class="bg-lightgrey section-tag bord-t">
      <h2>section</h2>
      <article class="bg-white bord-t">
        <h3>article1</h3>
      </article>
      <article class="bg-white bord-t">
        <h3>article2</h3>
      </article>
    </section >
    <aside class="bg-lightgrey aside-tag bord-t">
      <h2>aside</h2>
    </aside >
  </div>  
  <footer class="bg-lightgrey magin-4px pad-4px bord-t">
    <h2>footer</h2>
  </footer >
</body>
</html>
```

``` css

body {
  font-family: Arial;
  width: 800px;
}

section {
  float: left;
  margin-left: 4px;
}

aside { 
  float: right;
  margin-right: 4px;
}

.clearfix::after {
  content: "";
  display: block;
  clear: both;
}

.bg-white {
  background-color: white;
  margin: 8px;
}

.bg-lightgrey {
  background-color: lightgray;
}

.magin-4px {
  margin: 4px;
}

.pad-4px {
  padding: 4px;
}

.alig-cen {
  text-align: center;
}

.section-tag {
  width: 490px;
  height: 300px;
}

.aside-tag {
  width: 280px;
  height: 300px;
}

.bord-t {
  border: 1px solid black;
  border-radius: 4px;
}
```

