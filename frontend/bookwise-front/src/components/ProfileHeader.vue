<template>
    <header>
  <div class="ph-container">
    <div class="ph-content">
      <div class="ph-image-container">
        <img :src="`src/assets/${imageName}.png`" alt="User profile img">
        <p>{{username}}</p>
      </div>
    </div>
    <nav>
      <ul>
        <!--li><a title="Reviews" accesskey="R" tabindex="1" href="#section1">Reviews</a></li>
        <li><a title="Favourites" accesskey="V" tabindex="2" href="#section2">Favourites</a></li-->
        <li><a title="Reviews" accesskey="R" tabindex="1" href="review">Reviews</a></li>
        <li><a title="Favourites" accesskey="V" tabindex="2" href="favourite">Favourites</a></li>
      </ul>
    </nav>
  </div>
</header>
</template>

<script>
  export default {
      name: "Profile",
      props: {
          imageName: {
              type: String,
              required: true
          }
      },
      data() {
        return{
          username: localStorage.getItem('username')
        }
      }
  }
</script>

<style>
.ph-container {
  display: flex;
  flex-direction: column;
  align-items: center;
  justify-content: center;
}

.ph-image-container {
  display: flex;
  align-items: center;
  justify-content: center;
  margin-bottom: 20px;
}

.ph-image-container img {
    width: 20%;
}

.ph-image-container p {
  margin-left: 10px; /* Espacio entre la imagen y el nombre de usuario */
}

nav {
text-align: center;
font-size: 18px; /* Tamaño de la fuente del menú de navegación */
border-bottom: 2px solid orange; /* Línea debajo del menú */
padding-bottom: 10px; /* Espacio entre el menú y la línea */
}

nav ul {
list-style: none;
padding: 0;
margin: 0;
display: flex;
justify-content: center;
}

nav ul li {
margin-right: 2.813em; /* Espacio entre los elementos de navegación */
}

nav ul li:last-child {
margin-right: 0; /* Elimina el margen derecho del último elemento */
}

nav ul li a{
  color: white;
}

</style>