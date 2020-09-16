<template>
  <div class="starter-wrapper">
    <ul class="starter clearfix">
      <li class="starter-item news">
        <router-link :to="{ name: 'NewsPage'}">
          <img class="starter-item-cover" src="../assets/news.png">
          <h2>News</h2>
        </router-link>
      </li>
      <li class="starter-item note">
        <router-link :to="{ name: 'Home'}">
          <img class="starter-item-cover" src="../assets/note.png">
          <h2>Note</h2>
        </router-link>
      </li>
      <li class="starter-item shop">
        <router-link :to="{ name: 'ShopPage'}">
          <img class="starter-item-cover" src="../assets/shop.png">
          <h2>Shop</h2>
        </router-link>
      </li>
    </ul>
  </div>
</template>

<style scoped>
@import url('https://fonts.googleapis.com/css2?family=Amatic+SC:wght@700&display=swap');

body, ul {
  margin: 0;
  padding: 0;
}

li {
  list-style-type: none;
}

a { text-decoration: none; color: white; }
a:link { text-decoration: none; }
a:visited { text-decoration: none; }
a:hover { text-decoration: none; }

.clearfix:after {
  content: '';
  display: block;
  clear: both;
}

.starter-wrapper {
  max-width: 960px;
  margin: 50px auto;
}

.starter {
  background-color: #c5e5ed;

}

.starter-item {
  float: left;
  width: 33.333333333%;
  height: 530px;
  position: relative;
  line-height: 530px;
  transition: all 0.5s
}

.starter-item h2 {
  padding: 0 0.5em;
  transition: all 0.5s;
  font-family: 'Amatic SC', cursive;
  font-size: 0;
  opacity: 0;
}

.starter:hover .starter-item {
  width: 20%;
}

.starter:hover .starter-item-cover {
  transform: translate(-50%, -50%) rotate(0) scale(0.4);
}

.starter .starter-item:hover {
  width: 60%;
}

.starter .starter-item:hover h2 {
  opacity: 1;
  font-size: 7rem;
}

.starter-item-cover {
  position: absolute;
  left: 50%;
  top: 50%;
  transition: transform 0.5s;
  transform: translate(-50%, -50%) rotate(0) scale(0.5);
}

.starter-item:hover .starter-item-cover {
  transform: translate(-50%, -50%) scale(0.75);
}

.starter-item.news {
  background-color: #edcc98;
  text-align: right;
}

.starter-item.note {
  background-color: #ede9be;
  text-align: center;
}

.starter-item.shop {
  background-color: #c5e5ed;
}

.starter-item.news:hover .starter-item-cover {
  transform: translate(-95%,-50%) rotate(-10deg) scale(0.75);
}

.starter-item.note:hover .starter-item-cover {
  transform: translate(-50%, -50%) rotate(-20deg) scale(0.75);
}

.starter-item.shop:hover .starter-item-cover {
  transform: translate(-7%, -50%) rotate(10deg) scale(0.75);
}

</style>
